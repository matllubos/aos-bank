
package bank.testadapter.generated;

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
 *         &lt;element name="getCurrentBalanceFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getCurrentBalanceFault"
})
@XmlRootElement(name = "getCurrentBalanceFault")
public class GetCurrentBalanceFault {

    @XmlElement(required = true)
    protected String getCurrentBalanceFault;

    /**
     * Gets the value of the getCurrentBalanceFault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCurrentBalanceFault() {
        return getCurrentBalanceFault;
    }

    /**
     * Sets the value of the getCurrentBalanceFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCurrentBalanceFault(String value) {
        this.getCurrentBalanceFault = value;
    }

}
