<%-- 
    Document   : adminEmployees
    Created on : Apr 14, 2017, 12:48:15 PM
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
            <li ><a href="AdminController?action=home">Home</a></li>
            <li class="active"><a href="AdminController?action=emplist">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li><a href="AdminController?action=custlist">Customers</a></li>
            <li><a href = "AdminController?action=viewSales">Sales</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>

        <form action="AdminController" method="GET">
            <input type="submit" value="Add New Staff Member" name="action" /> 
        </form>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${emps}" var="e">
                    <tr>
                        <td><c:out value="${e.staff_id}" /></td>
                        <td><c:out value="${e.first_name}" /></td>
                        <td><c:out value="${e.last_name}" /></td>
                        <td><c:out value="${e.email}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
