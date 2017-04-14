<%-- 
    Document   : adminEmployees
    Created on : Apr 10, 2017, 2:27:36 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <ul>
            <li><a href="adminActionPage.jsp">Home</a></li>
            <li class = "active"><a href="AdminController?action=custlist">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>
        <br>
        <!--
            private String id;
            private String name;
            private String address;
            private String zip;
            private String phoneNumber;
            private String city;
            private String country;
            private String notes;
            private String storeId;
        -->

        <div>
            <br>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Zip</th>
                        <th>Phone</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Notes</th>
                        <th>Store ID</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach  items="${admins}" var="a">
                    <tr>
                        <td><c:out value="${a.id}" /></td>
                    <td><c:out value="${a.name}" /></td>
                    <td><c:out value="${a.address}" /></td>
                    <td><c:out value="${a.zip}" /></td>
                    <td><c:out value="${a.phoneNumber}" /></td>
                    <td><c:out value="${a.city}" /></td>
                    <td><c:out value="${a.country}" /></td>
                    <td><c:out value="${a.notes}" /></td>
                    <td><c:out value="${a.storeId}" /></td>
                    <td><a href="AdminController?action=custinfo&id=${a.id}">View</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p><a href="AdminController?action=addCust">Add Film</a></p>
        </div>
    </body>
</html>
