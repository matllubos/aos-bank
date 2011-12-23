
package cz.cvut.felk.support.aos.sw.exchangerates;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.cvut.felk.support.aos.sw.exchangerates package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UnsupportedCurrencyFault_QNAME = new QName("http://support.felk.cvut.cz/aos/sw/ExchangeRates/", "UnsupportedCurrencyFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.cvut.felk.support.aos.sw.exchangerates
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSupportedCurrencies }
     * 
     */
    public GetSupportedCurrencies createGetSupportedCurrencies() {
        return new GetSupportedCurrencies();
    }

    /**
     * Create an instance of {@link GetExchangeRateResponse }
     * 
     */
    public GetExchangeRateResponse createGetExchangeRateResponse() {
        return new GetExchangeRateResponse();
    }

    /**
     * Create an instance of {@link GetExchangeRate }
     * 
     */
    public GetExchangeRate createGetExchangeRate() {
        return new GetExchangeRate();
    }

    /**
     * Create an instance of {@link GetSupportedCurrenciesResponse }
     * 
     */
    public GetSupportedCurrenciesResponse createGetSupportedCurrenciesResponse() {
        return new GetSupportedCurrenciesResponse();
    }

    /**
     * Create an instance of {@link UnsupportedCurrencyFault }
     * 
     */
    public UnsupportedCurrencyFault createUnsupportedCurrencyFault() {
        return new UnsupportedCurrencyFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedCurrencyFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.felk.cvut.cz/aos/sw/ExchangeRates/", name = "UnsupportedCurrencyFault")
    public JAXBElement<UnsupportedCurrencyFault> createUnsupportedCurrencyFault(UnsupportedCurrencyFault value) {
        return new JAXBElement<UnsupportedCurrencyFault>(_UnsupportedCurrencyFault_QNAME, UnsupportedCurrencyFault.class, null, value);
    }

}
