
package scoring;

import java.math.BigDecimal;
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
@WebService(name = "Scoring", targetNamespace = "http://scoring/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Scoring {


    /**
     * 
     * @param amount
     * @param accountNumber
     * @param currency
     * @return
     *     returns float
     * @throws ScoringException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "boint", targetNamespace = "http://scoring/", className = "scoring.Boint")
    @ResponseWrapper(localName = "bointResponse", targetNamespace = "http://scoring/", className = "scoring.BointResponse")
    public float boint(
        @WebParam(name = "accountNumber", targetNamespace = "")
        int accountNumber,
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "amount", targetNamespace = "")
        BigDecimal amount)
        throws ScoringException_Exception
    ;

}
