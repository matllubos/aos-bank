
package client;

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
 *         &lt;element name="isSupportedCurrencyResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isSupportedCurrencyResult"
})
public class IsSupportedCurrencyResponse {

    protected boolean isSupportedCurrencyResult;

    /**
     * Gets the value of the isSupportedCurrencyResult property.
     * 
     */
    public boolean isIsSupportedCurrencyResult() {
        return isSupportedCurrencyResult;
    }

    /**
     * Sets the value of the isSupportedCurrencyResult property.
     * 
     */
    public void setIsSupportedCurrencyResult(boolean value) {
        this.isSupportedCurrencyResult = value;
    }

}
