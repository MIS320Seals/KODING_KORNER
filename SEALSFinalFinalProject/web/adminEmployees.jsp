<%-- 
    Document   : adminEmployees
    Created on : Apr 14, 2017, 12:48:15 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li ><a href="adminActionPage.jsp">Home</a></li>
            <li class="active"><a href="adminEmployees.jsp">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li><a href="AdminController?action=custlist">Customers</a></li>
            <li><a href = "AdminController?action=viewSales">Sales</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>
        <br>
        <h1>Admin Employees</h1>
    </body>
</html>
