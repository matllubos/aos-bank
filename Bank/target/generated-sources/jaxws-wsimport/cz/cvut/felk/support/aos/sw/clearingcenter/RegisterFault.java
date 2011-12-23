
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
 *         &lt;element name="registerFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "registerFault"
})
@XmlRootElement(name = "registerFault")
public class RegisterFault {

    @XmlElement(required = true)
    protected String registerFault;

    /**
     * Gets the value of the registerFault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterFault() {
        return registerFault;
    }

    /**
     * Sets the value of the registerFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterFault(String value) {
        this.registerFault = value;
    }

}
