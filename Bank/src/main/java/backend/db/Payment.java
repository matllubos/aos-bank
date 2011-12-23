/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.db;

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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author lubos
 */
public class Payment {

    public BigDecimal amount;
    public Date date;
    public boolean paid;
    public boolean paidInTime;
    public Loan loan;
    public long id;

    public Payment(long id, BigDecimal amount, Date date, boolean paid, boolean paidInTime, Loan loan) {
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.paidInTime = paidInTime;
        this.loan = loan;
        this.id = id;
    }

    public Payment(BigDecimal amount, Date date, boolean paid, boolean paidInTime, Loan loan) {
        this(-1, amount, date, paid, paidInTime, loan);
    }

    private void update() throws NamingException, SQLException {

        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
        Connection con = ds.getConnection();
        String SQL_UPDATE = "UPDATE payment SET amount = ?, date = ?, paid = ?, paid_in_time = ?, loan = ? WHERE ID = " + id;

        PreparedStatement preparedS = con.prepareStatement(SQL_UPDATE);
        preparedS.setBigDecimal(1, amount);
        preparedS.setDate(2, date);
        preparedS.setBoolean(3, paid);
        preparedS.setBoolean(4, paidInTime);
        preparedS.setLong(5, loan.id);

        preparedS.executeUpdate();

        preparedS.close();

        con.close();
    }

    public static Payment get(long id) throws NamingException, SQLException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
        Connection con = ds.getConnection();
        String SQL_GET = "SELECT id,amount , date , paid , paid_in_time , loan  FROM payment WHERE ID = " + id;

        PreparedStatement preparedS = con.prepareStatement(SQL_GET);

        Payment payment = null;

        ResultSet rs = preparedS.executeQuery();
        if (rs.next()) {
            payment = new Payment(id, rs.getBigDecimal(2), rs.getDate(3), rs.getBoolean(4), rs.getBoolean(5), Loan.get(rs.getInt(6)));
        }
        preparedS.close();
        con.close();
        return payment;
    }

    public void save() {
        try {
            if (this.id != -1) {

                this.update();

            } else {
                this.insert();
            }
        } catch (NamingException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert() throws NamingException, SQLException {
        if (this.id != -1) {
            this.update();
        } else {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_INSERT = "INSERT INTO payment (amount , date , paid , paid_in_time , loan) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedS = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedS.setBigDecimal(1, amount);
            preparedS.setDate(2, date);
            preparedS.setBoolean(3, paid);
            preparedS.setBoolean(4, paidInTime);
            preparedS.setLong(5, loan.id);
            preparedS.executeUpdate();


            ResultSet generatedKeys = preparedS.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }


            preparedS.close();
            con.close();
        }
    }

    public static List<Payment> filter(String query)  {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id,amount , date , paid , paid_in_time , loan FROM payment WHERE " + query;

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            List<Payment> out = new ArrayList<Payment>();
            ResultSet rs = preparedS.executeQuery();
            while (rs.next()) {
                out.add(new Payment(rs.getLong(1), rs.getBigDecimal(2), rs.getDate(3), rs.getBoolean(4), rs.getBoolean(5), Loan.get(rs.getInt(6))));
            }
            preparedS.close();
            con.close();
            return out;
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Payment>();
    }
}
