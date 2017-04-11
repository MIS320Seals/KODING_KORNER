<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : custSearchResultPage
    Created on : Mar 31, 2017, 3:33:45 PM
    Author     : ering
--%>
<!--not working yet-->
<%--<sql:query var="actorQuery" dataSource="jdbc/sakila">
    SELECT * FROM actor
    WHERE actor.actor_id = ? <sql:param value="${param.actor_id}"/>
</sql:query>
<c:set var="actorFullName" value="${actorQuery.rows[0]}"/>--%>
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
                <li><a href="custActionPage.jsp">Home</a></li>
                <li><a href="myMovies.jsp">My Movies</a></li>
                <li><a href="about.jsp">About</a></li>
                <li class="active"><a href="custSearch.jsp">Search</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        
        <%-- ACTIONS --%>
        
        
        <!--section of the code is not working
        <table border="0">
            <thead>
                <tr>
                    <th>Actor Name</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${actorFullName.first_name} ${actorFullName.last_name}</td>
                </tr>
            </tbody>
        </table>-->

    <body>
</html>
