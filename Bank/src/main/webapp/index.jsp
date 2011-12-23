<%@page import="client.Client_Service"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css.css" type="text/css" />
    </head>
    <body>
        <h1>Banka</h1>
        
        <div class="menu left">
            <a href="create_account.jsp">Vytvořit nový účet</a>
            <a href="set_interest_rate.jsp">Nastavit úrok</a>
        </div>
        
        <form action="index.jsp" method="GET">
            <h2>Přihlásit se</h2>
            <%
                if (request.getParameter("accountNumber")!= null) {
                    Client_Service service = new Client_Service();
                    client.Client port = service.getClientPort();
                    if (port.existAccount(Integer.parseInt(request.getParameter("accountNumber")))) response.sendRedirect("account.jsp?accountNumber="+request.getParameter("accountNumber"));
                    else out.print("<p class=\"error\">Účet neexistuje</p>");
                }
            %>
            <p><label for="accountNumber">Číslo účtu</label><input type="text" name="accountNumber" /></p>
            <p><input type="submit" class="button" value="Přihlásit se" /></p>
        </form>
    </body>
</html>
