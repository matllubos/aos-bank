/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clearing.tasks;

//import backend.Backend;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenter;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenterImplService;
import cz.cvut.felk.support.aos.sw.clearingcenter.Payment;
import cz.cvut.felk.support.aos.sw.clearingcenter.PaymentResult;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
//import my_generated.Backend_Service;

/**
 *
 * @author lubos
 */
public class FetchPaymentTaskOtherBank extends TimerTask {

    ClearingCenter clearingCenterPort = new ClearingCenterImplService().getClearingCenterImplPort();
//    Backend backendPort = new Backend_Service().getBackendServicePort();
    
    @Override
    public void run() {
//        try { 
//            Logger.getLogger(FetchPaymentTaskOtherBank.class.getName()).log(Level.SEVERE, "fetch payments other bank");
//            
//            
//            java.lang.String bankKey = "cfaeccd0d7aca57159da6f302049146818065f67";
//            List<Payment> payments = clearingCenterPort.fetchPayments(bankKey);
//             
//            if (!payments.isEmpty()){
//       
//            
//                for (Payment payment:payments) {
//                    Logger.getLogger(FetchPaymentTaskOtherBank.class.getName()).log(Level.SEVERE, "             "+payment.getPaymentResult());
//                    if (payment.getPaymentResult() == PaymentResult.NOTSET){
//                        boolean result = backendPort.addTransferPayment(payment.getAccountNumber(), payment.getCurrency(), payment.getAmount(), payment.getSenderAccountNumber(), payment.getSenderBankCode());
//                    
//                        if (result) payment.setPaymentResult(PaymentResult.OK);
//                        else payment.setPaymentResult(PaymentResult.NO_SUCH_TARGET_ACCOUNT_ERROR);
//                    }
//                }
//            
//                clearingCenterPort.setPaymentsResult(bankKey, payments);
//                
//                
//            
//            }
//            Logger.getLogger(FetchPaymentTaskOtherBank.class.getName()).log(Level.SEVERE, "             "+payments.toString());
//            Logger.getLogger(FetchPaymentTaskOtherBank.class.getName()).log(Level.SEVERE, "end fetch payments");
//        } catch (Exception ex) {
//        
//        }
        
    }
    
}
