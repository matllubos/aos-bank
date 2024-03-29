
package fileserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Fileserver", targetNamespace = "http://fileserver/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Fileserver {


    /**
     * 
     * @param accountNumber
     * @return
     *     returns byte[]
     * @throws FileException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPrintout", targetNamespace = "http://fileserver/", className = "fileserver.GetPrintout")
    @ResponseWrapper(localName = "getPrintoutResponse", targetNamespace = "http://fileserver/", className = "fileserver.GetPrintoutResponse")
    public byte[] getPrintout(
        @WebParam(name = "accountNumber", targetNamespace = "")
        int accountNumber)
        throws FileException_Exception
    ;

}
