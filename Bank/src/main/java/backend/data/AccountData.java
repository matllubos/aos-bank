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
public class AccountData {
    private long id;
    private String currency;
    private String name;
    private BigDecimal money;

    public String getCurrency() {
        return currency;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
