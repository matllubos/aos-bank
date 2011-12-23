
package cz.cvut.felk.support.aos.sw.clearingcenter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.cvut.felk.support.aos.sw.clearingcenter package. 
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

    private final static QName _SendPaymentsFaultException_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "SendPaymentsFault_Exception");
    private final static QName _GetPaymentsResultFaultException_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "GetPaymentsResultFault_Exception");
    private final static QName _FetchPayments_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "fetchPayments");
    private final static QName _RegisterResponse_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "registerResponse");
    private final static QName _RegisterFaultException_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "RegisterFault_Exception");
    private final static QName _Register_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "register");
    private final static QName _FetchPaymentsFaultException_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "FetchPaymentsFault_Exception");
    private final static QName _SendPayments_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "sendPayments");
    private final static QName _SendPaymentsResponse_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "sendPaymentsResponse");
    private final static QName _GetPaymentsResultResponse_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "getPaymentsResultResponse");
    private final static QName _FetchPaymentsResponse_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "fetchPaymentsResponse");
    private final static QName _SetPaymentsResultResponse_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "setPaymentsResultResponse");
    private final static QName _SetPaymentsResult_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "setPaymentsResult");
    private final static QName _SetPaymentsResultFaultException_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "SetPaymentsResultFault_Exception");
    private final static QName _GetPaymentsResult_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ClearingCenter/", "getPaymentsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.cvut.felk.support.aos.sw.clearingcenter
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetPaymentsResult }
     * 
     */
    public SetPaymentsResult createSetPaymentsResult() {
        return new SetPaymentsResult();
    }

    /**
     * Create an instance of {@link SendPaymentsResponse }
     * 
     */
    public SendPaymentsResponse createSendPaymentsResponse() {
        return new SendPaymentsResponse();
    }

    /**
     * Create an instance of {@link FetchPaymentsFaultException }
     * 
     */
    public FetchPaymentsFaultException createFetchPaymentsFaultException() {
        return new FetchPaymentsFaultException();
    }

    /**
     * Create an instance of {@link RegisterFault }
     * 
     */
    public RegisterFault createRegisterFault() {
        return new RegisterFault();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link FetchPaymentsFault }
     * 
     */
    public FetchPaymentsFault createFetchPaymentsFault() {
        return new FetchPaymentsFault();
    }

    /**
     * Create an instance of {@link SetPaymentsResultFaultException }
     * 
     */
    public SetPaymentsResultFaultException createSetPaymentsResultFaultException() {
        return new SetPaymentsResultFaultException();
    }

    /**
     * Create an instance of {@link RegisterFaultException }
     * 
     */
    public RegisterFaultException createRegisterFaultException() {
        return new RegisterFaultException();
    }

    /**
     * Create an instance of {@link SendPaymentsFault }
     * 
     */
    public SendPaymentsFault createSendPaymentsFault() {
        return new SendPaymentsFault();
    }

    /**
     * Create an instance of {@link GetPaymentsResultFault }
     * 
     */
    public GetPaymentsResultFault createGetPaymentsResultFault() {
        return new GetPaymentsResultFault();
    }

    /**
     * Create an instance of {@link FetchPayments }
     * 
     */
    public FetchPayments createFetchPayments() {
        return new FetchPayments();
    }

    /**
     * Create an instance of {@link GetPaymentsResult }
     * 
     */
    public GetPaymentsResult createGetPaymentsResult() {
        return new GetPaymentsResult();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link SetPaymentsResultFault }
     * 
     */
    public SetPaymentsResultFault createSetPaymentsResultFault() {
        return new SetPaymentsResultFault();
    }

    /**
     * Create an instance of {@link SetPaymentsResultResponse }
     * 
     */
    public SetPaymentsResultResponse createSetPaymentsResultResponse() {
        return new SetPaymentsResultResponse();
    }

    /**
     * Create an instance of {@link GetPaymentsResultFaultException }
     * 
     */
    public GetPaymentsResultFaultException createGetPaymentsResultFaultException() {
        return new GetPaymentsResultFaultException();
    }

    /**
     * Create an instance of {@link GetPaymentsResultResponse }
     * 
     */
    public GetPaymentsResultResponse createGetPaymentsResultResponse() {
        return new GetPaymentsResultResponse();
    }

    /**
     * Create an instance of {@link FetchPaymentsResponse }
     * 
     */
    public FetchPaymentsResponse createFetchPaymentsResponse() {
        return new FetchPaymentsResponse();
    }

    /**
     * Create an instance of {@link SendPayments }
     * 
     */
    public SendPayments createSendPayments() {
        return new SendPayments();
    }

    /**
     * Create an instance of {@link SendPaymentsFaultException }
     * 
     */
    public SendPaymentsFaultException createSendPaymentsFaultException() {
        return new SendPaymentsFaultException();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendPaymentsFaultException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "SendPaymentsFault_Exception")
    public JAXBElement<SendPaymentsFaultException> createSendPaymentsFaultException(SendPaymentsFaultException value) {
        return new JAXBElement<SendPaymentsFaultException>(_SendPaymentsFaultException_QNAME, SendPaymentsFaultException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaymentsResultFaultException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "GetPaymentsResultFault_Exception")
    public JAXBElement<GetPaymentsResultFaultException> createGetPaymentsResultFaultException(GetPaymentsResultFaultException value) {
        return new JAXBElement<GetPaymentsResultFaultException>(_GetPaymentsResultFaultException_QNAME, GetPaymentsResultFaultException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchPayments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "fetchPayments")
    public JAXBElement<FetchPayments> createFetchPayments(FetchPayments value) {
        return new JAXBElement<FetchPayments>(_FetchPayments_QNAME, FetchPayments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterFaultException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "RegisterFault_Exception")
    public JAXBElement<RegisterFaultException> createRegisterFaultException(RegisterFaultException value) {
        return new JAXBElement<RegisterFaultException>(_RegisterFaultException_QNAME, RegisterFaultException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchPaymentsFaultException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "FetchPaymentsFault_Exception")
    public JAXBElement<FetchPaymentsFaultException> createFetchPaymentsFaultException(FetchPaymentsFaultException value) {
        return new JAXBElement<FetchPaymentsFaultException>(_FetchPaymentsFaultException_QNAME, FetchPaymentsFaultException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendPayments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "sendPayments")
    public JAXBElement<SendPayments> createSendPayments(SendPayments value) {
        return new JAXBElement<SendPayments>(_SendPayments_QNAME, SendPayments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendPaymentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "sendPaymentsResponse")
    public JAXBElement<SendPaymentsResponse> createSendPaymentsResponse(SendPaymentsResponse value) {
        return new JAXBElement<SendPaymentsResponse>(_SendPaymentsResponse_QNAME, SendPaymentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaymentsResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "getPaymentsResultResponse")
    public JAXBElement<GetPaymentsResultResponse> createGetPaymentsResultResponse(GetPaymentsResultResponse value) {
        return new JAXBElement<GetPaymentsResultResponse>(_GetPaymentsResultResponse_QNAME, GetPaymentsResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchPaymentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "fetchPaymentsResponse")
    public JAXBElement<FetchPaymentsResponse> createFetchPaymentsResponse(FetchPaymentsResponse value) {
        return new JAXBElement<FetchPaymentsResponse>(_FetchPaymentsResponse_QNAME, FetchPaymentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPaymentsResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "setPaymentsResultResponse")
    public JAXBElement<SetPaymentsResultResponse> createSetPaymentsResultResponse(SetPaymentsResultResponse value) {
        return new JAXBElement<SetPaymentsResultResponse>(_SetPaymentsResultResponse_QNAME, SetPaymentsResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPaymentsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "setPaymentsResult")
    public JAXBElement<SetPaymentsResult> createSetPaymentsResult(SetPaymentsResult value) {
        return new JAXBElement<SetPaymentsResult>(_SetPaymentsResult_QNAME, SetPaymentsResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPaymentsResultFaultException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "SetPaymentsResultFault_Exception")
    public JAXBElement<SetPaymentsResultFaultException> createSetPaymentsResultFaultException(SetPaymentsResultFaultException value) {
        return new JAXBElement<SetPaymentsResultFaultException>(_SetPaymentsResultFaultException_QNAME, SetPaymentsResultFaultException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaymentsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/", name = "getPaymentsResult")
    public JAXBElement<GetPaymentsResult> createGetPaymentsResult(GetPaymentsResult value) {
        return new JAXBElement<GetPaymentsResult>(_GetPaymentsResult_QNAME, GetPaymentsResult.class, null, value);
    }

}
