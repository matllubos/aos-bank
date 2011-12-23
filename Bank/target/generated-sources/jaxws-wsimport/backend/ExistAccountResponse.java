
package backend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for existAccountResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="existAccountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="existAccountResponse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "existAccountResponse", propOrder = {
    "existAccountResponse"
})
public class ExistAccountResponse {

    protected boolean existAccountResponse;

    /**
     * Gets the value of the existAccountResponse property.
     * 
     */
    public boolean isExistAccountResponse() {
        return existAccountResponse;
    }

    /**
     * Sets the value of the existAccountResponse property.
     * 
     */
    public void setExistAccountResponse(boolean value) {
        this.existAccountResponse = value;
    }

}
