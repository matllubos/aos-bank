/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.db;

import backend.data.AccountData;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author lubos
 */
public class Account {

    public long id;
    public String currency;
    public String name;
    public BigDecimal money;

    public Account(String currency, String name) {
        this.currency = currency;
        this.name = name;
        this.money = new BigDecimal(0);
        this.id = -1;
    }

    public Account(long id, String currency, String name, BigDecimal money) {
        this.id = id;
        this.currency = currency;
        this.name = name;
        this.money = money;
    }

    private void update() throws NamingException, SQLException {

        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
        Connection con = ds.getConnection();
        String SQL_UPDATE = "UPDATE account SET name = ?, money = ?, currency = ? WHERE ID = " + id;

        PreparedStatement preparedS = con.prepareStatement(SQL_UPDATE);
        preparedS.setString(3, currency);
        preparedS.setString(1, name);
        preparedS.setBigDecimal(2, money);

        preparedS.executeUpdate();

        preparedS.close();

        con.close();
    }

    public static Account get(long id) {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id, name, money, currency FROM account WHERE ID = " + id;

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            Account account = null;

            ResultSet rs = preparedS.executeQuery();
            if (rs.next()) {
                account = new Account(id, rs.getString(4), rs.getString(2), rs.getBigDecimal(3));
            }
            preparedS.close();
            con.close();
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void insert() throws NamingException, SQLException {
        if (this.id != -1) {
            this.update();
        } else {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_INSERT = "INSERT INTO account (name, money, currency) VALUES (?, ?, ?)";

            PreparedStatement preparedS = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedS.setString(3, currency);
            preparedS.setString(1, name);
            preparedS.setBigDecimal(2, money);

            preparedS.executeUpdate();


            ResultSet generatedKeys = preparedS.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }


            preparedS.close();
            con.close();
        }
    }

    public void save() {
        try {
            if (this.id != -1) {
                this.update();
            } else {
                this.insert();
            }
        
        } catch (NamingException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Account> all() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id, name, money, currency FROM account";

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            List<Account> out = new ArrayList<Account>();
            ResultSet rs = preparedS.executeQuery();
            while (rs.next()) {
                out.add(new Account(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getBigDecimal(3)));
            }
            preparedS.close();
            con.close();
            return out;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Account>();
        
    }

    public AccountData getAccountData() {
        AccountData account = new AccountData();
        account.setCurrency(currency);
        account.setId(id);
        account.setMoney(money);
        account.setName(name);
        return account;
    }
}
