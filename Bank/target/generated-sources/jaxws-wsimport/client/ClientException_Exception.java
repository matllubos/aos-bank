
package client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ClientException", targetNamespace = "http://client/")
public class ClientException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClientException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ClientException_Exception(String message, ClientException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ClientException_Exception(String message, ClientException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: client.ClientException
     */
    public ClientException getFaultInfo() {
        return faultInfo;
    }

}
