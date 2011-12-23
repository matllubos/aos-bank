
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
 *         &lt;element name="sendPaymentsFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sendPaymentsFault"
})
@XmlRootElement(name = "sendPaymentsFault")
public class SendPaymentsFault {

    @XmlElement(required = true)
    protected String sendPaymentsFault;

    /**
     * Gets the value of the sendPaymentsFault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendPaymentsFault() {
        return sendPaymentsFault;
    }

    /**
     * Sets the value of the sendPaymentsFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendPaymentsFault(String value) {
        this.sendPaymentsFault = value;
    }

}
