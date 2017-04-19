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
                <li><a href="custActionPage.jsp">Home</a></li>
                <li><a href="myMovies.jsp">My Movies</a>
                                    <div class="dropdown-content">
                        <a href="#">Checked Out</a>
                        <a href="#">History</a>
                        <a href="#">Wishlist</a>
                    </div></li></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="CustController?action=search">Search</a></li>
                <li class = "active" ><a href="custCheckOutPage.jsp">Check Out</a></li>
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

                            <td><a href="cartController?action=removeCartItem&cart_id=<c:out value="${cart.cartID}"/>">Remove</a></td>
                            <td><a href="cartController?action=addWishList&film_id=<c:out value="${cart.filmID}"/>&title=<c:out value="${cart.title}"/>&price=<c:out value="${cart.price}"/>&rental_duration=<c:out value="${cart.rentalDuration}"/>">Add To Wish List</a></td>

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
