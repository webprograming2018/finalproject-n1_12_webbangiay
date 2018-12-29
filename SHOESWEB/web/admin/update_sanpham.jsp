<%-- 
    Document   : update_sanpham
    Created on : Dec 21, 2018, 2:26:52 AM
    Author     : Thuy Tran
--%>

<%@page import="DAO.DsSanPhamDAO"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật sản phẩm</title>
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

            String productID = "";
            String error = "";
            if (request.getParameter("error") != null) {
                error = (String) request.getParameter("error");
            }
            SanPham product = new DsSanPhamDAO().getProduct(Long.parseLong(request.getParameter("product_id")));

        %>

        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">


            <jsp:include page="side-bar.jsp"></jsp:include>
                <div id="page-wrapper">
                    <div id="rightContent">
                        <h3>Cập nhật sản phẩm</h3>
                        <form action="/SHOESWEB/ManagerProductServlet" method="POST">
                            <table width="95%">

                                <tr><td width="125px"><b>Tên sản phẩm</b></td>
                                    <td><input type="text" name="tenSanPham" value="<%=product.getTenSP()%>"><%=error%></td>
                            </tr>
                            <tr><td><b>Mã loại</b></td><td><input type="text" name="maloai" value="<%=product.getIdDM()%>"><%=error%></td></tr>                                               

                            <tr><td><b>Hình đại diện</b></td><td><input type="text"  name="daidien" value="<%=product.getSPimage()%>"><%=error%></td></tr>
                            <tr><td><b>Giá sản phẩm</b></td><td><input type="text"  name="gia" value="<%=product.getDonGia()%>"><%=error%><b>$</b></td></tr>
                            <tr><td></td><td>
                                    <input type="hidden" name="command" value="update">
                                    <input type="hidden" name="product_id" value="<%=request.getParameter("product_id")%>">
                                    <input type="submit" class="button" value="Lưu dữ liệu">
                                </td>
                            </tr>

                        </table>
                    </form>
                </div>
                <div class="clear"></div>            
            </div>
            </div>
    </body>
</html>
