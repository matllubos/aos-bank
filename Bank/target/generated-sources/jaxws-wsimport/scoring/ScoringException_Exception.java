
package scoring;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ScoringException", targetNamespace = "http://scoring/")
public class ScoringException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ScoringException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ScoringException_Exception(String message, ScoringException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ScoringException_Exception(String message, ScoringException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: scoring.ScoringException
     */
    public ScoringException getFaultInfo() {
        return faultInfo;
    }

}