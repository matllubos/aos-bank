/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.data;

import java.math.BigDecimal;

/**
 *
 * @author lubos
 */
public class LoanData {

    private long id;
    private float interestRate;
    private String currency;
    private BigDecimal amount;
    private int months;
    private boolean canPaid;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public boolean isCanPaid() {
        return canPaid;
    }

    public int getMonths() {
        return months;
    }

    public void setCanPaid(boolean canPaid) {
        this.canPaid = canPaid;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
