
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAccountStatementResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAccountStatementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getAccouljntStatementResponse" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccountStatementResponse", propOrder = {
    "getAccouljntStatementResponse"
})
public class GetAccountStatementResponse {

    protected byte[] getAccouljntStatementResponse;

    /**
     * Gets the value of the getAccouljntStatementResponse property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetAccouljntStatementResponse() {
        return getAccouljntStatementResponse;
    }

    /**
     * Sets the value of the getAccouljntStatementResponse property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetAccouljntStatementResponse(byte[] value) {
        this.getAccouljntStatementResponse = ((byte[]) value);
    }

}
