<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : custSearchResultPage
    Created on : Mar 31, 2017, 3:33:45 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li><a href="LoginController?action=returnHome">Home</a></li>
                <li><a href="myMovies.jsp">My Movies</a>
                                    <div class="dropdown-content">
                        <a href="myMovies.jsp">Checked Out</a>
                        <a href="#">History</a>
                        <a href="#">Wishlist</a>
                    </div></li></li>
                <li><a href="about.jsp">About</a></li>
                <li class="active"><a href="CustController?action=search">Search</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        <br></br>
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
    <body>
</html>
