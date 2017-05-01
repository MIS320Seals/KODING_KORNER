<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : custSearch
    Created on : Apr 10, 2017, 8:56:27 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Crimson Video Store</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li><a href="LoginController?action=returnHome">Home</a></li>
                <li><a href="LoginController?action=userFilms">My Movies</a></li>
                <li><a href="about.jsp">About</a></li>
                <li class="active"><a href="CustController?action=search">Search</a></li>
                <li><a href="cartController?action=checkOutCart">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        
        <%-- ACTIONS --%>
        <form action="CustController" method="POST">
        <!--<form method="POST" action='CustController' name="frmSearch">-->
            <table border="0">
                <tbody>
                    <tr>
                        <td>Search by Category</td>
                        <td><select name="categories" >
                                <option>Select Category</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.category_id}"><c:out value="${category.name}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Search by Actor</td>
                        <td><select name="actorsFullName" >
                                <option>Select Actor</option>
                                <c:forEach items="${actors}" var="actor">
                                    <option value="${actor.actor_id}"><c:out value="${actor.first_name} ${actor.last_name}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Search by Store</td>
                        <td><select name="storeSelection">
                                <option>1</option>
                                <option>2, currently in beta testing</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="searchMultiples"/></td></td>
                        <td><input type="submit" value="Search" name="searchResults" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
