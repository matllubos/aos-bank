
package fileserver;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "FileException", targetNamespace = "http://fileserver/")
public class FileException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FileException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public FileException_Exception(String message, FileException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public FileException_Exception(String message, FileException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: fileserver.FileException
     */
    public FileException getFaultInfo() {
        return faultInfo;
    }

}
