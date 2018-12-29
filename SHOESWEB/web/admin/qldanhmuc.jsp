<%-- 
    Document   : qldanhmuc
    Created on : Nov 11, 2018, 4:20:49 PM
    Author     : Thuy Tran
--%>

<%@page import="model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.danhmuc"%>
<%@page import="DAO.DanhMucDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <title>Quản lý danh mục</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        
        <link href="css/sb-admin.css" rel='stylesheet' type='text/css' />

    </head>
    <body>

        <%
            DanhMucDAO categoryDAO = new DanhMucDAO();
            ArrayList<danhmuc> listCategory = categoryDAO.getListCategory();
            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }
        %>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <jsp:include page="header.jsp"></jsp:include>

                <jsp:include page="side-bar.jsp"></jsp:include>
                </nav>

                <div id="page-wrapper">

                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    Danh muc
                                </h1>
                                <ol class="breadcrumb">
                                    <li>
                                        <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                                    </li>
                                    <li class="active">
                                        <i class="fa fa-table"></i> Danh muc
                                    </li>
                                </ol>
                            </div>

                        </div>
                        <div class="row">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            
                                            <th>ID danh muc</th>
                                            <th>Ten DM</th>
                                            <!--<th>Trang Thai</th>-->
                                            <th>Ngay tao</th>
                                            <th>Tuy chon</th>
                                        </tr>
                                    </thead>
                                <%
                                    int count = 0;
                                    for (danhmuc category : listCategory) {
                                        count++;
                                %>
                                <tbody>
                                    <tr>
                                        
                                        <td><%=category.getIdDM()%></td>
                                        <td><%=category.getTenDM()%></td>
                                        <!--<td><%=category.isTrangThai()%></td>-->
                                        <td><%=category.getNgayTao()%></td>
                                        <td>
                                <center>
                                    <a href="update_danhmuc.jsp?command=update&category_id=<%=category.getIdDM()%>">Sửa</a>&nbsp;&nbsp;
                                  
                                </center>
                                </td>
                                </tr>
                                
                                </tbody>
                                <%}%>
                            </table>
                            <div><a href="insert-danhmuc.jsp">Thêm danh mục</a></div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
            </div>
        </div>
    </body>
</html>
