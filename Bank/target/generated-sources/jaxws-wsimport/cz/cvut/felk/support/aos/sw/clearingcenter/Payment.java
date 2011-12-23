
package cz.cvut.felk.support.aos.sw.clearingcenter;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="paymentResult" type="{http://support.felk.cvut.cz/aos/sw/ClearingCenter/}paymentResult" minOccurs="0"/>
 *         &lt;element name="senderAccountNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="senderBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payment", propOrder = {
    "accountNumber",
    "amount",
    "bankCode",
    "currency",
    "id",
    "paymentResult",
    "senderAccountNumber",
    "senderBankCode"
})
public class Payment {

    protected int accountNumber;
    protected BigDecimal amount;
    protected String bankCode;
    protected String currency;
    protected Long id;
    protected PaymentResult paymentResult;
    protected int senderAccountNumber;
    protected String senderBankCode;

    /**
     * Gets the value of the accountNumber property.
     * 
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     */
    public void setAccountNumber(int value) {
        this.accountNumber = value;
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
     * Gets the value of the bankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * Sets the value of the bankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCode(String value) {
        this.bankCode = value;
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

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the paymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentResult }
     *     
     */
    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    /**
     * Sets the value of the paymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResult }
     *     
     */
    public void setPaymentResult(PaymentResult value) {
        this.paymentResult = value;
    }

    /**
     * Gets the value of the senderAccountNumber property.
     * 
     */
    public int getSenderAccountNumber() {
        return senderAccountNumber;
    }

    /**
     * Sets the value of the senderAccountNumber property.
     * 
     */
    public void setSenderAccountNumber(int value) {
        this.senderAccountNumber = value;
    }

    /**
     * Gets the value of the senderBankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderBankCode() {
        return senderBankCode;
    }

    /**
     * Sets the value of the senderBankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderBankCode(String value) {
        this.senderBankCode = value;
    }

}
