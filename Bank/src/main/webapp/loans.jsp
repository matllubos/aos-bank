<%-- 
    Document   : loans
    Created on : 14.12.2011, 17:06:07
    Author     : lubos
--%>

<%@page import="client.Client_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css.css" type="text/css" />
    </head>
    <body>
        <h1>Banka</h1>
        
        <h3> Výpis pujček </h3>
        
        <div class="menu left">
            
            <a href="account.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Zpět</a>
            
            <br />
            <a href="transactions.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Výpis transakcí</a>
            <a href="cash_dispenser.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Vybrat peníze</a>
            <a href="insert_money.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Vložit peníze</a>
            <a href="transfer_money.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Příkaz k převodu</a>
            <a href="transaction_file.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Stáhnout výpis</a>

            <br/>
            <a href="loans.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Výpis pujček</a>
            <a href="create_loan.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Vytvořit pujčku</a>
        </div>
        <table>
            <tr><th>Měna</th><th>Zbývající částka</th><th>Počet měsíců</th><th>Zaplatit splátku</th></tr>
            <%
                Client_Service service = new Client_Service();
                client.Client port = service.getClientPort();
                java.util.List<backend.LoanData> result = port.getLoans(Integer.parseInt(request.getParameter("accountNumber")));
                int i = 0;
                for (backend.LoanData loan : result) {
            %>
            <tr class="<%= i%2 == 1 ? "even" : "odd" %>"><td><%= loan.getCurrency()%></td><td><%= loan.getAmount()%></td><td><%= loan.getMonths()%></td><td><%= loan.getInterestRate()%></td><td><% if (loan.isCanPaid()) {%> <a href="paid_loan.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&loanNumber=<%= loan.getId()%>">Zaplatit</a><% }%></td></tr>
            <%
                i++;
                }
            %>
        </table>
    </body>
</html>
