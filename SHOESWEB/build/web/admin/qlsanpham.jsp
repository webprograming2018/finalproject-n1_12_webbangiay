<%-- 
    Document   : qlsanpham
    Created on : Nov 11, 2018, 4:45:13 PM
    Author     : Thuy Tran
--%>

<%@page import="model.Admin"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DsSanPhamDAO"%>
<%@page import="model.danhmuc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sản phẩm</title>
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

    </head>
    <body>

        <%
            DsSanPhamDAO dsSanPhamDAO = new DsSanPhamDAO();
            ArrayList<SanPham> listProduct = dsSanPhamDAO.getListProduct();
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
                                    Sản Phẩm
                                </h1>
                                <ol class="breadcrumb">
                                    <li>
                                        <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                                    </li>
                                    <li class="active">
                                        <i class="fa fa-table"></i> Sản Phẩm
                                    </li>
                                </ol>
                            </div>

                        </div>
                        <div class="row">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>

                                            <th>ID sản phẩm</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Id danh mục</th>
                                            <th>Hình ảnh</th>
                                            <!--<th>Trang Thai</th>-->
                                            <th>Đơn giá</th>
                                            <th>Ngay tao</th>
                                            <th>Tuy chon</th>
                                        </tr>
                                    </thead>
                                <%
                                    int count = 0;
                                    for (SanPham sanPham : listProduct) {
                                        count++;
                                %>
                                <tbody>
                                    <tr>

                                        <td><%=sanPham.getIdSP()%></td>
                                        <td><%=sanPham.getTenSP()%></td>
                                        <td><%=sanPham.getIdDM()%></td>
                                        <td><img src="../<%=sanPham.getSPimage()%>"/></td>
                                        <td><%=sanPham.getDonGia()%></td>
                                        <!--<td><%=sanPham.isTrangThai()%></td>-->
                                        <td><%=sanPham.getNgayTao()%></td>
                                        <td>
                                <center>
                                    <a href="update_sanpham.jsp?command=update&product_id=<%=sanPham.getIdSP()%>">Sửa</a>&nbsp;| &nbsp;
                                    <a href="/SHOESWEB/ManagerProductServlet?command=delete&product_id=<%=sanPham.getIdSP()%>">Xóa</a>

                                </center>
                                </td>
                                </tr>

                                </tbody>
                                <%}%>
                            </table>
                            <div><a href="insert-sanpham.jsp">Thêm sản phẩm</a></div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
            </div>
        </div>
    </body>
</html>
