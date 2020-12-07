<%-- 
    Document   : DisplayAccounts
    Created on : Oct 10, 2020, 1:27:05 PM
    Author     : Patricia Rivera
    I wrote this code.
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
        <title>Display Accounts Page</title>
    </head>
    <%
        //************************************
        // Get Customer c1 from session
        //************************************
        
        Customer c1 = new Customer();
        c1 = (Customer)session.getAttribute("c1");
        
    %>
    <body>
        <%
            Account account;
            
            for(int i = 0; i < c1.blist.accArr.size(); i++){
              
            account = c1.blist.accArr.get(i);
        %>
                <table>
                    <tr>
                        <td>Account No</td>
                        <td><%=account.getAcctNo()%></td>
                    </tr>
                    <tr>
                        <td>Customer ID</td>
                        <td><%=account.getCustId()%></td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td><%=account.getType()%></td>
                    </tr>
                    <tr>
                        <td>Balance</td>
                        <td><%=account.getBalance()%></td>
                    </tr>
                </table>
                    
                <br />
                <br />
        <%
            }
        %>
        
        <a href="accountLookup.jsp">
            <button type="button">Go Back</button>
        </a>
    </body>
</html>
