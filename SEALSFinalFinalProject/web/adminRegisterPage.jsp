<%-- 
    Document   : adminRegisterPage
    Created on : Mar 31, 2017, 3:32:31 PM
    Author     : ering
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Register Page</title>
        <link type="text/css"
              href="CSS/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    </head>
    <body>
        <script>
            $(function () {
                $('input[name=last_update]').datepicker();
            });
        </script>
        <h1>Welcome new administrator</h1>
        <h3>Please fill out the following information in order to access your administrative privileges</h3>
        <form method="POST" action='AdminController' name="frmAddAdmin">

            <table border="0">
                <tbody>
                    <tr>
                        <td>Staff ID number:</td>
                        <td><input type="text" name="staff_id" value="<c:out value="${adminBean.staff_id}"  />" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>First name:</td>
                        <td><input type="text" name="first_name" value="<c:out value="${adminBean.first_name}"  />" /></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><input type="text" name="last_name" value="<c:out value="${adminBean.last_name}"  />" /></td>
                    </tr>
                    <tr>
                        <td>Street address:</td>
                        <td><input type="text" name="address_id" value="<c:out value="${adminBean.address_id}"  />" /></td>
                    </tr>
                    <tr>
                        <td>ID picture:</td>
                        <td><input type="submit" value="Upload" name="uploadAdminPic" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" value="<c:out value="${adminBean.email}"  />" /></td>
                    </tr>
                    <tr>
                        <td>Store ID number:</td>
                        <td><input type="text" name="store_id" value="<c:out value="${adminBean.store_id}"  />" /></td>
                    </tr>
                    <tr>
                        <td>Check box if active:</td>
                        <td><input type="checkbox" name="Active" value="ON" checked="checked" /></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="<c:out value="${adminBean.username}"  />" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" value="<c:out value="${adminBean.password}"  />" /></td>
                    </tr>
                    <tr>
                        <td>Please re-enter your password:</td>
                        <td><input type="text" name="password2" value="" /></td>
                    </tr>
                    <tr>
                        <!--come back here and add the ability to select a date from a calendar-->
                        <td>Last Update date:</td>
                        <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${p.sales_date}" />
                            <input type="text" name="last_update" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${adminBean.last_update}" />" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="adminRegister" name="action" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
