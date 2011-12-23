
package clearing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isSupportedCurrencyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="isSupportedCurrencyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isSupportedCurrencyResponse", propOrder = {
    "isSupported"
})
public class IsSupportedCurrencyResponse {

    protected boolean isSupported;

    /**
     * Gets the value of the isSupported property.
     * 
     */
    public boolean isIsSupported() {
        return isSupported;
    }

    /**
     * Sets the value of the isSupported property.
     * 
     */
    public void setIsSupported(boolean value) {
        this.isSupported = value;
    }

}
