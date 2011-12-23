/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clearing.tasks;

import backend.Backend;
import backend.Backend_Service;
import clearing.ClearingService;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenter;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenterImplService;
import cz.cvut.felk.support.aos.sw.clearingcenter.Payment;
import cz.cvut.felk.support.aos.sw.clearingcenter.PaymentResult;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lubos
 */
public class FetchPaymentTask extends TimerTask {

    private ClearingCenter clearingCenterPort = new ClearingCenterImplService().getClearingCenterImplPort();
    private Backend backendPort = new Backend_Service().getBackendPort();
    
    @Override
    public void run() {
        try { 
            Logger.getLogger(FetchPaymentTask.class.getName()).log(Level.SEVERE, "fetch payments");
            
            
            List<Payment> payments = clearingCenterPort.fetchPayments(ClearingService.code);
             
            if (!payments.isEmpty()){
       
            
                for (Payment payment:payments) {
                    Logger.getLogger(FetchPaymentTask.class.getName()).log(Level.SEVERE, "             "+payment.getPaymentResult());
                    if (payment.getPaymentResult() == PaymentResult.NOTSET){
                        boolean result = backendPort.addTransferPayment(payment.getAccountNumber(), payment.getCurrency(), payment.getAmount(), payment.getSenderAccountNumber(), payment.getSenderBankCode());
                    
                        if (result) payment.setPaymentResult(PaymentResult.OK);
                        else payment.setPaymentResult(PaymentResult.NO_SUCH_TARGET_ACCOUNT_ERROR);
                    }
                }
            
                clearingCenterPort.setPaymentsResult(ClearingService.code, payments);
                
                
            
            }
            Logger.getLogger(FetchPaymentTask.class.getName()).log(Level.SEVERE, "             "+payments.toString());
            Logger.getLogger(FetchPaymentTask.class.getName()).log(Level.SEVERE, "end fetch payments");
        } catch (Exception ex) {
            Logger.getLogger(FetchPaymentTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
