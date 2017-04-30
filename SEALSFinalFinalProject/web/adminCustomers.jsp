<%-- 
    Document   : adminEmployees
    Created on : Apr 10, 2017, 2:27:36 PM
    Author     : Austin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <ul>
            <li><a href="AdminController?action=home">Home</a></li>
            <li><a href="AdminController?action=emplist">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li class="active"><a href="AdminController?action=custlist">Customers</a></li>
            <li><a href = "AdminController?action=viewSales">Sales</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>
       
        <div>
            <p><a href="custRegisterPage.jsp" style="text-decoration: none; margin-left: 5%;">Add Customer</a></p>
            <table style="text-align: center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Notes</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach  items="${c}" var="a">
                    <tr>
                        <td><c:out value="${a.id}" /></td>
                        <td><c:out value="${a.name}" /></td>
                        <td><c:out value="${a.phoneNumber}" /></td>
                        <td><c:out value="${a.notes}" /></td>
                        <td><a href="AdminController?action=custinfo&filmId=${a.id}">View</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            
        </div>
    </body>
</html>
