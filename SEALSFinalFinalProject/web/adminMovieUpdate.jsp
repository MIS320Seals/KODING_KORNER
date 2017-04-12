<%-- 
    Document   : adminMovieUpdate
    Created on : Apr 11, 2017, 4:14:28 PM
    Author     : Austin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <h1>Movie Edit</h1>
        <div>
            <form method="POST" action='FilmController' name="frmAddProduct">
                Film Id:
                <br>
                <input type="number"  name="filmId"
                       value="<c:out value="${film.film_id}" />" readonly autofocus required min="1"/> 
                </br>

                Title:
                <br>
                <input type="text" name="title" value="<c:out value="${film.title}" />" />
                </br>

                Description:
                <br>
                <input type="text" name="description" value="<c:out value="${film.description}" />" />
                </br>

                Release Date: <br>
                <input
                    type="text" name="releaseYear"  pattern = "[0-9]{2}/[0-9]{2}/[0-9]{4}" placeholder = "[MM/DD/YYYY]"
                    value="<fmt:formatDate pattern="MM/dd/yyyy" value="${film.release_year}" />" required /> 
                </br> 
                
                Rental Rate:
                <br>
                <input type="number"  name="rentalRate"
                       value="<c:out value="${film.rental_rate}" />" required/> 
                </br>
                
                Length:
                <br>
                <input type="number"  name="length"
                       value="<c:out value="${film.length}" />" required/> 
                </br>

                Replacement Cost:
                <br>
                <input type="number"  name="replacementCost"
                       value="<c:out value="${film.replacement_cost}" />" required /> 
                </br>

                Rating:
                <br>
                <input type="text"  name="rating"
                       value="<c:out value="${film.rating}" />" required /> 
                </br>
                <input type="submit" value="Submit" />
                
            </form>
        </div>
    </body>
</html>
