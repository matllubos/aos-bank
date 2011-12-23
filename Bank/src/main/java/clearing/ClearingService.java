/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clearing;

import clearing.tasks.FetchPaymentTask;
import clearing.tasks.GetPaymentsResult;
import clearing.tasks.SendPaymentsTask;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenterImplService;
import cz.cvut.felk.support.aos.sw.clearingcenter.Payment;
import cz.cvut.felk.support.aos.sw.exchangerates.ExchangeRatesImplService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author lubos
 */
@WebService(serviceName = "Clearing", portName="ClearingPort")
public class ClearingService {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/support.felk.cvut.cz/aos/sw/ClearingCenter.wsdl")
    private ClearingCenterImplService service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/support.felk.cvut.cz/aos/sw/ExchangeRates.wsdl")
    private ExchangeRatesImplService service;
    
    private static String id = "matllubo";
    public static String code = null;
    private static Timer timer = new Timer();
    private static boolean timerStarted = false;
    
    /**
     * Při prvním startu se zaregistruje a vytvoří služby
     */
    public ClearingService() {
        if (!timerStarted) {
            Logger.getLogger(ClearingService.class.getName()).log(Level.SEVERE, "start services");
            long delay = 1000 * 10;
            timerStarted = true;
            timer.schedule(new FetchPaymentTask(), delay, delay);
            timer.schedule(new GetPaymentsResult(), 3*delay, 3*delay);
            timer.schedule(new SendPaymentsTask(), 2*delay, 2*delay);
//            timer.schedule(new FetchPaymentTaskOtherBank(), delay, delay);
        }
        
    }

    /**
     * zaregistrování banky
     * @return 
     */
    private String register() {
        if (code == null) {
            try { 
                cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenter port = service_2.getClearingCenterImplPort();
                code = port.register(id);
                Logger.getLogger(ClearingService.class.getName()).log(Level.SEVERE, code);
            } catch (Exception ex) {
                Logger.getLogger(ClearingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return code;
    }

    /**
     * Převod peněz do jiné banky
     * @param fromCurrency
     * @param toCurrency
     * @param amount
     * @return
     * @throws ClearingServiceException 
     */
    @WebResult(name = "exchangedAmount")
    @WebMethod(operationName = "exchangeMoney")
    public BigDecimal exchangeMoney(
        @WebParam(name = "fromCurrency") String fromCurrency, 
        @WebParam(name = "toCurrency") String toCurrency, 
        @WebParam(name = "amount") BigDecimal amount) 
            throws ClearingServiceException {
        register();
        try { 
            cz.cvut.felk.support.aos.sw.exchangerates.ExchangeRates port = service.getExchangeRatesImplPort();
            java.math.BigDecimal exchangeRate = port.getExchangeRate(fromCurrency, toCurrency);
            return amount.multiply(exchangeRate);
        } catch (Exception ex) {
            Logger.getLogger(ClearingService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClearingServiceException("Jedna z měn není podporována");
        }
    }

    /**
     * Vrátí zda je měna podporovaná
     * @param currency
     * @return 
     */
    @WebResult(name = "isSupported")
    @WebMethod(operationName = "isSupportedCurrency")
    public boolean isSupportedCurrency(@WebParam(name = "currency") String currency) {
        register();
        try { 
            cz.cvut.felk.support.aos.sw.exchangerates.ExchangeRates port = service.getExchangeRatesImplPort();
            java.util.List<java.lang.String> currencies = port.getSupportedCurrencies();
            return currencies.contains(currency);
        } catch (Exception ex) {
            Logger.getLogger(ClearingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    
    /**
     * Převede peníze do jiné banky
     * @param myAccount
     * @param targetAccount
     * @param targetBank
     * @param amount
     * @param currency 
     */
    @WebMethod(operationName = "transferMoney")
    public void transferMoney(
            @WebParam(name = "myAccount") int myAccount, 
            @WebParam(name = "targetAccount") int targetAccount, 
            @WebParam(name = "targetBank") String targetBank, 
            @WebParam(name = "amount") BigDecimal amount, 
            @WebParam(name = "currency") String currency) {
        register();
        try { 
            List<Payment> payments = new ArrayList<Payment>();
            Payment payment = new Payment();
            payment.setAccountNumber(targetAccount);
            payment.setAmount(amount);
            payment.setCurrency(currency);
            payment.setSenderAccountNumber(myAccount);
            payment.setBankCode(targetBank);
            payment.setSenderBankCode(id);
            payments.add(payment);
            SendPaymentsTask.addPayment(payment);
            
        } catch (Exception ex) {
            Logger.getLogger(ClearingService.class.getName()).log(Level.SEVERE, null, ex);
        }



    
    }

    
    /**
     * Vrátí id banky
     * @return 
     */
    @WebResult(name = "isSupported")
    @WebMethod(operationName = "getBankId")
    public String getBankId() {
        return id;
    }
}
