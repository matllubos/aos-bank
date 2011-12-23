/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.db;

import backend.data.TransactionLogData;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author lubos
 */
public class Log {

    public long id;
    public String description;
    public BigDecimal moneyChange;
    public Account account;
    public Date datetime;

    public Log(long id, String description, BigDecimal moneyChange, Account account, Date datetime) {
        this.id = id;
        this.description = description;
        this.moneyChange = moneyChange;
        this.account = account;
        this.datetime = datetime;
    }

    public Log(String description, BigDecimal moneyChange, Account account, Date datetime) {
        this(-1, description, moneyChange, account, datetime);
    }

    public Log(String description, BigDecimal moneyChange, Account account) {
        this(-1, description, moneyChange, account, new Date(new java.util.Date().getTime()));
    }

    private void update() throws NamingException, SQLException {

        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
        Connection con = ds.getConnection();
        String SQL_UPDATE = "UPDATE log SET money_change = ?, description = ?, account = ?, datetime = ? WHERE ID = " + id;

        PreparedStatement preparedS = con.prepareStatement(SQL_UPDATE);
        preparedS.setBigDecimal(1, moneyChange);
        preparedS.setString(2, description);
        preparedS.setLong(3, account.id);
        preparedS.setDate(4, datetime);

        preparedS.executeUpdate();

        preparedS.close();
        con.close();


    }

    public static Log get(long id) {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id, money_change, description, account, datetime FROM log WHERE ID = " + id;

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            Log log = null;

            ResultSet rs = preparedS.executeQuery();
            if (rs.next()) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, rs.getString(4));
                log = new Log(id, rs.getString(3), rs.getBigDecimal(2), Account.get(rs.getLong(4)), rs.getDate(5));
            }
            preparedS.close();
            con.close();
            return log;
        } catch (SQLException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void save() {
        try {
            if (this.id != -1) {
                update();

            } else {
                insert();
            }
        } catch (NamingException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert() throws NamingException, SQLException {
        if (this.id != -1) {
            update();
        } else {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_INSERT = "INSERT INTO log (money_change, description, account, datetime) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedS = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedS.setString(2, description);
            preparedS.setBigDecimal(1, moneyChange);
            preparedS.setLong(3, account.id);
            preparedS.setDate(4, datetime);

            preparedS.executeUpdate();


            ResultSet generatedKeys = preparedS.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }


            preparedS.close();
            con.close();
        }

    }

    public static List<Log> filter(String query) {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id, money_change, description, account, datetime FROM log WHERE " + query;

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            List<Log> out = new ArrayList<Log>();
            ResultSet rs = preparedS.executeQuery();
            while (rs.next()) {
                out.add(new Log(rs.getLong(1), rs.getString(3), rs.getBigDecimal(2), Account.get(rs.getLong(4)), rs.getDate(5)));

            }
            preparedS.close();
            con.close();
            return out;
        } catch (SQLException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Log>();
    }

    public TransactionLogData getTransactionLog() {
        TransactionLogData transactionLog = new TransactionLogData();
        transactionLog.setDatetime(datetime);
        transactionLog.setDescription(description);
        transactionLog.setMoneyChange(moneyChange);
        return transactionLog;
    }
}
