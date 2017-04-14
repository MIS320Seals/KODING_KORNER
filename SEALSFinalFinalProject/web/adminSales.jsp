<%-- 
    Document   : adminSales
    Created on : Apr 14, 2017, 4:08:50 PM
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
        <ul>
            <li><a href="adminActionPage.jsp">Home</a></li>
            <li><a href="adminEmployees.jsp">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li><a href="AdminController?action=custlist">Customers</a></li>
            <li class = "active"><a href = "AdminController?action=viewSales">Sales</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>

        <h1 style="text-align: center">Sales and Revenue</h1>
        <div>
            <h2 style="margin-left: 5%;">Sales by Genre</h2>
            <table>
                <thead>
                    <tr>
                        <th>Genre</th>
                        <th>Sales</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sale}" var="s">
                        <tr>
                            <td><c:out value="${s.genre}" /></td>
                            <td><c:out value="${s.revenue}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <br>

        <div>
            <h2 style="margin-left: 5%;">Revenue by Store</h2>
            <table>
                <thead>
                    <tr>
                        <th>Store</th>
                        <th>Revenue</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${revenue}" var="s">
                        <tr>
                            <td><c:out value="${s.genre}" /></td>
                            <td><c:out value="${s.revenue}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
