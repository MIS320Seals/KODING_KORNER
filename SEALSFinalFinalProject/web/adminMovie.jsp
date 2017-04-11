<%-- 
    Document   : adminMovie
    Created on : Apr 4, 2017, 8:55:11 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Films</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <ul>
            <li><a href="adminActionPage.jsp">Home</a></li>
            <li><a href="adminEmployees.jsp">Employees</a></li>
            <li class = "active"><a href="/FilmController?action=list">Films</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Film ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Length</th>
                        <th>Rating</th>
                       
                        <th colspan=2>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${films}" var="film">
                        <tr>
                            <td><c:out value="${film.film_id}" /></td>
                            <td><c:out value="${film.title}" /></td>
                            <td><c:out value="${film.description}" /></td>
                            <td><c:out value="${film.category}" /></td>
                            <td><c:out value="${film.replacement_cost}" /></td>
                            <td><c:out value="${film.length}" /></td>
                            <td><c:out value="${film.rating}" /></td>
                            
                            <td><a href="FilmController?action=edit&filmId=<c:out value="${film.film_id}"/>">Update</a></td>
                            <td><a href="FilmController?action=delete&filmId=<c:out value="${film.film_id}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p><a href="FilmController?action=insert">Add Film</a></p>
        </div>
    </body>
</html>
