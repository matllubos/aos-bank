<%-- 
    Document   : createAccount
    Created on : 14.12.2011, 19:06:18
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
        <h1>Bank</h1>
        <a href="index.jsp">Zpět</a>
        <h3> Vytvořit účet </h3>
        <form action="create_account.jsp" method="POST">
            <%
                if (request.getParameter("name")!= null) {
            try {
                        Client_Service service = new Client_Service();
                        client.Client port = service.getClientPort();
                        
                        int result = port.createAccount(request.getParameter("name"), request.getParameter("currency"));
                        out.print("<p class=\"sucess\"> číslo vašeho nového účtu je"+result+"</p>");
                    } catch (Exception ex) {
                        out.print("<p class=\"error\">Zadaná měna neexistuje</p>");
                    }
                       }

            %>
            <p><label for="name">Vaše jméno</label><input type="text" name="name" /></p>
            <p><label for="currency">Měna</label><input type="text" name="currency" /></p>
            <p><input type="submit" class="button" value="Dokončit" /></p>
        </form>
    </body>
</html>
