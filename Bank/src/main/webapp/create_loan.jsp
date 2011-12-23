<%-- 
    Document   : create_loan
    Created on : 14.12.2011, 16:46:48
    Author     : lubos
--%>

<%@page import="client.Client_Service"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css.css" type="text/css" />
    </head>
    <body>
        <%
            Client_Service service = new Client_Service();
            client.Client port = service.getClientPort();
        %>
        <h1>Banka</h1>
        
        <h3> Vytvořit novou pujčku, aktuální úrok je: <b><%= port.getInterestRate() %> %</b></h3>
        
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
        <form action="create_loan.jsp?accountNumber=<%=request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>" method="POST">
            <%
                if (request.getParameter("amount")!= null) {
                    try {
                        int result = port.createLoan(Integer.parseInt(request.getParameter("accountNumber")), request.getParameter("currency"), new BigDecimal(request.getParameter("amount")), Integer.parseInt(request.getParameter("months")));
                        out.print("<p class=\"sucess\">Byla vytvořena nová pujčka, číslo pujčky je: "+result);
                    } catch (Exception ex) {
                        out.print("<p class=\"error\">Nelze vytvořit pujčku</p>");
                    }
                }
            %>
            <p><label for="amount">Množství peněz</label><input type="text" name="amount" /></p>
            <p><label for="months">Počet měsíců</label><input type="text" name="months" /></p>
            <p><input type="submit" class="button" value="Dokončit" /></p>
        </form>
    </body>
</html>
