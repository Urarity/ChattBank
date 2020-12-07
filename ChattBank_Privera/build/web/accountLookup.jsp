<%-- 
    Document   : accountLookup
    Created on : Sep 26, 2020, 10:34:05 AM
    Author     : Patricia Rivera
    I wrote this code
--%>

<%@page import="BusinessObjects.Account"%>
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
        <title>Account Lookup Page</title>
    </head>
    <%
        Customer c1; // get cust_id from session
        
        c1 = (Customer)session.getAttribute("c1");
        
        Account a1;
        
        a1 = (Account)session.getAttribute("a1");
    %>
    <body>
        <div class = "middle">
            <a href="login.jsp">
                <button type="button">Logout?</button>
            </a>
            <form action="http://localhost:8080/ChattBank_Privera/AccountLookupServlet" method="GET">
                
                <h1 class="head1">Search ChattBank</h1>
                
                <h2 clas="head1">Hi Customer <%=c1.getCustID()%></h2>

                <!-- AcctNo Label/Input box -->
                <label for="AcctNo">Account No:</label>
                <input type="text" id="AcctNo" placeholder="<%=a1.getAcctNo()%>" value="<%=a1.getAcctNo()%>" name="AcctNo"></input>

                <br />

                <!-- CustID Label/Input box -->
                <label for="CustID">Customer ID:</label>
                <input type="text" placeholder="<%=a1.getCustId()%>" value="<%=a1.getCustId()%>" id="CustID" name="CustID" />

                <br />

                <!-- Type Label/Input box -->
                <label for="type">Type:</label>
                <input type="text" placeholder="<%=a1.getType()%>" value="<%=a1.getType()%>" id="type" name="type" />

                <br />

                <!-- Balance Label/Input box -->
                <label for="balance">Balance:</label>
                <input type="text" placeholder="<%=a1.getBalance()%>" value="<%=a1.getBalance()%>" id="balance" name="balance" />

                <br />

                <!-- Buttons -->
                <button class="block">Retrieve</button>
                <input type="reset" class="block"></input>
                
            </form>
        </div>
    </body>
</html>
