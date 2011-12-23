
package scoring;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Scoring", targetNamespace = "http://scoring/", wsdlLocation = "http://localhost:8080/bank/Scoring?wsdl")
public class Scoring_Service
    extends Service
{

    private final static URL SCORING_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(scoring.Scoring_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = scoring.Scoring_Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/bank/Scoring?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/bank/Scoring?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SCORING_WSDL_LOCATION = url;
    }

    public Scoring_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Scoring_Service() {
        super(SCORING_WSDL_LOCATION, new QName("http://scoring/", "Scoring"));
    }

    /**
     * 
     * @return
     *     returns Scoring
     */
    @WebEndpoint(name = "ScoringPort")
    public Scoring getScoringPort() {
        return super.getPort(new QName("http://scoring/", "ScoringPort"), Scoring.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Scoring
     */
    @WebEndpoint(name = "ScoringPort")
    public Scoring getScoringPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://scoring/", "ScoringPort"), Scoring.class, features);
    }

}
