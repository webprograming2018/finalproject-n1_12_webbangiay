<%-- 
    Document   : login
    Created on : Nov 11, 2018, 4:47:56 PM
    Author     : Thuy Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
    </head>
    <body>
        <form action="/SHOESWEB/AdminUserServlet" method="POST" style="text-align: center">
            <div class="container">
                <div>Username
                    <input type="text" placeholder="Enter Username" name="username" required></div>
                <br>
                <div>Password
                <input type="password" placeholder="Enter Password" name="password" required>
                </div>
                <br>
                <div><button type="submit">Login</button></div>
            </div>
        </form>
    </body>
</html>
