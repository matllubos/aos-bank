
package fileserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fileserver package. 
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

    private final static QName _GetPrintout_QNAME = new QName("http://fileserver/", "getPrintout");
    private final static QName _GetPrintoutResponse_QNAME = new QName("http://fileserver/", "getPrintoutResponse");
    private final static QName _FileException_QNAME = new QName("http://fileserver/", "FileException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fileserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileException }
     * 
     */
    public FileException createFileException() {
        return new FileException();
    }

    /**
     * Create an instance of {@link GetPrintoutResponse }
     * 
     */
    public GetPrintoutResponse createGetPrintoutResponse() {
        return new GetPrintoutResponse();
    }

    /**
     * Create an instance of {@link GetPrintout }
     * 
     */
    public GetPrintout createGetPrintout() {
        return new GetPrintout();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrintout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fileserver/", name = "getPrintout")
    public JAXBElement<GetPrintout> createGetPrintout(GetPrintout value) {
        return new JAXBElement<GetPrintout>(_GetPrintout_QNAME, GetPrintout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrintoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fileserver/", name = "getPrintoutResponse")
    public JAXBElement<GetPrintoutResponse> createGetPrintoutResponse(GetPrintoutResponse value) {
        return new JAXBElement<GetPrintoutResponse>(_GetPrintoutResponse_QNAME, GetPrintoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fileserver/", name = "FileException")
    public JAXBElement<FileException> createFileException(FileException value) {
        return new JAXBElement<FileException>(_FileException_QNAME, FileException.class, null, value);
    }

}
