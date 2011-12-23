<%-- 
    Document   : account
    Created on : 13.12.2011, 18:30:38
    Author     : lubos
--%>

<%@page import="client.Client_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%              String currency = request.getParameter("currency");
    if (request.getParameter("currency") == null) {
        response.sendRedirect("account.jsp?accountNumber=" + request.getParameter("accountNumber") + "&currency=CZK");
        currency = "CZK";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css.css" type="text/css" />
    </head>
    <body>
        <h1>Banka</h1>
        <div class="menu left">
            <a href="transactions.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Výpis transakcí</a>
            <a href="cash_dispenser.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Vybrat peníze</a>
            <a href="insert_money.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Vložit peníze</a>
            <a href="transfer_money.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Příkaz k převodu</a>
            <a href="transaction_file.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Stáhnout výpis</a>

            <br/>
            <a href="loans.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Výpis pujček</a>
            <a href="create_loan.jsp?accountNumber=<%= request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>">Vytvořit pujčku</a>
        </div>

        <div class="currency">
            <form action="account.jsp?accountNumber=<%=request.getParameter("accountNumber")%>&currency=<%=request.getParameter("currency")%>" method="POST">
                <%
                        Client_Service service = new Client_Service();
                        client.Client port = service.getClientPort();
                        if (request.getParameter("new_currency") != null) {
                            if (port.isSupportedCurrency(request.getParameter("new_currency"))) {
                                response.sendRedirect("account.jsp?accountNumber=" + request.getParameter("accountNumber") + "&currency=" + request.getParameter("new_currency"));
                            } else {
                                out.print("<p class=\"error\">Tato měna není podporovaná</p>");
                            }
                        }
                    
                %>
                <input type="text" name="new_currency" value="<%=request.getParameter("currency")%>"/>
                <input type="submit" class="button" value="Změnit" />
            </form>
        </div>
        <div class="ballance">
            <p>Aktuální použitelný zůstatek: 
                <%                    

                    if (request.getParameter (
                             
                        "accountNumber") != null) {
                        try {
                            out.print(port.getCurrentBalance(Integer.parseInt(request.getParameter("accountNumber")), currency).longValue() + " " + currency);
                        } catch (Exception ex) {
                            out.print("Špatný název měny");
                        }
                    }
                %>
            </p>
        </div>
    </body>
</html>
