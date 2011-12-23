/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clearing.tasks;

import clearing.ClearingService;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenter;
import cz.cvut.felk.support.aos.sw.clearingcenter.ClearingCenterImplService;
import cz.cvut.felk.support.aos.sw.clearingcenter.Payment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lubos
 */
public class SendPaymentsTask extends TimerTask {

    public static LinkedList<Payment> payments = new LinkedList<Payment>();
    ClearingCenter clearingCenterPort = new ClearingCenterImplService().getClearingCenterImplPort();

    @Override
    public void run() {
        try { 
            Logger.getLogger(SendPaymentsTask.class.getName()).log(Level.SEVERE, "send payments");

            List<Payment> sendPayments = new ArrayList<Payment>();
            synchronized (payments) {
                while (!payments.isEmpty()) {
                    Payment payment = payments.removeFirst();
                    sendPayments.add(payment);
                }
            }
            
            if (!sendPayments.isEmpty()) {

                List<Long> ids = clearingCenterPort.sendPayments(ClearingService.code, sendPayments);

                int i = 0;
                for (Long id : ids) {
                    Payment payment = sendPayments.get(i);
                    payment.setId(id);
                    GetPaymentsResult.addWaitingPayment(payment);

                }
                Logger.getLogger(SendPaymentsTask.class.getName()).log(Level.SEVERE, "             " + ids.toString());
            }
            

        } catch (Exception ex) {
            Logger.getLogger(SendPaymentsTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(SendPaymentsTask.class.getName()).log(Level.SEVERE, "end send payments");
    }

    public static void addPayment(Payment payment) {
        synchronized (payments) {
            payments.add(payment);
        }
    }
}
