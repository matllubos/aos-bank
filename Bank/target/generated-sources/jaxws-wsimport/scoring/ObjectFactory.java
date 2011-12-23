
package scoring;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the scoring package. 
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

    private final static QName _Boint_QNAME = new QName("http://scoring/", "boint");
    private final static QName _BointResponse_QNAME = new QName("http://scoring/", "bointResponse");
    private final static QName _ScoringException_QNAME = new QName("http://scoring/", "ScoringException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: scoring
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ScoringException }
     * 
     */
    public ScoringException createScoringException() {
        return new ScoringException();
    }

    /**
     * Create an instance of {@link BointResponse }
     * 
     */
    public BointResponse createBointResponse() {
        return new BointResponse();
    }

    /**
     * Create an instance of {@link Boint }
     * 
     */
    public Boint createBoint() {
        return new Boint();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://scoring/", name = "boint")
    public JAXBElement<Boint> createBoint(Boint value) {
        return new JAXBElement<Boint>(_Boint_QNAME, Boint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BointResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://scoring/", name = "bointResponse")
    public JAXBElement<BointResponse> createBointResponse(BointResponse value) {
        return new JAXBElement<BointResponse>(_BointResponse_QNAME, BointResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScoringException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://scoring/", name = "ScoringException")
    public JAXBElement<ScoringException> createScoringException(ScoringException value) {
        return new JAXBElement<ScoringException>(_ScoringException_QNAME, ScoringException.class, null, value);
    }

}
