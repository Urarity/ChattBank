<%-- 
    Document   : noAccounts.jsp
    Created on : Oct 30, 2020, 9:15:24 PM
    Author     : Patricia Rivera
--%>

<%@page import="BusinessObjects.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer doesn't have accounts</title>
    </head>
    <%
        //************************************
        // Get Customer c1 from session
        //************************************
        
        Customer c1 = new Customer();
        c1 = (Customer)session.getAttribute("c1");
        
    %>
    <body>
        <h1>Customer <%=c1.getCustID()%> Doesn't have any accounts</h1>
        <a href="accountLookup.jsp">
            <button type="button">Go Back</button>
        </a>
    </body>
</html>
