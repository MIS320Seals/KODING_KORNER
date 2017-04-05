<%-- 
    Document   : myMovies
    Created on : Mar 31, 2017, 5:00:29 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li><a href="custActionPage.jsp">Home</a></li>
                <li class = "active"><a href="myMovies.jsp">My Movies</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        
        
        
        <%-- Table --%>
        
    <f:view>
        <h:form>
            <h:dataTable value="" var="item">
            </h:dataTable>
        </h:form>
    </f:view>

    </body>
</html>
