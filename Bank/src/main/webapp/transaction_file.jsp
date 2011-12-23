<%@page import="client.Client_Service"%>
<%
    Client_Service service = new Client_Service();
    client.Client port = service.getClientPort();
    byte[] result = port.getAccountStatement(Integer.parseInt(request.getParameter("accountNumber")));
   // set the http content type to "APPLICATION/OCTET-STREAM
   response.setContentType("APPLICATION/OCTET-STREAM");
   String disHeader = "Attachment;Filename=\"transactionsLog.txt\"";
   response.setHeader("Content-Disposition", disHeader);
    out.print(new String(result, "UTF-8"));

%>
