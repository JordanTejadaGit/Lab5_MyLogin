<%-- 
    Document   : login
    Created on : Jun 19, 2021, 9:00:34 PM
    Author     : 694952
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form>
            <table>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="text" name="password">
                    </td>
                </tr>
            </table>
            <input type="submit" value="Log in" name="login">
        </form>
    </body>
</html>
