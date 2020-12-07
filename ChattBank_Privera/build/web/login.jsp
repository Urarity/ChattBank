<%-- 
    Document   : login
    Created on : Sep 26, 2020, 10:35:42 AM
    Author     : Patricia Rivera
    I wrote this code
--%>

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
        <title>Login Page</title>
    </head>
    <body>
        <div class = "middle">
            <h1>Login</h1>
            <!-- <form name="form1" action="#" onsubmit="required()"> -->
            <form action="http://localhost:8080/ChattBank_Privera/LoginServlet" method="GET">

                    <!-- Customer ID Label/Input box -->
                    <label for="customer_id">Customer ID:</label>
                    <input type="text" id="customerID" name="customerID" />

                    <br />

                    <!-- Password Label/Input Box -->
                    <label for="password">Password:</label>
                    <input type="text" id="pass" name="pass" />

                    <br />

                    <!-- Buttons -->
                    <input class= block type="submit" name="submit" value="Login" />
                    <input class= block type="reset" name="clear" value="Clear" />

            </form>
        </div>
    </body>
</html>
