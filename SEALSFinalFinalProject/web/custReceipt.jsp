<%-- 
    Document   : custCheckOutPage
    Created on : Mar 31, 2017, 3:33:09 PM
    Author     : ering
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <jsp:useBean id="cart" scope="session" class="com.SEALS.cart.Cart" />

        <jsp:setProperty name="cartSum" property="price" />




        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 

                <li class = "active"><a href="LoginController?action=returnHome">Home</a></li>
                <li><a href="LoginController?action=userFilms">My Movies</a>
                <li><a href="about.jsp">About</a></li>
                <li><a href="CustController?action=search">Search</a></li>
                <li><a href="cartController?action=checkOutCart">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Date Added</th>
                    <th>Rental Duration</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach end="300" items="${carts}" var="cart">
                    <tr>
                        <td><c:out value="${cart.filmID}" /></td>
                        <td><c:out value="${cart.title}" /></td>
                        <td><c:out value="${cart.price}" /></td>
                        <td><c:out value="${cart.dateAdded}" /></td>
                        <td><c:out value="${cart.rentalDuration}" /></td>


                    </tr>
                </c:forEach>
            <html 
                </tbody>
        </table>


        <h1>Notice: Some movies may not have been purchased due to lack of inventory. The movies listed above are what was purchased </h1>
        <h1>Your Total Purchase is $<jsp:getProperty name="cartSum" property="price" /> </h1>
        <form action="cartController" >
            <input type="hidden" name="action" value="payment"/>
        </form>
    </body>
</html>
