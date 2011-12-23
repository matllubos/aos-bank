package backend;

import backend.data.AccountData;
import backend.data.LoanData;
import backend.data.TransactionLogData;
import backend.db.Account;
import backend.db.Loan;
import backend.db.Log;
import backend.db.Payment;
import clearing.Clearing_Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
@WebService(serviceName = "Backend", portName="BackendPort")
public class BackendService {

    
    public static float interestRate = 10;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Clearing.wsdl")
    private Clearing_Service service;

    //----------------------pomocné funkce pro komunikaci s Clearing-----------------------
    
      

    private BigDecimal exchngeMoney(BigDecimal amount, String fromCurrency, String toCurrency) {

        try {
            clearing.Clearing port = service.getClearingPort();
            java.math.BigDecimal result = port.exchangeMoney(fromCurrency, toCurrency, amount);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isThisBank(String bank) {

        try {
            clearing.Clearing port = service.getClearingPort();
            java.lang.String result = port.getBankId();
            return bank.equals(result);
        } catch (Exception ex) {
            return false;
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
            clearing.Clearing port = service.getClearingPort();
            boolean result = port.isSupportedCurrency(currency);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }
    
    /**
     * Zjistí zda je měna podporována
     * @param currency
     * @return 
     */
    @WebResult(name = "interestRate")
    @WebMethod(operationName = "getInterestRate")
    public float getInterestRate(){
        return interestRate;
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
        Account account = Account.get(accountNumber);
        if (account != null) {
            return true;
        }
        return false;
    }

    /**
     * Vytvoří nový účet a vrátí id
     * @param name
     * @param currency
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "accountNumber")
    @WebMethod(operationName = "createAccount")
    public int createAccount(
            @WebParam(name = "name") String name,
            @WebParam(name = "currency") String currency)
            throws BackendServiceException {

        if (!isSupportedCurrency(currency)) {
            throw new BackendServiceException("Měna " + currency + " není poporována");
        }
        Account account = new Account(currency, name);
        account.save();
        return (int) account.id;
    }

    /**
     * Vloží peníze na účet
     * @param accountNumber
     * @param amount
     * @param currency
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "currentBalance", targetNamespace = "")
    @WebMethod(operationName = "depositMoney")
    public BigDecimal depositMoney(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "currency") String currency)
            throws BackendServiceException {

        if (!isSupportedCurrency(currency)) {
            throw new BackendServiceException("Měna " + currency + " není poporována");
        }
        Account account = Account.get(accountNumber);
        if (!currency.equals(account.currency)) {
            amount = exchngeMoney(amount, currency, account.currency);
        }
        Log log = new Log("Vlozeny penize na ucet", amount, account);
        log.save();
        
        Log logTest = Log.get(log.id);
        System.out.println(logTest.description);
        
        account.money = account.money.add(amount);
        account.save();
        return amount;

    }

    /**
     * Vybere peníze z účtu
     * @param accountNumber
     * @param amount
     * @param currency
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "currentBalance", targetNamespace = "")
    @WebMethod(operationName = "withdrawMoney")
    public BigDecimal withdrawMoney(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "currency") String currency) throws BackendServiceException {
        if (!isSupportedCurrency(currency)) {
            throw new BackendServiceException("Měna " + currency + " není poporována");
        }

        Account account = Account.get(accountNumber);
        if (account == null) {
            throw new BackendServiceException("Účet neexistuje");
        }
        BigDecimal amountToAccount = amount;
        if (!currency.equals(account.currency)) {
            amountToAccount = exchngeMoney(amount, currency, account.currency);
        }
        if (account.money.compareTo(amount) < 0) {
            throw new BackendServiceException("Na účtě není dostatek peněz");
        }

        Log log = new Log("Vybrany penize z uctu", amount.negate(), account);
        log.save();
        
        
        account.money = account.money.subtract(amountToAccount);
        account.save();
        return amount;
    }

    /**
     * Vrátí současný stav účtu v aktuální měně
     * @param accountNumber
     * @param currency
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "balance", targetNamespace = "")
    @WebMethod(operationName = "getCurrentBalance")
    public java.math.BigDecimal getCurrentBalance(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "currency") String currency)
            throws BackendServiceException {

        if (!isSupportedCurrency(currency)) {
            throw new BackendServiceException("Měna " + currency + " není poporována");
        }
        Account account = Account.get(accountNumber);
        if (account == null) {
            throw new BackendServiceException("Účet neexistuje");
        }
        BigDecimal amount = account.money;
        if (!currency.equals(account.currency)) {
            amount = exchngeMoney(amount, account.currency, currency);
        }
        return amount;

    }

    /**
     * Převede peníze na jiný účet
     * @param myAccount
     * @param targetAccount
     * @param targetBank
     * @param amount
     * @param currency
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "sent")
    @WebMethod(operationName = "transferMoney")
    public boolean transferMoney(
            @WebParam(name = "myAccount") int myAccount,
            @WebParam(name = "targetAccount") int targetAccount,
            @WebParam(name = "targetBank") String targetBank,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "currency") String currency) throws BackendServiceException {

        if (!isSupportedCurrency(currency)) {
            throw new BackendServiceException("Měna " + currency + " není poporována");
        }

        Account accountFrom = Account.get(myAccount);
        BigDecimal amountFrom = amount;
        if (!currency.equals(accountFrom.currency)) {
            amountFrom = exchngeMoney(amount, currency, accountFrom.currency);
        }
        if (accountFrom.money.compareTo(amountFrom) < 0) {
            throw new BackendServiceException("Na zdrojovém účtě není dostatek peněz");
        }

        if (isThisBank(targetBank)) {

            if (!addTransferPayment(targetAccount, currency, amount, myAccount, "matllubo")) {
                return false;
            }


        } else {
            try {
                clearing.Clearing port = service.getClearingPort();
                port.transferMoney(myAccount, targetAccount, targetBank, amount, currency);
            } catch (Exception ex) {
                return false;
            }
        }
        accountFrom.money = accountFrom.money.subtract(amountFrom);
        accountFrom.save();
        Log logFrom = new Log("Prevedeny penize ve prospech uctu " + targetAccount + "/" + targetBank, amountFrom.negate(), accountFrom);
        logFrom.save();
        return true;
    }

    /**
     * Vytvoří pujčku
     * @param accountNumber
     * @param currency
     * @param amount
     * @param months
     * @return 
     */
    @WebResult(name = "loanNumber")
    @WebMethod(operationName = "createLoan")
    public int createLoan(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "months") int months) throws BackendServiceException {
        
        
                
        
        Account account = Account.get(accountNumber);
        if (account == null) {
            throw new BackendServiceException("Účet neexistuje");
        }
        Loan loan = new Loan(account, interestRate, currency, amount, months);
        if (!currency.equals(account.currency)) {
            amount = exchngeMoney(amount, currency, account.currency);
        }
        
       
        Log log = new Log("Vytvorena pujcka", amount, account);
        log.save();
        account.money = account.money.add(amount);
        account.save();
        return (int) loan.id;
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
            throws BackendServiceException {
        if (!isSupportedCurrency(currency)) {
            throw new BackendServiceException("Měna " + currency + " není poporována");
        }

        Loan loan = Loan.get(loanNumber);
        if (loan == null) {
            throw new BackendServiceException("Pujčka s tímto identifikátorem neexistuje");
        }
        amount = new BigDecimal(5000);
        if (!currency.equals(loan.currency)) {
            amount = exchngeMoney(amount, currency, loan.currency);
        }
        return loan.paid(amount);
    }

    /**
     * Nastaví procenta pujčky
     * @param interestRate 
     */
    @WebMethod(operationName = "setInterestRate")
    public void setInterestRate(@WebParam(name = "interestRate") float interestRate) {
        
        BackendService.interestRate = interestRate;
    }

    /**
     * Vrátí počet plateb
     * @param accountNumber
     * @return 
     */
    @WebMethod(operationName = "getCountBadPayment")
    public int getCountBadPayment(@WebParam(name = "accountNumber") int accountNumber) {
        List<Loan> loans = Loan.filter("account = " + accountNumber);
        int count = 0;
        for (Loan loan : loans) {
            count += Payment.filter("loan = " + loan.id + " and paid_in_time = 0").size();
        }

        return count;
    }

    /**
     * Vrátí počet správných plateb
     * @param accountNumber
     * @return
     * @throws BackendServiceException 
     */
    @WebMethod(operationName = "getCountGoodPayment")
    public int getCountGoodPayment(@WebParam(name = "accountNumber") int accountNumber) throws BackendServiceException {
        List<Loan> loans = Loan.filter("account = " + accountNumber);
        int count = 0;
        for (Loan loan : loans) {
            count += Payment.filter("loan = " + loan.id + " and paid_in_time = 1 and paid = 1").size();
        }

        return count;
    }

    /**
     * Vrátí celkový kapitál banky
     * @return 
     */
    @WebMethod(operationName = "getAllCapital")
    public BigDecimal getAllCapital() {
        BigDecimal capital = new BigDecimal(0);
        for (Account account : Account.all()) {
            BigDecimal amount = account.money;
            if (!"CZK".equals(account.currency)) {
                amount = exchngeMoney(amount, account.currency, "CZK");
            }
            capital = capital.add(amount);
        }
        return capital;
    }
    
    /**
     * Vrátí seznam všech transakcí
     * @param accountNumber
     * @return 
     */
    @WebResult(name = "transactions", targetNamespace = "")
    @WebMethod(operationName = "getTransactions")
    public List<TransactionLogData> getTransactions(@WebParam(name = "accountNumber") int accountNumber) throws BackendServiceException {
        Account account = Account.get(accountNumber);
        if (account == null) {
            throw new BackendServiceException("Účet neexistuje");
        }
        
        List<TransactionLogData> out = new ArrayList<TransactionLogData>();
        List<Log> logs = Log.filter("account = " + accountNumber);
        int i = 0;
        for (Log log : logs) {
            TransactionLogData transaction = log.getTransactionLog();
            transaction.setCurrency(account.currency);
            out.add(transaction);
        }
        return out;
    }

    /**
     * Vrátí seznam pujček
     * @param accountNumber
     * @return 
     */
    @WebResult(name = "loans")
    @WebMethod(operationName = "getLoans")
    public List<LoanData> getLoans(@WebParam(name = "accountNumber") int accountNumber) {
        List<LoanData> out = new ArrayList<LoanData>();
        List<Loan> loans = Loan.filter("account = " + accountNumber);
        int i = 0;
        for (Loan loan : loans) {
            out.add(loan.getLoan());
        }
        return out;
    }

    /**
     * Vloží převod na účet
     * @param accountNumber
     * @param currency
     * @param amount
     * @param accountFromNumber
     * @param bankCode
     * @return 
     */
    @WebResult(name = "complete")
    @WebMethod(operationName = "addTransferPayment")
    public boolean addTransferPayment(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "accountFromNumber") int accountFromNumber,
            @WebParam(name = "bankCode") String bankCode) {
        
        if (amount.compareTo(BigDecimal.ZERO) <= 0) return false;
        Account account = Account.get(accountNumber);
        if (account == null) {
            return false;
        }
        if (!currency.equals(account.currency)) {
            amount = exchngeMoney(amount, currency, account.currency);
        }

        Log logTo = new Log("Prijaty penize z uctu " + accountFromNumber + "/" + bankCode, amount, account);
        logTo.save();
        account.money = account.money.add(amount);
        account.save();
        return true;

    }

    /**
     * Zruší převod
     * @param accountNumber
     * @param currency
     * @param amount
     * @param accountToNumber
     * @param bankCode 
     */
    @WebMethod(operationName = "cancelTransferPaymentToAccount")
    public void cancelTransferPaymentToAccount(
            @WebParam(name = "accountNumber") int accountNumber,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "amount") BigDecimal amount,
            @WebParam(name = "accountFromNumber") int accountToNumber,
            @WebParam(name = "bankCode") String bankCode) {
        Account account = Account.get(accountNumber);
        if (!currency.equals(account.currency)) {
            amount = exchngeMoney(amount, currency, account.currency);
        }

        Log logTo = new Log("Zrusena pujcka ve prospech uctu " + accountToNumber + "/" + bankCode, amount, account);
        logTo.save();
        account.money = account.money.add(amount);
        account.save();

    }

    /**
     * Vrátí číslo účtu
     * @param accountNumber
     * @return
     * @throws BackendServiceException 
     */
    @WebResult(name = "account")
    @WebMethod(operationName = "getAccount")
    public AccountData getAccount(@WebParam(name = "accountNumber") int accountNumber) throws BackendServiceException {
        Account account = Account.get(accountNumber);
        if (account == null) {
            throw new BackendServiceException("Účet s tímto číslem neexistuje");
        }
        return account.getAccountData();
    }
}
