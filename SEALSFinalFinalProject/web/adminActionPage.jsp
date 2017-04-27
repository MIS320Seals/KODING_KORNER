<%-- 
    Document   : adminActionPage
    Created on : Mar 31, 2017, 3:33:22 PM
    Author     : ering
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        </script>
    </head>
    <body>
        <ul>
            <li class="active"><a href="AdminController?action=home">Home</a></li>
            <li><a href="AdminController?action=emplist">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li><a href="AdminController?action=custlist">Customers</a></li>
            <li><a href = "AdminController?action=viewSales">Sales</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>
        <br>
        
        <h2 style="margin-left: 5%;">Sales by Genre</h2>
            <table>
                <thead>
                    <tr>
                        <th>Film ID</th>
<!--                        <th>Sales</th>-->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${inStock}" var="f">
                        <tr>
                            <td><c:out value="${f.film_id}" /></td>
                            <!-- <td><c:out value="${s.revenue}" /></td> -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        
    </body>
</html>
