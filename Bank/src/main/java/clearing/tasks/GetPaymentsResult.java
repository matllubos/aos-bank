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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lubos
 */
public class GetPaymentsResult extends TimerTask {

    private static List<Payment> waitingPayments = Collections.synchronizedList(new ArrayList<Payment>());
    private ClearingCenter clearingCenterPort = new ClearingCenterImplService().getClearingCenterImplPort();
    private Backend backendPort = new Backend_Service().getBackendPort();

    @Override
    public void run() {

        try {
            Logger.getLogger(GetPaymentsResult.class.getName()).log(Level.SEVERE, "get get payments");

            List<java.lang.Long> paymentIds = new ArrayList<Long>();

            for (Payment payment : waitingPayments) {
                Logger.getLogger(GetPaymentsResult.class.getName()).log(Level.SEVERE, "             " + payment.getPaymentResult());
                paymentIds.add(payment.getId());
            }

            List<Payment> result = clearingCenterPort.getPaymentsResult(ClearingService.code, paymentIds);

            int i = 0;
            for (Payment payment : result) {
                Logger.getLogger(GetPaymentsResult.class.getName()).log(Level.SEVERE, "             " + payment.getPaymentResult());


                if (payment.getPaymentResult() == PaymentResult.NO_SUCH_TARGET_ACCOUNT_ERROR || payment.getPaymentResult() == PaymentResult.UNKNOWN_ERROR) {
                    Logger.getLogger(GetPaymentsResult.class.getName()).log(Level.SEVERE, "             " + payment.getAccountNumber());


                    Payment currentPayment = waitingPayments.get(i);
                    backendPort.cancelTransferPaymentToAccount(currentPayment.getSenderAccountNumber(), currentPayment.getCurrency(), currentPayment.getAmount(), currentPayment.getAccountNumber(), currentPayment.getBankCode());
                    removePayment(paymentIds.get(i));


                } else if (payment.getPaymentResult() == PaymentResult.OK) {
                    removePayment(paymentIds.get(i));
                }

                i++;

            }
            Logger.getLogger(GetPaymentsResult.class.getName()).log(Level.SEVERE, "end get payments " + result.toString());

        } catch (Exception ex) {
            Logger.getLogger(GetPaymentsResult.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static void addWaitingPayment(Payment payment) {
        waitingPayments.add(payment);
    }

    public static void removePayment(Long id) {
        for (Payment wpayment : waitingPayments) {
            if (wpayment.getId().equals(id)) {
                waitingPayments.remove(wpayment);
            }
        }
    }
}
