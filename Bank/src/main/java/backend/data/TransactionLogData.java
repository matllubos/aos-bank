/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author lubos
 */
public class TransactionLogData {

    private String description;
    private BigDecimal moneyChange;
    private Date datetime;
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setMoneyChange(BigDecimal moneyChange) {
        this.moneyChange = moneyChange;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMoneyChange() {
        return moneyChange;
    }
}
