<%-- 
    Document   : set_interest_rate
    Created on : 20.12.2011, 14:24:18
    Author     : lubos
--%>

<%@page import="backend.Backend_Service"%>
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
        
        <a href="index.jsp">Zpět</a>
        <form action="set_interest_rate.jsp" method="POST">
            <%
               Backend_Service service = new Backend_Service();
               backend.Backend port = service.getBackendPort();
                if (request.getParameter("interest_rate")!= null) {
                    try {
                        
                        port.setInterestRate(Float.parseFloat(request.getParameter("interest_rate")));

                        out.print("<p class=\"sucess\">Úrok byl změněn</p>");
                    } catch (Exception ex) {
                        System.out.println("<p class=\"error\">Nelze změnit</p>");
                    }
                }
            %>
            <p><label for="interest_rate">Částka</label><input type="text" name="interest_rate" value="<%= port.getInterestRate() %>" /></p>
            <p><input type="submit" class="button" value="Dokončit" /></p>
        </form>
            
    </body>
</html>
