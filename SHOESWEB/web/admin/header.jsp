<%-- 
    Document   : header
    Created on : Nov 11, 2018, 3:31:23 PM
    Author     : Thuy Tran
--%>

<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
    </head>
    <body>
        <%
            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }
        %>
        <!-- Brand and toggle get grouped for better display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Admin</a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">

            <li class="dropdown">
                <%if(useradmin!=null){ %>
                <i class="fa fa-user"></i><%=useradmin.getAdminName()%><b class="caret"></b>
                <% } %>
            </li>
            <li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a></li>
        </ul>

    </body>
</html>
