package bank.testadapter.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-12-20T16:43:35.170+01:00
 * Generated source version: 2.5.0
 * 
 */
@WebServiceClient(name = "TestAdapter", 
                  wsdlLocation = "clearing_center/aos/semestral_work/aos_clearing_center/src/main/resources/TestAdapter.wsdl",
                  targetNamespace = "http://support.felk.cvut.cz/aos/sw/TestAdapter/") 
public class TestAdapter_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://support.felk.cvut.cz/aos/sw/TestAdapter/", "TestAdapter");
    public final static QName TestAdapterSOAP = new QName("http://support.felk.cvut.cz/aos/sw/TestAdapter/", "TestAdapterSOAP");
    static {
        URL url = null;
        try {
            url = new URL("clearing_center/aos/semestral_work/aos_clearing_center/src/main/resources/TestAdapter.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TestAdapter_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "clearing_center/aos/semestral_work/aos_clearing_center/src/main/resources/TestAdapter.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TestAdapter_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TestAdapter_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestAdapter_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns TestAdapter
     */
    @WebEndpoint(name = "TestAdapterSOAP")
    public TestAdapter getTestAdapterSOAP() {
        return super.getPort(TestAdapterSOAP, TestAdapter.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestAdapter
     */
    @WebEndpoint(name = "TestAdapterSOAP")
    public TestAdapter getTestAdapterSOAP(WebServiceFeature... features) {
        return super.getPort(TestAdapterSOAP, TestAdapter.class, features);
    }

}
