
package cz.cvut.felk.support.aos.sw.clearingcenter;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "RegisterFault_Exception", targetNamespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/")
public class RegisterFaultException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RegisterFaultException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public RegisterFaultException_Exception(String message, RegisterFaultException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public RegisterFaultException_Exception(String message, RegisterFaultException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: cz.cvut.felk.support.aos.sw.clearingcenter.RegisterFaultException
     */
    public RegisterFaultException getFaultInfo() {
        return faultInfo;
    }

}
