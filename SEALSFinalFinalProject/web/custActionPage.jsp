<%-- 
    Document   : custActionPage
    Created on : Mar 31, 2017, 3:32:46 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crimson Video Store</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li class = "active"><a href="custActionPage.jsp">Home</a></li>
                <li><a>My Movies</a>
                        <div class="dropdown-content">
                        <a href="#">Checked Out</a>
                        <a href="#">History</a>
                        <a href="#">Cart</a>
                        <a href="CustController?action=TestAddToCart&customer_id=<c:out value="${custBean.customer_id}"/>">Test Checking Out</a>
                    </div></li></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="CustController?action=search">Search</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
    </body>
</html>
