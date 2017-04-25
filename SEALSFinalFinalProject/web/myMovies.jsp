<%-- 
    Document   : myMovies
    Created on : Mar 31, 2017, 5:00:29 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Movies</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li><a href="LoginController?action=returnHome">Home</a></li>
                <li class = "active"><a href="myMovies.jsp">My Movies</a>
                        <div class="dropdown-content">
                        <a href="#">Checked Out</a>
                        <a href="#">History</a>
                        <a href="#">Wishlist</a>
                    </div></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="CustController?action=search">Search</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">${custbean.email} Log-out</a></li>
            </ul>
        </div>
            
            <br></br>
            <h1>Here are your Movies</h1>
            <br></br>
            <h2>Currently Rented Movies</h2>
            <table>
                <thead>
                    <tr>
                        <!--<th>Film ID</th>-->
                        <th>Title</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Release Year</th>
                        <th>Rating</th>
                        <!--<th>Rental Duration</th>-->
                        <th colspan=2>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach end="300" items="${films}" var="film">
                        <tr>
                            <!--<td><c:out value="${film.film_id}" /></td>-->
                            <td><c:out value="${film.title}" /></td>
                            <td><c:out value="${film.description}" /></td>
                            <td><c:out value="${film.rental_rate}" /></td>
                            <td><c:out value="${film.release_year}" /></td>
                            <td><c:out value="${film.rating}" /></td>
                            <!--<td><c:out value="${film.rental_duration}" /></td>-->

                            <td><a href="cartController?action=addCart&film_id=<c:out value="${film.film_id}"/>&title=<c:out value="${film.title}"/>&price=<c:out value="${film.rental_rate}"/>&rental_duration=<c:out value="${film.rental_duration}"/>">Add To Cart</a></td>
                            <td><a href="cartController?action=addWishList&film_id=<c:out value="${film.film_id}"/>&title=<c:out value="${film.title}"/>&price=<c:out value="${film.rental_rate}"/>&rental_duration=<c:out value="${film.rental_duration}"/>">Add To Wish List</a></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br></br>
            <h2>Wishlist Movies</h2>
                            
<!--            <form action="cartController" method="POST" style = "margin: auto; width: 90%;">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Film ID</td>
                            <td><input type="text" name="film_id" value="${filmBean.film_id}"  /></td>
                        </tr>
                        <tr>
                            <input type="hidden" name="action" value="addToCart"/></td>
                            <input type="hidden" name="customer_id" value="${custBean.customer_id}"/></td>
                            <td><input type="submit" value="Enter" name="AddToCart" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        <%-- Table --%>
    <f:view>
        <h:form>
            <h:dataTable value="" var="item">
            </h:dataTable>
        </h:form>
    </f:view>-->
</body>
</html>
