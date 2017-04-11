<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : custSearch
    Created on : Apr 10, 2017, 8:56:27 PM
    Author     : ering
--%>
<%-- not working yet --%>
<%--<sql:query var="actors" dataSource="jdbc/sakila">
    SELECT actor_id, name FROM actor
</sql:query>--%>

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
                <li><a href="custActionPage.jsp">Home</a></li>
                <li><a href="myMovies.jsp">My Movies</a></li>
                <li><a href="about.jsp">About</a></li>
                <li class="active"><a href="custSearch.jsp">Search</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        
        <%-- ACTIONS --%>
        <form name="searchResult" action="custSearchResultPage.jsp">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Search by Category</td>
                        <td><select name="categories">
                                <option>Action</option>
                                <option>Animation</option>
                                <option>Children</option>
                                <option>Classics</option>
                                <option>Comedy</option>
                                <option>Documentary</option>
                                <option>Drama</option>
                                <option>Family</option>
                                <option>Foreign</option>
                                <option>Games</option>
                                <option>Horror</option>
                                <option>Music</option>
                                <option>New</option>
                                <option>Sci-Fi</option>
                                <option>Sports</option>
                                <option>Travel</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Search by Actor</td>
                        <td><select name="actorsFullName">
                                <option>Penelope Guiness</option>
                                <option>Nick Wahlberg</option>
                                <option>Ed Chase</option>
                                <option>Jennifer Davis</option>
                                <option>Johnny Lollobrigida</option>
                                <option>Bette Nicholoson</option>
                                <option>Grace Mostel</option>
                                <option>Matthew Johansson</option>
                                <option>Joe Swank</option>
                                <option>Christian Gable</option>
                                <option>Zero Cage</option>
                                <option>Karl Berry</option>
                                <option>Uma Wood</option>
                                <option>Vivien  Bergen</option>
                                <option>Cuba Olivier</option>
                                <option>Fred Costner</option>
                                <option>Helen Voight</option>
                                <option>Dan Torn</option>
                                <option>Bob Fawcett</option>
                                <option>Lucille Tracy</option>
                                <option>Kirsten Paltrow</option>
                                <option>Elvis Marx</option>
                                <option>Sandra Kilmer</option>
                                <option>Cameron Streep</option>
                                <option>Kevin Bloom</option>
                                <option>Rip Crawford</option>
                                <option>Julia McQueen</option>
                                <option>Woody Hoffman</option>
                                <option>Alec Wayne</option>
                                <option>Sandra Peck</option>
                                <option>Sissy Sobieski</option>
                                <option>Tim Hackman</option>
                                <option>Milla Peck</option>
                                <option>Audrey Olivier</option>
                                <option>Judy Dean</option>
                                <option>Burt Dukakis</option>
                                <option>Val Bolger</option>
                                <option>Tom McKellen</option>
                                <option>Goldie Brody</option>
                                <option>Johnny Cage</option>
                                <option>Jodie Degeneres</option>
                                <option>Tom Miranda</option>
                                <option>Kirk Jovovich</option>
                                <option>Nick Stallone</option>
                                <option>Reese Kilmer</option>
                                <option>Parker Goldberg</option>
                                <option>Julia Barrymore</option>
                                <option>Frances Day-Lewis</option>
                                <option>Anne Cronyn</option>
                                <option>Natalie Hopkins</option>
                                <option>Gary Pheonix</option>
                                <option>Carmen Hunt</option>
                                <option>Mena Hunt</option>
                                <option>Penelope Pinkett</option>
                                <option>Fay Kilmer</option>
                                <option>Dan Harris</option>
                                <option>Jude Cruise</option>
                                <option>Christian Akroyd</option>
                                <option>Dustin Tautou</option>
                                <option>Henry Berry</option>
                                <option>Christian Neeson</option>
                                <option>Jayne Neeson</option>
                                <option>Cameron Wray</option>
                                <option>Ray Johansson</option>
                                <option>Angela Hudson</option>
                                <option>Mary Tandy</option>
                                <option>Jessica Bailey</option>
                                <option>Rip Winslet</option>
                                <option>Kenneth Paltrow</option>
                                <option>Michelle McConaughey</option>
                                <option>Adam Grant</option>
                                <option>Sean Williams</option>
                                <option>Gary Penn</option>
                                <option>Milla Keitel</option>
                                <option>Burt Posey</option>
                                <option>Angelina Astaire</option>
                                <option>Cary McConaughey</option>
                                <option>Groucho Sinatra</option>
                                <option>Mae Hoffman</option>
                                <option>Ralph Cruz</option>
                                <option>Scarlett Damon</option>
                                <option>Woody Jolie</option>
                                <option>Ben Willis</option>
                                <option>James Pitt</option>
                                <option>Minnie Zellweger</option>
                                <option>Greg Chaplin</option>
                                <option>Spencer Peck</option>
                                <option>Kenneth Pesci</option>
                                <option>Charlize Dench</option>
                                <option>Sean Guiness</option>
                                <option>Christopher Berry</option>
                                <option>Kirsten Akroyd</option>
                                <option>Ellen Presley</option>
                                <option>Kenneth Torn</option>
                                <option>Daryl Wahlberg</option>
                                <option>Gene Willis</option>
                                <option>Meg Hawke</option>
                                <option>Chris Bridges</option>
                                <option>Jim Mostel</option>
                                <option>Spencer Depp</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Search by Store</td>
                        <td><select name="storeSelection">
                                <option>1</option>
                                <option>2, currently in beta testing</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Search" name="searchResults" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
        <!--is not working yet
        <h2>Select your search criteria</h2>
        <form action="custSearchResultPage.jsp">
            <table border="0">
                <tbody>
                    <tr>
                        <%-- add the categories from the database --%>
                        <td>Category</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Actor</td>
                        <td>
                            <select name="actor_id">
                                <c:forEach var="row" items="${actors.rows}">
                                    <option value="${row.actor_id}">${row.last_name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Store</td>
                        <td><select name="storeChoice">
                                <option>1</option>
                                <option>2, still in beta testing</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Search" name="searchFilms" /></td>
                    </tr>
                </tbody>
            </table>-->
        </form>
    </body>
</html>
