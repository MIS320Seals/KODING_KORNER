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
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li class = "active"><a href="custActionPage.jsp">Home</a></li>
                <li><a>My Movies</a>
                        <div class="dropdown-content">
                        <a href="RentalController?action=displayReturns">Return Movie</a>
                        <a href="#">Checked Out</a>
                        <a href="#">History</a>
                        <a href="cartController?action=displayCart">Cart</a>
                        <a href="CustController?action=TestAddToCart&customer_id=<c:out value="${custBean.customer_id}"/>">Test Checking Out</a>
                    </div></li></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="CustController?action=search">Search</a></li>
                <li><a href="cartController?action=checkOutCart">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
         <table>
                <thead>
                    <tr>
                        <th>Rental ID</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Date Added</th>
                        <th>Rental Duration</th>
                        <th>Days Rented</th>
                        <th>Days Left on Rental</th>
                        <th colspan=2>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach end="300" items="${returns}" var="return">
                        <tr>
                            <td><c:out value="${return.rentalID}" /></td>
                            <td><c:out value="${return.movieTitle}" /></td>
                            <td><c:out value="${return.rentalRate}" /></td>
                            <td><c:out value="${return.rentalDate}" /></td>
                            <td><c:out value="${return.rentalDuration}" /></td>
                            <td><c:out value="${return.daysRented}" /></td>
                            <td><c:out value="${return.daysLeft}" /></td>

                           <td><a href="RentalController?action=returnItem&rentalID=<c:out value="${return.rentalID}"/>&daysLeft=<c:out value="${return.daysLeft}"/>&rentalRate=<c:out value="${return.rentalRate}"/>">Return</a></td>
                           
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        
        <form action="cartController" >
            <input type="submit" value="Check Out" name="payment" />
            <input type="hidden" name="action" value="payment"/>
        </form>
    </body>
</html>
