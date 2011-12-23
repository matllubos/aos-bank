
package fileserver;

import backend.Backend_Service;
import backend.TransactionLogData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author lubos
 */

@WebService(serviceName = "Fileserver", portName="FileserverPort")
public class FileserverService {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/bank/Backend.wsdl")
    private Backend_Service service;

    /**
     * Vrátí soubor s výpisem transakcí
     * @param accountNumber
     * @return
     * @throws FileException 
     */
    @WebMethod(operationName = "getPrintout")
    public DataHandler getPrintout(@WebParam(name = "accountNumber") int accountNumber) throws FileServiceException {
        try { // Call Web Service Operation
            backend.Backend port = service.getBackendPort();
            List<TransactionLogData> logs = port.getTransactions(accountNumber);
            BigDecimal balance = port.getCurrentBalance(accountNumber, "CZK");
          
            File file = new File("printout");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write("Vypis \n");
            out.write("Cislo uctu, "+accountNumber+"\n\n");
            
            out.write("Aktualni pouzitelny zustatek, "+balance.toPlainString()+"\n\n");
            
            out.write("Datum, Popis transakce, Pripsano/Odepsano\n");
            for (TransactionLogData log: logs) {
                out.write(log.getDatetime().toString());
                out.write(", ");
                out.write(log.getDescription());
                out.write(", ");
                out.write(log.getMoneyChange().toString());
                out.write(" ");
                out.write(log.getCurrency());
                out.write("\n");
            }
            
            out.close();

            return new DataHandler(new FileDataSource(file));
        } catch (Exception ex) {
            throw new FileServiceException("Nemohu vytvořit soubor");
        }
    }
}
