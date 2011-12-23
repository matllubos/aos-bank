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
import java.util.Calendar;
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
public class Loan {

    public long id;
    public float interestRate;
    public Account account;
    public String currency;

    public Loan(long id, float interestRate, Account account, String currency) {
        this.id = id;
        this.interestRate = interestRate;
        this.account = account;
        this.currency = currency;
    }

    public Loan(float interestRate, Account account, String currency) {
        this(-1, interestRate, account, currency);
    }

    public Loan(Account account, float interestRate, String currency, BigDecimal amount, int months) {
        this(interestRate, account, currency);
        save();
        BigDecimal size = amount;
        size = size.add(size.multiply(new BigDecimal((interestRate / 100))));



        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(new java.util.Date().getTime()));

        for (int i = 0; i < months; i++) {
            cal.add(Calendar.MONTH, 1);
            Payment payment = new Payment(size.divide(new BigDecimal(months), 5, BigDecimal.ROUND_FLOOR), new Date(cal.getTimeInMillis()), false, false, this);
            payment.save();

        }







    }

    public Loan(float interestRate, String currency, BigDecimal amount, int months) {
        this(null, interestRate, currency, amount, months);

    }

    public BigDecimal paid(BigDecimal amount) {
        List<Payment> payments = Payment.filter("amount != 0 and loan = " + this.id);
        if (payments.isEmpty()) {
            return amount;
        }
        Date today = new Date(new java.util.Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(today.getTime()));
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date todeyWithFiveDays = new Date(cal.getTimeInMillis());
        for (Payment payment : payments) {
            if (payment.date.compareTo(todeyWithFiveDays) > 0) {
                break;
            }

            if (payment.date.compareTo(today) >= 0 && amount.compareTo(amount) >= 0) {
                payment.paidInTime = true;
            }


            BigDecimal min = payment.amount.min(amount);



            payment.amount = payment.amount.subtract(min);
            amount = amount.subtract(min);
            payment.paid = true;
            payment.save();
            if (amount.equals(BigDecimal.ZERO)) {
                break;
            }

        }
        return amount;
    }

    private void update() throws NamingException, SQLException {

        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
        Connection con = ds.getConnection();
        String SQL_UPDATE = "UPDATE loan SET interest_rate = ?, account = ?, currency = ? WHERE ID = " + id;

        PreparedStatement preparedS = con.prepareStatement(SQL_UPDATE);
        preparedS.setFloat(1, interestRate);
        if (account == null) {
            preparedS.setNull(2, java.sql.Types.INTEGER);
        } else {
            preparedS.setLong(2, account.id);
        }
        preparedS.setString(3, currency);

        preparedS.executeUpdate();

        preparedS.close();

        con.close();
    }

    public static Loan get(long id) {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id, interest_rate, account, currency  FROM loan WHERE ID = " + id;

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            Loan loan = null;

            ResultSet rs = preparedS.executeQuery();
            if (rs.next()) {
                if (rs.getLong(3) == 0) {
                    loan = new Loan(id, rs.getInt(2), null, rs.getString(4));
                } else {
                    loan = new Loan(id, rs.getFloat(2), Account.get(rs.getLong(3)), rs.getString(4));
                }
            }
            preparedS.close();
            con.close();
            return loan;
        } catch (SQLException ex) {
            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public void insert() throws NamingException, SQLException {
        if (this.id != -1) {
            this.update();
        } else {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_INSERT = "INSERT INTO loan (interest_rate, account, currency) VALUES (?, ?, ?)";

            PreparedStatement preparedS = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedS.setFloat(1, interestRate);

            if (account == null) {
                preparedS.setNull(2, java.sql.Types.INTEGER);
            } else {
                preparedS.setLong(2, account.id);
            }
            preparedS.setString(3, currency);

            preparedS.executeUpdate();


            ResultSet generatedKeys = preparedS.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }


            preparedS.close();
            con.close();
        }
    }

    public static List<Loan> filter(String query) {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/bank");
            Connection con = ds.getConnection();
            String SQL_GET = "SELECT id, interest_rate, account, currency  FROM loan WHERE " + query;

            PreparedStatement preparedS = con.prepareStatement(SQL_GET);

            List<Loan> out = new ArrayList<Loan>();
            ResultSet rs = preparedS.executeQuery();
            while (rs.next()) {
                Loan loan = null;
                if (rs.getLong(3) == 0) {
                    loan = new Loan(rs.getInt(1), rs.getInt(2), null, rs.getString(4));
                } else {
                    loan = new Loan(rs.getInt(1), rs.getFloat(2), Account.get(rs.getLong(3)), rs.getString(4));
                }
                out.add(loan);
            }
            preparedS.close();
            con.close();
            return out;
        } catch (SQLException ex) {
            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Loan>();
    }

    public backend.data.LoanData getLoan() {
        backend.data.LoanData loan = new backend.data.LoanData();
        loan.setCurrency(currency);
        loan.setInterestRate(interestRate);
        List<Payment> payments = Payment.filter("loan = " + this.id);
        loan.setMonths(payments.size());
        loan.setId(id);
        BigDecimal count = new BigDecimal(0);
        for (Payment payment : payments) {
            count = count.add(payment.amount);
        }
        loan.setAmount(count);

        List<Payment> notPaidPayments = Payment.filter("amount != 0 and loan = " + this.id);

        if (notPaidPayments.isEmpty()) {
            loan.setCanPaid(false);
        } else {
            Date today = new Date(new java.util.Date().getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(today.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 5);
            Date todeyWithFiveDays = new Date(cal.getTimeInMillis());
            Payment payment = notPaidPayments.get(0);
            if (payment.date.compareTo(todeyWithFiveDays) > 0) {
                loan.setCanPaid(false);
            } else {
                loan.setCanPaid(true);
            }

        }

        return loan;
    }
}
