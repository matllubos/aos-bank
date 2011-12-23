/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoring;

import backend.Backend_Service;
import clearing.Clearing_Service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author lubos
 */
@WebService(serviceName = "Scoring", portName="ScoringService")
public class ScoringService {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Backend.wsdl")
    private Backend_Service service_1;
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Clearing.wsdl")
    private Clearing_Service service;
    
    
    /**
     * Pomocná funkce, stejně jako u backendu
     * @param currency
     * @return 
     */
    private boolean isSupportedCurrency(String currency) {
        try {
            clearing.Clearing port = service.getClearingPort();
            boolean result = port.isSupportedCurrency(currency);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Pomocná funkce, stejně jako u backendu
     * @param currency
     * @return 
     */
    private BigDecimal exchngeMoney(BigDecimal amount, String fromCurrency, String toCurrency) {
        try { 
            clearing.Clearing port = service.getClearingPort();
            java.math.BigDecimal result = port.exchangeMoney(fromCurrency, toCurrency, amount);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    
    /**
     * Vrací číslo od 0 do 1
     * @param accountNumber
     * @param currency
     * @param amount
     * @return
     * @throws ScoringServiceException 
     */
    @WebMethod(operationName = "boint")
    public float boint(@WebParam(name = "accountNumber") int accountNumber, @WebParam(name = "currency") String currency, @WebParam(name = "amount") BigDecimal amount) throws ScoringServiceException {
        if (!isSupportedCurrency(currency)) {
            throw new ScoringServiceException("Měna " + currency + " není poporována");
        }
        if (!currency.equals("CZK")) {
            amount = exchngeMoney(amount, currency, "CZK");
        }
        if (amount.equals(BigDecimal.ZERO)) return 1;
        try { 
            backend.Backend port = service_1.getBackendPort();
            BigDecimal bankCapital = port.getAllCapital();
            if (bankCapital.compareTo(amount) < 0) return 0;
            
            float points = 50;
            int countBadPayments = port.getCountBadPayment(accountNumber);
            int countGoodPayments = port.getCountGoodPayment(accountNumber);
            BigDecimal accountMoney = port.getCurrentBalance(accountNumber, "CZK");
            points += countGoodPayments - countBadPayments * 10 - amount.divide(new BigDecimal(1000000)).floatValue() + (accountMoney.longValue() / amount.longValue()) * 10;
            float boint = (float)  points / 50;
            
            if (boint > 1) return 1;
            if (boint < 0) return 0;
            return boint;
            
        } catch (Exception ex) {
            throw new ScoringServiceException(ex.getMessage());
        }

        
        
    }
    
    
}
