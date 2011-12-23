
package clearing;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transferMoney complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transferMoney">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="myAccount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetAccount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferMoney", propOrder = {
    "myAccount",
    "targetAccount",
    "targetBank",
    "amount",
    "currency"
})
public class TransferMoney {

    protected int myAccount;
    protected int targetAccount;
    protected String targetBank;
    protected BigDecimal amount;
    protected String currency;

    /**
     * Gets the value of the myAccount property.
     * 
     */
    public int getMyAccount() {
        return myAccount;
    }

    /**
     * Sets the value of the myAccount property.
     * 
     */
    public void setMyAccount(int value) {
        this.myAccount = value;
    }

    /**
     * Gets the value of the targetAccount property.
     * 
     */
    public int getTargetAccount() {
        return targetAccount;
    }

    /**
     * Sets the value of the targetAccount property.
     * 
     */
    public void setTargetAccount(int value) {
        this.targetAccount = value;
    }

    /**
     * Gets the value of the targetBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetBank() {
        return targetBank;
    }

    /**
     * Sets the value of the targetBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetBank(String value) {
        this.targetBank = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
