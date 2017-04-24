<%-- 
    Document   : adminActionPage
    Created on : Mar 31, 2017, 3:33:22 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawStuff);

            function drawStuff() {
                var data = new google.visualization.arrayToDataTable([
                    ['Opening Move', 'Percentage'],
                    ["King's pawn (e4)", 44],
                    ["Queen's pawn (d4)", 31],
                    ["Knight to King 3 (Nf3)", 12],
                    ["Queen's bishop pawn (c4)", 10],
                    ['Other', 3]
                ]);

                var options = {
                    title: 'Chess opening moves',
                    width: 900,
                    legend: {position: 'none'},
                    chart: {title: 'Chess opening moves',
                        subtitle: 'popularity by percentage'},
                    bars: 'horizontal', // Required for Material Bar Charts.
                    axes: {
                        x: {
                            0: {side: 'top', label: 'Percentage'} // Top x-axis.
                        }
                    },
                    bar: {groupWidth: "90%"}
                };

                var chart = new google.charts.Bar(document.getElementById('top_x_div'));
                chart.draw(data, options);
            }
            ;
        </script>
    </head>
    <body>
        <ul>
            <li class="active"><a href="adminActionPage.jsp">Home</a></li>
            <li><a href="AdminController?action=emplist">Employees</a></li>
            <li><a href="FilmController?action=list">Films</a></li>
            <li><a href="AdminController?action=custlist">Customers</a></li>
            <li><a href = "AdminController?action=viewSales">Sales</a></li>
            <li><a href="loginPage.jsp">Log-out</a></li>
        </ul>
        <br>
        <div id="top_x_div" style="width: 900px; height: 500px;"></div>
    </body>
</html>
