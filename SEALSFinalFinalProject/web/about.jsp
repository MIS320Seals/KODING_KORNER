<%-- 
    Document   : about
    Created on : Mar 31, 2017, 4:46:17 PM
    Author     : Austin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    </head>
    <body>
        <%-- NAV BAR --%>
        <div class = "loginBar">
            <ul> 
                <li><a href="custActionPage.jsp">Home</a></li>
                <li><a href="myMovies.jsp">My Movies</a></li>
                <li class = "active"><a href="about.jsp">About</a></li>
                <li><a href="custCheckOutPage.jsp">Check Out</a></li>
                <li><a href="loginPage.jsp">Log-out</a></li>
            </ul>
        </div>
        
        <%-- Table for the team  --%>
        
        <div class ="peeps" >

            <h1 style = "text-align: center">Crimson Movie Team</h1>
            <table  border="0" cellpadding="3">
                <tr>
                    <td><img src="rex/sidney.jpg" alt=""/></td>
                    <td>Sidney Bomeke</td>
                    <td>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
                        Fusce condimentum massa sed ex luctus fringilla. Praesent<br>
                        ullamcorper ante nec odio tincidunt scelerisque. Nam elementum,<br> 
                        purus sit amet ultrices scelerisque, magna quam molestie tortor,<br>
                        sed feugiat purus quam vel libero. Nulla in viverra justo.
                    </td>
                </tr>
                <tr>
                    <td><img src="rex/lauren.jpg" alt=""/></td>
                    <td>Lauren Wright</td>
                    <td>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
                        Fusce condimentum massa sed ex luctus fringilla. Praesent<br>
                        ullamcorper ante nec odio tincidunt scelerisque. Nam elementum,<br> 
                        purus sit amet ultrices scelerisque, magna quam molestie tortor,<br>
                        sed feugiat purus quam vel libero. Nulla in viverra justo.
                    </td>
                </tr>
                <tr>
                    <td><img src="rex/Austin.jpg" alt=""/></td>
                    <td>Austin Lucas</td>
                    <td>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
                        Fusce condimentum massa sed ex luctus fringilla. Praesent<br>
                        ullamcorper ante nec odio tincidunt scelerisque. Nam elementum,<br> 
                        purus sit amet ultrices scelerisque, magna quam molestie tortor,<br>
                        sed feugiat purus quam vel libero. Nulla in viverra justo.
                    </td>
                </tr>
                <tr>
                    <td><img src="rex/erin.jpg" alt=""/></td>
                    <td>Erin Gronewald</td>
                    <td>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
                        Fusce condimentum massa sed ex luctus fringilla. Praesent<br>
                        ullamcorper ante nec odio tincidunt scelerisque. Nam elementum,<br> 
                        purus sit amet ultrices scelerisque, magna quam molestie tortor,<br>
                        sed feugiat purus quam vel libero. Nulla in viverra justo.
                    </td>

                </tr>
            </table>






        </div>
    </body>
</html>
