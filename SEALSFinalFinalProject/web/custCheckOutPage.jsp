<%-- 
    Document   : custCheckOutPage
    Created on : Mar 31, 2017, 3:33:09 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                <li><a href="myMovies.jsp">My Movies</a>
                                    <div class="dropdown-content">
                        <a href="#">Checked Out</a>
                        <a href="#">History</a>
                        <a href="#">Wishlist</a>
                    </div></li></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="custSearch.jsp">Search</a></li>
                <li class = "active" ><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
    </body>
</html>
