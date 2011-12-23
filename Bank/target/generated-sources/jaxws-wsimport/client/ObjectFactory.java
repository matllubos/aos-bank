
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TransferMoney_QNAME = new QName("http://client/", "transferMoney");
    private final static QName _PaidPaymentResponse_QNAME = new QName("http://client/", "paidPaymentResponse");
    private final static QName _ExistAccount_QNAME = new QName("http://client/", "existAccount");
    private final static QName _WithdrawMoney_QNAME = new QName("http://client/", "withdrawMoney");
    private final static QName _GetTransactionsResponse_QNAME = new QName("http://client/", "getTransactionsResponse");
    private final static QName _GetAccountStatement_QNAME = new QName("http://client/", "getAccountStatement");
    private final static QName _CreateLoan_QNAME = new QName("http://client/", "createLoan");
    private final static QName _GetLoans_QNAME = new QName("http://client/", "getLoans");
    private final static QName _PaidLoan_QNAME = new QName("http://client/", "paidLoan");
    private final static QName _WithdrawMoneyResponse_QNAME = new QName("http://client/", "withdrawMoneyResponse");
    private final static QName _PaidLoanResponse_QNAME = new QName("http://client/", "paidLoanResponse");
    private final static QName _GetTransactions_QNAME = new QName("http://client/", "getTransactions");
    private final static QName _GetCurrentBalanceResponse_QNAME = new QName("http://client/", "getCurrentBalanceResponse");
    private final static QName _CreateAccountResponse_QNAME = new QName("http://client/", "createAccountResponse");
    private final static QName _TransferMoneyResponse_QNAME = new QName("http://client/", "transferMoneyResponse");
    private final static QName _ClientException_QNAME = new QName("http://client/", "ClientException");
    private final static QName _GetInterestRate_QNAME = new QName("http://client/", "getInterestRate");
    private final static QName _GetAccountStatementResponse_QNAME = new QName("http://client/", "getAccountStatementResponse");
    private final static QName _GetCurrentBalance_QNAME = new QName("http://client/", "getCurrentBalance");
    private final static QName _DepositMoneyResponse_QNAME = new QName("http://client/", "depositMoneyResponse");
    private final static QName _GetLoansResponse_QNAME = new QName("http://client/", "getLoansResponse");
    private final static QName _IsSupportedCurrency_QNAME = new QName("http://client/", "isSupportedCurrency");
    private final static QName _DepositMoney_QNAME = new QName("http://client/", "depositMoney");
    private final static QName _GetInterestRateResponse_QNAME = new QName("http://client/", "getInterestRateResponse");
    private final static QName _PaidPayment_QNAME = new QName("http://client/", "paidPayment");
    private final static QName _CreateAccount_QNAME = new QName("http://client/", "createAccount");
    private final static QName _CreateLoanResponse_QNAME = new QName("http://client/", "createLoanResponse");
    private final static QName _IsSupportedCurrencyResponse_QNAME = new QName("http://client/", "isSupportedCurrencyResponse");
    private final static QName _ExistAccountResponse_QNAME = new QName("http://client/", "existAccountResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaidLoan }
     * 
     */
    public PaidLoan createPaidLoan() {
        return new PaidLoan();
    }

    /**
     * Create an instance of {@link WithdrawMoneyResponse }
     * 
     */
    public WithdrawMoneyResponse createWithdrawMoneyResponse() {
        return new WithdrawMoneyResponse();
    }

    /**
     * Create an instance of {@link PaidLoanResponse }
     * 
     */
    public PaidLoanResponse createPaidLoanResponse() {
        return new PaidLoanResponse();
    }

    /**
     * Create an instance of {@link GetLoansResponse }
     * 
     */
    public GetLoansResponse createGetLoansResponse() {
        return new GetLoansResponse();
    }

    /**
     * Create an instance of {@link IsSupportedCurrency }
     * 
     */
    public IsSupportedCurrency createIsSupportedCurrency() {
        return new IsSupportedCurrency();
    }

    /**
     * Create an instance of {@link PaidPayment }
     * 
     */
    public PaidPayment createPaidPayment() {
        return new PaidPayment();
    }

    /**
     * Create an instance of {@link CreateLoan }
     * 
     */
    public CreateLoan createCreateLoan() {
        return new CreateLoan();
    }

    /**
     * Create an instance of {@link ExistAccount }
     * 
     */
    public ExistAccount createExistAccount() {
        return new ExistAccount();
    }

    /**
     * Create an instance of {@link GetTransactions }
     * 
     */
    public GetTransactions createGetTransactions() {
        return new GetTransactions();
    }

    /**
     * Create an instance of {@link PaidPaymentResponse }
     * 
     */
    public PaidPaymentResponse createPaidPaymentResponse() {
        return new PaidPaymentResponse();
    }

    /**
     * Create an instance of {@link TransferMoneyResponse }
     * 
     */
    public TransferMoneyResponse createTransferMoneyResponse() {
        return new TransferMoneyResponse();
    }

    /**
     * Create an instance of {@link ExistAccountResponse }
     * 
     */
    public ExistAccountResponse createExistAccountResponse() {
        return new ExistAccountResponse();
    }

    /**
     * Create an instance of {@link CreateAccount }
     * 
     */
    public CreateAccount createCreateAccount() {
        return new CreateAccount();
    }

    /**
     * Create an instance of {@link GetAccountStatementResponse }
     * 
     */
    public GetAccountStatementResponse createGetAccountStatementResponse() {
        return new GetAccountStatementResponse();
    }

    /**
     * Create an instance of {@link GetInterestRateResponse }
     * 
     */
    public GetInterestRateResponse createGetInterestRateResponse() {
        return new GetInterestRateResponse();
    }

    /**
     * Create an instance of {@link DepositMoney }
     * 
     */
    public DepositMoney createDepositMoney() {
        return new DepositMoney();
    }

    /**
     * Create an instance of {@link GetLoans }
     * 
     */
    public GetLoans createGetLoans() {
        return new GetLoans();
    }

    /**
     * Create an instance of {@link GetTransactionsResponse }
     * 
     */
    public GetTransactionsResponse createGetTransactionsResponse() {
        return new GetTransactionsResponse();
    }

    /**
     * Create an instance of {@link WithdrawMoney }
     * 
     */
    public WithdrawMoney createWithdrawMoney() {
        return new WithdrawMoney();
    }

    /**
     * Create an instance of {@link CreateLoanResponse }
     * 
     */
    public CreateLoanResponse createCreateLoanResponse() {
        return new CreateLoanResponse();
    }

    /**
     * Create an instance of {@link GetInterestRate }
     * 
     */
    public GetInterestRate createGetInterestRate() {
        return new GetInterestRate();
    }

    /**
     * Create an instance of {@link IsSupportedCurrencyResponse }
     * 
     */
    public IsSupportedCurrencyResponse createIsSupportedCurrencyResponse() {
        return new IsSupportedCurrencyResponse();
    }

    /**
     * Create an instance of {@link ClientException }
     * 
     */
    public ClientException createClientException() {
        return new ClientException();
    }

    /**
     * Create an instance of {@link DepositMoneyResponse }
     * 
     */
    public DepositMoneyResponse createDepositMoneyResponse() {
        return new DepositMoneyResponse();
    }

    /**
     * Create an instance of {@link GetCurrentBalance }
     * 
     */
    public GetCurrentBalance createGetCurrentBalance() {
        return new GetCurrentBalance();
    }

    /**
     * Create an instance of {@link GetAccountStatement }
     * 
     */
    public GetAccountStatement createGetAccountStatement() {
        return new GetAccountStatement();
    }

    /**
     * Create an instance of {@link GetCurrentBalanceResponse }
     * 
     */
    public GetCurrentBalanceResponse createGetCurrentBalanceResponse() {
        return new GetCurrentBalanceResponse();
    }

    /**
     * Create an instance of {@link TransferMoney }
     * 
     */
    public TransferMoney createTransferMoney() {
        return new TransferMoney();
    }

    /**
     * Create an instance of {@link CreateAccountResponse }
     * 
     */
    public CreateAccountResponse createCreateAccountResponse() {
        return new CreateAccountResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "transferMoney")
    public JAXBElement<TransferMoney> createTransferMoney(TransferMoney value) {
        return new JAXBElement<TransferMoney>(_TransferMoney_QNAME, TransferMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaidPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "paidPaymentResponse")
    public JAXBElement<PaidPaymentResponse> createPaidPaymentResponse(PaidPaymentResponse value) {
        return new JAXBElement<PaidPaymentResponse>(_PaidPaymentResponse_QNAME, PaidPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExistAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "existAccount")
    public JAXBElement<ExistAccount> createExistAccount(ExistAccount value) {
        return new JAXBElement<ExistAccount>(_ExistAccount_QNAME, ExistAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "withdrawMoney")
    public JAXBElement<WithdrawMoney> createWithdrawMoney(WithdrawMoney value) {
        return new JAXBElement<WithdrawMoney>(_WithdrawMoney_QNAME, WithdrawMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getTransactionsResponse")
    public JAXBElement<GetTransactionsResponse> createGetTransactionsResponse(GetTransactionsResponse value) {
        return new JAXBElement<GetTransactionsResponse>(_GetTransactionsResponse_QNAME, GetTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountStatement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getAccountStatement")
    public JAXBElement<GetAccountStatement> createGetAccountStatement(GetAccountStatement value) {
        return new JAXBElement<GetAccountStatement>(_GetAccountStatement_QNAME, GetAccountStatement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "createLoan")
    public JAXBElement<CreateLoan> createCreateLoan(CreateLoan value) {
        return new JAXBElement<CreateLoan>(_CreateLoan_QNAME, CreateLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoans }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getLoans")
    public JAXBElement<GetLoans> createGetLoans(GetLoans value) {
        return new JAXBElement<GetLoans>(_GetLoans_QNAME, GetLoans.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaidLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "paidLoan")
    public JAXBElement<PaidLoan> createPaidLoan(PaidLoan value) {
        return new JAXBElement<PaidLoan>(_PaidLoan_QNAME, PaidLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "withdrawMoneyResponse")
    public JAXBElement<WithdrawMoneyResponse> createWithdrawMoneyResponse(WithdrawMoneyResponse value) {
        return new JAXBElement<WithdrawMoneyResponse>(_WithdrawMoneyResponse_QNAME, WithdrawMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaidLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "paidLoanResponse")
    public JAXBElement<PaidLoanResponse> createPaidLoanResponse(PaidLoanResponse value) {
        return new JAXBElement<PaidLoanResponse>(_PaidLoanResponse_QNAME, PaidLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getTransactions")
    public JAXBElement<GetTransactions> createGetTransactions(GetTransactions value) {
        return new JAXBElement<GetTransactions>(_GetTransactions_QNAME, GetTransactions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getCurrentBalanceResponse")
    public JAXBElement<GetCurrentBalanceResponse> createGetCurrentBalanceResponse(GetCurrentBalanceResponse value) {
        return new JAXBElement<GetCurrentBalanceResponse>(_GetCurrentBalanceResponse_QNAME, GetCurrentBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "createAccountResponse")
    public JAXBElement<CreateAccountResponse> createCreateAccountResponse(CreateAccountResponse value) {
        return new JAXBElement<CreateAccountResponse>(_CreateAccountResponse_QNAME, CreateAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "transferMoneyResponse")
    public JAXBElement<TransferMoneyResponse> createTransferMoneyResponse(TransferMoneyResponse value) {
        return new JAXBElement<TransferMoneyResponse>(_TransferMoneyResponse_QNAME, TransferMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "ClientException")
    public JAXBElement<ClientException> createClientException(ClientException value) {
        return new JAXBElement<ClientException>(_ClientException_QNAME, ClientException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInterestRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getInterestRate")
    public JAXBElement<GetInterestRate> createGetInterestRate(GetInterestRate value) {
        return new JAXBElement<GetInterestRate>(_GetInterestRate_QNAME, GetInterestRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountStatementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getAccountStatementResponse")
    public JAXBElement<GetAccountStatementResponse> createGetAccountStatementResponse(GetAccountStatementResponse value) {
        return new JAXBElement<GetAccountStatementResponse>(_GetAccountStatementResponse_QNAME, GetAccountStatementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getCurrentBalance")
    public JAXBElement<GetCurrentBalance> createGetCurrentBalance(GetCurrentBalance value) {
        return new JAXBElement<GetCurrentBalance>(_GetCurrentBalance_QNAME, GetCurrentBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "depositMoneyResponse")
    public JAXBElement<DepositMoneyResponse> createDepositMoneyResponse(DepositMoneyResponse value) {
        return new JAXBElement<DepositMoneyResponse>(_DepositMoneyResponse_QNAME, DepositMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoansResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getLoansResponse")
    public JAXBElement<GetLoansResponse> createGetLoansResponse(GetLoansResponse value) {
        return new JAXBElement<GetLoansResponse>(_GetLoansResponse_QNAME, GetLoansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsSupportedCurrency }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "isSupportedCurrency")
    public JAXBElement<IsSupportedCurrency> createIsSupportedCurrency(IsSupportedCurrency value) {
        return new JAXBElement<IsSupportedCurrency>(_IsSupportedCurrency_QNAME, IsSupportedCurrency.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "depositMoney")
    public JAXBElement<DepositMoney> createDepositMoney(DepositMoney value) {
        return new JAXBElement<DepositMoney>(_DepositMoney_QNAME, DepositMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInterestRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "getInterestRateResponse")
    public JAXBElement<GetInterestRateResponse> createGetInterestRateResponse(GetInterestRateResponse value) {
        return new JAXBElement<GetInterestRateResponse>(_GetInterestRateResponse_QNAME, GetInterestRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaidPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "paidPayment")
    public JAXBElement<PaidPayment> createPaidPayment(PaidPayment value) {
        return new JAXBElement<PaidPayment>(_PaidPayment_QNAME, PaidPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "createAccount")
    public JAXBElement<CreateAccount> createCreateAccount(CreateAccount value) {
        return new JAXBElement<CreateAccount>(_CreateAccount_QNAME, CreateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "createLoanResponse")
    public JAXBElement<CreateLoanResponse> createCreateLoanResponse(CreateLoanResponse value) {
        return new JAXBElement<CreateLoanResponse>(_CreateLoanResponse_QNAME, CreateLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsSupportedCurrencyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "isSupportedCurrencyResponse")
    public JAXBElement<IsSupportedCurrencyResponse> createIsSupportedCurrencyResponse(IsSupportedCurrencyResponse value) {
        return new JAXBElement<IsSupportedCurrencyResponse>(_IsSupportedCurrencyResponse_QNAME, IsSupportedCurrencyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExistAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client/", name = "existAccountResponse")
    public JAXBElement<ExistAccountResponse> createExistAccountResponse(ExistAccountResponse value) {
        return new JAXBElement<ExistAccountResponse>(_ExistAccountResponse_QNAME, ExistAccountResponse.class, null, value);
    }

}
