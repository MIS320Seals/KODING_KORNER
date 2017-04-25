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
                <li><a href="CustController?action=search">Search</a></li>
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
                        Is a 330 TA working for the eternally cheerful Richard Doherty.<br>
                        With her extensive background in database programming Sidney<br>
                        was an easy choice for CDO, Chief Database Officer, and has<br> 
                        been enjoying her role. During the development process she<br>
                        was instrumental in database design and documentation.
                    </td>
                </tr>
                <tr>
                    <td><img src="rex/lauren.jpg" alt=""/></td>
                    <td>Lauren Wright</td>
                    <td>
                        Is a 120 TA working for the fabulous Jeff Lucas.<br>
                        Coming from a strong coding background she was assigned<br>
                        to develop the logic for the business layer of this program.<br> 
                        Her official role is CLO, or Chief Logic Officer, and has<br>
                        met every challenge with graceful determination.
                    </td>
                </tr>
                <tr>
                    <td><img src="rex/Austin.jpg" alt=""/></td>
                    <td>Austin Lucas</td>
                    <td>
                        Is a 220 TA working for coding genius Josh Perdue.<br>
                        He comes from a long dynasty of strong coders, and is our<br>
                        most talented debugger. He is also has an eye for aesthetically <br> 
                        pleasing web page layouts. Drawing on these talents he was,<br>
                        promoted to CSO, or Chief Style Officer.
                    </td>
                </tr>
                <tr>
                    <td><img src="rex/erin.jpg" alt=""/></td>
                    <td>Erin Gronewald</td>
                    <td>
                        Is not a TA for anyone currently. She needed a much deserved<br>
                        calmer semester after managing a house of 67 women for a full year.<br>
                        During her off time she has taken up ceramics and napping. She was<br> 
                        the head developer of the basic user interfaces for this program,<br>
                        and holds the coveted CIO, or Chief Interface Officer, position.
                    </td>
                </tr>
            </table>






        </div>
    </body>
</html>
