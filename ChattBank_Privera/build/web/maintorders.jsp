<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: maintorders.jsp
* Due: 09.18.2020
* @authors Ian Mashburn & William G. Weldy
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
--%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML lang="en">

<HEAD>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Maintain Customer Orders || Please give us an A+
    </title>
	<link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="js/empLoginValidation.js"></script>  <!-- Load loginValidation JavaScript -->
</HEAD>

<!--START OF INITIALIZE SESSION OBJECTS-->
<%  
    System.out.println("**************** IN maintorders JSP *****************"); 
    
    //**************************************************************************
    // get empObject from session (includes ArrayList of all orders in DB)
    //**************************************************************************
    Employee empObject = new Employee();
    empObject = (Employee)session.getAttribute("empObject");
    
    empObject.show();
    //empObject.getOrders();
%>
<!--END OF OF INITIALIZE SESSION OBJECTS-->
<BODY>
    
<!-- PAGE LAYOUT GOES HERE -->
    <center><h1>View/Change Customer Order Information</h1></center>
    Click on the text box and type in any valid data value in order to change any one of the attributes. Then click Submit to commit those changes. <br><br>
        <form action="http://localhost:8080/TeamOneSports/UpdateServlet" method="post">
        <table border="3">
		<%  
		Order order;
                
                for ( int i = 0; i < empObject.orderList.oArr.size(); i++ ) {
			order = empObject.orderList.oArr.get(i);
			
                        out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                        out.println("</tr>");
                        
			out.println("<tr>");
                            out.println("<td>Order Number</td>");
                            out.println("<td><input type=\"text\" name=\"OrderNumTxt[" + i + "]\" value=\"" + order.getOrderNumber() + "\" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");		
                            out.println("<td>Customer Number</td>");
                            out.println("<td><input type=\"text\" name=\"CustNumTxt[" + i + "]\" value=\"" + order.getCustNumber() + "\" readonly></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>Product Number</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"ProductNumTxt[" + i + "]\" value=\"" + order.getProductNumber() + "\"/></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>Quantity</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"QuantityTxt[" + i + "]\" value=\"" + order.getQuantity() + "\"/></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>Order Date</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"DateTxt[" + i + "]\" value=\"" + order.getOrderDate() + "\"/></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>Order Time</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"TimeTxt[" + i + "]\" value=\"" + order.getOrderTime() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Order Status</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"StatusTxt[" + i + "]\" value=\"" + order.getOrderStatus() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Order Amount</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"AmountTxt[" + i + "]\" value=\"" + order.getOrderAmount() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Balance</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"BalanceTxt[" + i + "]\" value=\"" + order.getOrderBalance() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>SalesTax</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"TaxTxt[" + i + "]\" value=\"" + order.getOrderSalesTax() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Order Shipping</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"ShippingTxt[" + i + "]\" value=\"" + order.getOrderShippingCost() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Order Total</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"TotalTxt[" + i + "]\" value=\"" + order.getOrderTotal() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Product Size</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"SizeTxt[" + i + "]\" value=\"" + order.getProductSize() + "\"/></td>");
                        out.println("</tr>");
			out.println("<tr>");
                            out.println("<td>Product Gender</td>");
                            out.println("<td><input onkeydown=\"keyDown(event)\" type=\"text\" name=\"GenderTxt[" + i + "]\" value=\"" + order.getProductGender() + "\"/></td>");
                        out.println("</tr>");
                        
			out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                        out.println("</tr>");
			}
		%>
            <tr>
                <td><button type="button" name="backbtn" onclick="history.go(-2)"><< Go To Home Page</button></td>
                <td><input type="Submit" value="* Submit Changes *" /></td>
            </tr>
        </table>
        </form>
<!-- 
    *** available ArrayList of all order objects ->> empObject.orderList.oArr
    ***
    *** refer to the "BUILD searchResult DYNAMIC PRODUCT LIST" section of 
    *** products.jsp to see how you reference each object in the array.
    *** use the getters from the Order.java class to pull data from each ArrayList entry
    ***
    *** don't forget to use external css / uncomment css link in HEAD
-->
    
    <hr>
    <footer>                                    <!-- Page Footer -->
        <small><em>©2020 TeamOne CIST2931 Fall Chattahoochee Tech</em></small>
    </footer>
    
</BODY>
</HTML>
