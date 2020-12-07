<%-- 
    Document   : ErrorPage
    Created on : Sep 26, 2020, 10:28:58 AM
    Author     : Patricia Rivera
    I wrote this code
--%>

<%@page import="BusinessObjects.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Free Web tutorials">
        <meta name="keywords" content="HTML, CSS, JavaScript">
        <meta name="author" content="Patricia Rivera">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <%
        
        Customer c1; // get cust_id from session
        
        c1 = (Customer)session.getAttribute("c1");
        
    %>
    <body>
        <div class="error_page">
            
            <p>User with ID <%=c1.getCustID()%>, invalid password!!</p>
            
            <a href="login.jsp">
                <button type="button" id="try_againBtn">Try Again?</button>
            </a>
        
        </div>
    </body>
</html>
