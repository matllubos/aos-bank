
package clearing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clearing package. 
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

    private final static QName _ExchangeMoney_QNAME = new QName("http://clearing/", "exchangeMoney");
    private final static QName _GetBankIdResponse_QNAME = new QName("http://clearing/", "getBankIdResponse");
    private final static QName _IsSupportedCurrency_QNAME = new QName("http://clearing/", "isSupportedCurrency");
    private final static QName _TransferMoney_QNAME = new QName("http://clearing/", "transferMoney");
    private final static QName _TransferMoneyResponse_QNAME = new QName("http://clearing/", "transferMoneyResponse");
    private final static QName _GetBankId_QNAME = new QName("http://clearing/", "getBankId");
    private final static QName _IsSupportedCurrencyResponse_QNAME = new QName("http://clearing/", "isSupportedCurrencyResponse");
    private final static QName _ExchangeMoneyResponse_QNAME = new QName("http://clearing/", "exchangeMoneyResponse");
    private final static QName _ClearingException_QNAME = new QName("http://clearing/", "ClearingException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clearing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransferMoneyResponse }
     * 
     */
    public TransferMoneyResponse createTransferMoneyResponse() {
        return new TransferMoneyResponse();
    }

    /**
     * Create an instance of {@link TransferMoney }
     * 
     */
    public TransferMoney createTransferMoney() {
        return new TransferMoney();
    }

    /**
     * Create an instance of {@link IsSupportedCurrencyResponse }
     * 
     */
    public IsSupportedCurrencyResponse createIsSupportedCurrencyResponse() {
        return new IsSupportedCurrencyResponse();
    }

    /**
     * Create an instance of {@link ExchangeMoneyResponse }
     * 
     */
    public ExchangeMoneyResponse createExchangeMoneyResponse() {
        return new ExchangeMoneyResponse();
    }

    /**
     * Create an instance of {@link GetBankIdResponse }
     * 
     */
    public GetBankIdResponse createGetBankIdResponse() {
        return new GetBankIdResponse();
    }

    /**
     * Create an instance of {@link IsSupportedCurrency }
     * 
     */
    public IsSupportedCurrency createIsSupportedCurrency() {
        return new IsSupportedCurrency();
    }

    /**
     * Create an instance of {@link ClearingException }
     * 
     */
    public ClearingException createClearingException() {
        return new ClearingException();
    }

    /**
     * Create an instance of {@link ExchangeMoney }
     * 
     */
    public ExchangeMoney createExchangeMoney() {
        return new ExchangeMoney();
    }

    /**
     * Create an instance of {@link GetBankId }
     * 
     */
    public GetBankId createGetBankId() {
        return new GetBankId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExchangeMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "exchangeMoney")
    public JAXBElement<ExchangeMoney> createExchangeMoney(ExchangeMoney value) {
        return new JAXBElement<ExchangeMoney>(_ExchangeMoney_QNAME, ExchangeMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "getBankIdResponse")
    public JAXBElement<GetBankIdResponse> createGetBankIdResponse(GetBankIdResponse value) {
        return new JAXBElement<GetBankIdResponse>(_GetBankIdResponse_QNAME, GetBankIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsSupportedCurrency }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "isSupportedCurrency")
    public JAXBElement<IsSupportedCurrency> createIsSupportedCurrency(IsSupportedCurrency value) {
        return new JAXBElement<IsSupportedCurrency>(_IsSupportedCurrency_QNAME, IsSupportedCurrency.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "transferMoney")
    public JAXBElement<TransferMoney> createTransferMoney(TransferMoney value) {
        return new JAXBElement<TransferMoney>(_TransferMoney_QNAME, TransferMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "transferMoneyResponse")
    public JAXBElement<TransferMoneyResponse> createTransferMoneyResponse(TransferMoneyResponse value) {
        return new JAXBElement<TransferMoneyResponse>(_TransferMoneyResponse_QNAME, TransferMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "getBankId")
    public JAXBElement<GetBankId> createGetBankId(GetBankId value) {
        return new JAXBElement<GetBankId>(_GetBankId_QNAME, GetBankId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsSupportedCurrencyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "isSupportedCurrencyResponse")
    public JAXBElement<IsSupportedCurrencyResponse> createIsSupportedCurrencyResponse(IsSupportedCurrencyResponse value) {
        return new JAXBElement<IsSupportedCurrencyResponse>(_IsSupportedCurrencyResponse_QNAME, IsSupportedCurrencyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExchangeMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "exchangeMoneyResponse")
    public JAXBElement<ExchangeMoneyResponse> createExchangeMoneyResponse(ExchangeMoneyResponse value) {
        return new JAXBElement<ExchangeMoneyResponse>(_ExchangeMoneyResponse_QNAME, ExchangeMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearingException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clearing/", name = "ClearingException")
    public JAXBElement<ClearingException> createClearingException(ClearingException value) {
        return new JAXBElement<ClearingException>(_ClearingException_QNAME, ClearingException.class, null, value);
    }

}
