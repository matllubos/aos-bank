
package cz.cvut.felk.support.aos.sw.clearingcenter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fetchPaymentsFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fetchPaymentsFault"
})
@XmlRootElement(name = "fetchPaymentsFault")
public class FetchPaymentsFault {

    @XmlElement(required = true)
    protected String fetchPaymentsFault;

    /**
     * Gets the value of the fetchPaymentsFault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFetchPaymentsFault() {
        return fetchPaymentsFault;
    }

    /**
     * Sets the value of the fetchPaymentsFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFetchPaymentsFault(String value) {
        this.fetchPaymentsFault = value;
    }

}
