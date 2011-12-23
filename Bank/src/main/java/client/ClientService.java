/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import backend.Backend_Service;
import backend.LoanData;
import backend.TransactionLogData;
import fileserver.Fileserver_Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import org.apache.cxf.attachment.ByteDataSource;
import scoring.Scoring_Service;

/**
 *
 * @author lubos
 */
@WebService(serviceName = "Client", portName="ClientPort")
public class ClientService {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Scoring.wsdl")
    private Scoring_Service service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Fileserver.wsdl")
    private Fileserver_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Backend.wsdl")
    private Backend_Service service;

    /**
     * Zkontroluje parametry a zavolá createAccount na backend
     * @param name
     * @param currency
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "createAccount")
    @WebMethod(operationName = "createAccount")
    public int createAccount(
            @WebParam(name = "name") String name,
            @WebParam(name = "currency") String currency)
            throws ClientServiceException {

        if (name.isEmpty() || currency.isEmpty()) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            backend.Backend port = service.getBackendPort();
            int result = port.createAccount(name, currency);
            return result;
        } catch (Exception ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClientServiceException("Nemohu vytvořit účet");
        }
    }

    /**
     * Zkontroluje zda jsou data správně zadané a vloží peníze
     * @param accountNumber
     * @param amount
     * @param currency
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "currentBalance")
    @WebMethod(operationName = "depositMoney")
    public BigDecimal depositMoney(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "currency") String currency)
            throws ClientServiceException {

        if (accountNumber <= 0 || currency.isEmpty() || amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            backend.Backend port = service.getBackendPort();
            BigDecimal result = port.depositMoney(accountNumber, amount, currency);
            return result;
        } catch (Exception ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClientServiceException("Účet neexistuje");
        }
    }

    /**
     * Zkontroluje zda jsou data správně zadané a vydá
     * @param accountNumber
     * @param amount
     * @param currency
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "currentBalance")
    @WebMethod(operationName = "withdrawMoney")
    public BigDecimal withdrawMoney(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "currency") String currency) throws ClientServiceException {
        if (accountNumber <= 0 || currency.isEmpty() || amount == null|| amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            backend.Backend port = service.getBackendPort();
            java.math.BigDecimal result = port.withdrawMoney(accountNumber, amount, currency);
            return result;
        } catch (Exception ex) {
            throw new ClientServiceException("Účet neexistuje nebo není na účtě dostatek peněz");
        }
    }

    /**
     * Zkontroluje data a zavolá backend
     * @param accountNumber
     * @param currency
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "balance", targetNamespace = "")
    @WebMethod(operationName = "getCurrentBalance")
    public java.math.BigDecimal getCurrentBalance(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "currency") String currency) throws ClientServiceException {
        if (accountNumber <= 0 || currency.isEmpty()) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            backend.Backend port = service.getBackendPort();
            java.math.BigDecimal result = port.getCurrentBalance(accountNumber, currency);
            return result;
        } catch (Exception ex) {
            throw new ClientServiceException("Účet neexistuje");
        }
    }

    /**
     * Zkontroluje data a zavolá backend
     * @param myAccount
     * @param targetAccount
     * @param targetBank
     * @param amount
     * @param currency
     * @throws ClientServiceException 
     */
    @WebMethod(operationName = "transferMoney")
    public void transferMoney(
            @WebParam(name = "myAccount") int myAccount,
            @WebParam(name = "targetAccount") int targetAccount,
            @WebParam(name = "targetBank") String targetBank,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "currency") String currency) throws ClientServiceException {

        if (myAccount <= 0 || currency.isEmpty() || targetBank.isEmpty()|| amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            backend.Backend port = service.getBackendPort();
            boolean result = port.transferMoney(myAccount, targetAccount, targetBank, amount, currency);
            if (!result) {
                throw new ClientServiceException("Převod se nepovedl");
            }
        } catch (Exception ex) {
            throw new ClientServiceException("Chyba v zadaných datach");
        }
    }

    /**
     * Zkontroluje data a zavolá fileserver
     * @param accountNumber
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "getAccouljntStatementResponse")
    @WebMethod(operationName = "getAccountStatement")
    public DataHandler getAccountStatement(
            @WebParam(name = "accountNumber") int accountNumber) throws ClientServiceException {
        if (accountNumber <= 0) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            fileserver.Fileserver port = service_1.getFileserverPort();
            byte[] result = port.getPrintout(accountNumber);
            return new DataHandler(new ByteDataSource(result));

        } catch (Exception ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClientServiceException("Nelze vytvořit výpis");
        }
    }

    /**
     * Vrátí číslo pujčky, pokud vrátí -1 pak se pujčka nevytvoří
     * @param accountNumber
     * @param currency
     * @param amount
     * @param months
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "loanNumber")
    @WebMethod(operationName = "createLoan")
    public int createLoan(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "months") int months) throws ClientServiceException {
        if (accountNumber <= 0 || currency.isEmpty() || months == 0|| amount.compareTo(BigDecimal.ZERO) <= 0) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, "sakre");
            throw new ClientServiceException("Data nesmí být prázdná");
        }

        try {


            backend.Backend port = service.getBackendPort();
            scoring.Scoring portS = service_2.getScoringPort();
            float boint = portS.boint(accountNumber, currency, amount);
            if (boint < 0.5) {
                return -1;
            }

            int result = port.createLoan(accountNumber, currency, amount, months);
            
            return result;
        } catch (Exception ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClientServiceException("Nemohu vytvořit pujčku");
        }
    }

    /**
     * Zaplatí pujčku
     * @param loanNumber
     * @param currency
     * @param amount
     * @return
     * @throws ClientServiceException 
     */
    @WebResult(name = "remainMoney")
    @WebMethod(operationName = "paidLoan")
    public BigDecimal paidLoan(
            @WebParam(name = "loanNumber") int loanNumber,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "amount") BigDecimal amount) throws ClientServiceException {
        if (loanNumber <= 0 || currency.isEmpty()|| amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ClientServiceException("Data nesmí být prázdná");
        }
        try {
            backend.Backend port = service.getBackendPort();
            java.math.BigDecimal result = port.paidPayment(loanNumber, currency, amount);
            return result;
        } catch (Exception ex) {
            return amount;
        }

    }

    /**
     * Vrátí seznam všech transakcí
     * @param accountNumber
     * @return 
     */
    @WebResult(name = "transactions", targetNamespace = "")
    @WebMethod(operationName = "getTransactions")
    public List<TransactionLogData> getTransactions(
            @WebParam(name = "accountNumber") int accountNumber) throws ClientServiceException {

        try {
            backend.Backend port = service.getBackendPort();
            java.util.List<backend.TransactionLogData> result = port.getTransactions(accountNumber);
            return result;
        } catch (Exception ex) {
            throw new ClientServiceException("Žádné transakce pro tento účet neexistují");
        }

    }

    /**
     * Vrátí seznam pujček
     * @param accountNumber
     * @return 
     */
    @WebResult(name = "loans")
    @WebMethod(operationName = "getLoans")
    public List<LoanData> getLoans(@WebParam(name = "accountNumber") int accountNumber) throws ClientServiceException {

        try {
            backend.Backend port = service.getBackendPort();
            java.util.List<backend.LoanData> result = port.getLoans(accountNumber);
            return result;
        } catch (Exception ex) {
            throw new ClientServiceException("Žádné pujčky pro tento účet neexistují");
        }
    }

    /**
     * vrátí True v případě, že služba existuje
     * @param accountNumber
     * @return 
     */
    @WebResult(name = "existAccountResponse")
    @WebMethod(operationName = "existAccount")
    public boolean existAccount(
            @WebParam(name = "accountNumber") int accountNumber) {
        try {
            backend.Backend port = service.getBackendPort();
            boolean result = port.existAccount(accountNumber);
            return result;
        } catch (Exception ex) {
            return false;
        }

    }

    /**
     * Zaplatí splátku pujčky
     * @param loanNumber
     * @param currency
     * @param amount
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "remainMoney")
    @WebMethod(operationName = "paidPayment")
    public BigDecimal paidPayment(
            @WebParam(name = "loanNumber") int loanNumber,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "amount") BigDecimal amount)
            throws ClientServiceException {
        if (loanNumber <=0 || amount.compareTo(BigDecimal.ZERO) <= 0) throw new ClientServiceException("Špatně zadaná data");
        try {
            backend.Backend port = service.getBackendPort();
            BigDecimal result = port.paidPayment(loanNumber, currency, amount);
            return result;
        } catch (Exception ex) {
            return amount;
        }
    }

    /**
     * Zjistí zda je měna podporována
     * @param currency
     * @return 
     */
    @WebResult(name = "interestRate")
    @WebMethod(operationName = "getInterestRate")
    public float getInterestRate() throws ClientServiceException {

        try {
            backend.Backend port = service.getBackendPort();
            float result = port.getInterestRate();
            return result;
        } catch (Exception ex) {
            throw new ClientServiceException("Úrok nelze zjistit");
        }

    }

    /**
     * Zjistí zda je měna podporována
     * @param currency
     * @return 
     */
    @WebResult(name = "isSupportedCurrencyResult")
    @WebMethod(operationName = "isSupportedCurrency")
    public boolean isSupportedCurrency(String currency) {
        try {
            backend.Backend port = service.getBackendPort();
            boolean result = port.isSupportedCurrency(currency);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }
}
