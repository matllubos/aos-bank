
package cz.cvut.felk.support.aos.sw.clearingcenter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentResult.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="paymentResult">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOTSET"/>
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="WAITING_FOR_TARGET_BANK_PROCESSING"/>
 *     &lt;enumeration value="NO_SUCH_TARGET_ACCOUNT_ERROR"/>
 *     &lt;enumeration value="UNKNOWN_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "paymentResult")
@XmlEnum
public enum PaymentResult {

    NOTSET,
    OK,
    WAITING_FOR_TARGET_BANK_PROCESSING,
    NO_SUCH_TARGET_ACCOUNT_ERROR,
    UNKNOWN_ERROR;

    public String value() {
        return name();
    }

    public static PaymentResult fromValue(String v) {
        return valueOf(v);
    }

}
