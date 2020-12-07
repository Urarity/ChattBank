<%-- 
    Document   : DisplayAccount
    Created on : Oct 3, 2020, 4:02:41 PM
    Author     : Patricia Rivera
--%>

<%@page import="BusinessObjects.Customer"%>
<%@page import="BusinessObjects.Account"%>
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
        <title>Display Account</title>
    </head>
    <%
        Account a1;
        Customer c1;
        
        a1 = (Account)session.getAttribute("a1");
        c1 = (Customer)session.getAttribute("c1");
    %>
    <body>
        <div class = "middle">
            
            <form action="http://localhost:8080/ChattBank_Privera/AccountLookupServlet" method="GET">
        
                <h1>Account Info</h1>

                <!-- AcctNo Label/Input box -->
                <label for="AcctNo">Account No:</label>
                <input type="text" id="AcctNo" name="AcctNo" value="<%=a1.getAcctNo()%>" />

                <br />

                <!-- CustID Label/Input box -->
                <label for="CustID">Customer ID:</label>
                <input type="text" id="CustID" name="CustID" value="<%=a1.getCustId()%>" />

                <br />

                <!-- Type Label/Input box -->
                <label for="type">Type:</label>
                <input type="text" id="type" name="type" value="<%=a1.getType()%>" />

                <br />

                <!-- Balance Label/Input box -->
                <label for="balance">Balance:</label>
                <input type="text" id="balance" name="balance" value="<%=a1.getBalance()%>" />

                <br />

                <!-- Buttons -->
                <button class="block">Retrieve</button>
                <input type="reset" class="block">Clear</input>
            </form>
        </div>
    </body>
</html>
