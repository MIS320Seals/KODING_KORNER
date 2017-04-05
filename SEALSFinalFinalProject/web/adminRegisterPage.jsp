<%-- 
    Document   : adminRegisterPage
    Created on : Mar 31, 2017, 3:32:31 PM
    Author     : ering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Register Page</title>
    </head>
    <body>
        <h1>Welcome new administrator</h1>
        <h3>Please fill out the following information in order to access your administrative privileges</h3>
        <form action="adminRegister">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Staff ID number:</td>
                        <td><input type="text" name="staff_id" value="" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>First name:</td>
                        <td><input type="text" name="first_name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><input type="text" name="last_name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Street address:</td>
                        <td><input type="text" name="address_id" value="" /></td>
                    </tr>
                    <tr>
                        <td>ID picture:</td>
                        <td><input type="submit" value="Upload" name="uploadAdminPic" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Store ID number:</td>
                        <td><input type="text" name="store_id" value="" /></td>
                    </tr>
                    <tr>
                        <td>Check box if active:</td>
                        <td><input type="checkbox" name="Active" value="ON" checked="checked" /></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>Please re-enter your password:</td>
                        <td><input type="text" name="password2" value="" /></td>
                    </tr>
                    <tr>
                        <!--come back here and add the ability to select a date from a calendar-->
                        <td>Last Update date:</td>
                        <td><input type="text" name="last_update" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enter" name="adminRegister" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
