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
                <li class = "active"><a href="myMovies.jsp">My Movies</a>
                        <div class="dropdown-content">
                        <a href="#">Checked Out</a>
                        <a href="#">History</a>
                        <a href="#">Wishlist</a>
                    </div></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="CustController?action=search">Search</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">${custbean.email} Log-out</a></li>
            </ul>
        </div>
            
            <form action="cartController" method="POST" style = "margin: auto; width: 90%;">
                <table border="0">
                    <tbody>
                        <tr>

                            <td>Film ID</td>
                            <td><input type="text" name="film_id" value="${filmBean.film_id}"  /></td>

                        </tr>
                        
                        <tr>
                            <input type="hidden" name="action" value="addToCart"/></td>
                            <input type="hidden" name="customer_id" value="${custBean.customer_id}"/></td>
                            <td><input type="submit" value="Enter" name="AddToCart" /></td>
                        </tr>
        
                    </tbody>
                </table>

            </form>


        <%-- Table --%>

    <f:view>
        <h:form>
            <h:dataTable value="" var="item">
            </h:dataTable>
        </h:form>
    </f:view>

</body>
</html>
