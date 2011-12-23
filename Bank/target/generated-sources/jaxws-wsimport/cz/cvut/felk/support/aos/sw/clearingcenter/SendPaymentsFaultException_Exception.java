
package cz.cvut.felk.support.aos.sw.clearingcenter;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "SendPaymentsFault_Exception", targetNamespace = "http://support.felk.cvut.cz/aos/sw/ClearingCenter/")
public class SendPaymentsFaultException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SendPaymentsFaultException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public SendPaymentsFaultException_Exception(String message, SendPaymentsFaultException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public SendPaymentsFaultException_Exception(String message, SendPaymentsFaultException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: cz.cvut.felk.support.aos.sw.clearingcenter.SendPaymentsFaultException
     */
    public SendPaymentsFaultException getFaultInfo() {
        return faultInfo;
    }

}