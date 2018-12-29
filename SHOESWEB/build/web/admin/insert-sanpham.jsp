<%-- 
    Document   : insert-sanpham
    Created on : Nov 11, 2018, 4:47:35 PM
    Author     : Thuy Tran
--%>

<%@page import="model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.danhmuc"%>
<%@page import="DAO.DanhMucDAO"%>
<%@page import="DAO.DsSanPhamDAO"%>
<%@page import="java.util.Locale.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm sản phẩm</title>
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
            String error = "";
            if (request.getParameter("error") != null) {
                error = (String) request.getParameter("error");
            }

            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }

        %>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper"> 

            <jsp:include page="side-bar.jsp"></jsp:include>
            <div id="page-wrapper">
                <div id="rightContent">
                    <h3>THÊM SẢN PHẨM MỚI</h3>                    
                    <form method="POST" action="/SHOESWEB/InsertProductServlet" enctype="multipart/form-data">

                        <table> <tr>

                            </tr>
                            <tr><td><b></b></td><td><input type="hidden" class="sedang" name="maSanPham"><%=error%></td></tr> 

                        <tr><td><b>Tên danh mục</b></td><td>
                                <div>
                                    <span></span>
                                    <select name="maloai">
                                        <%
                                            for (danhmuc c : listCategory) {
                                        %>
                                        <option value="<%=c.getIdDM()%>"><%=c.getTenDM()%></option>
                                        <% }%>

                                    </select>
                                </div>
                                <input type="hidden" class="sedang" name=""><%=error%></td></tr>
                        <tr><td><b>Tên sản phẩm</b></td><td><input type="text" name="tenSanPham"><%=error%></td></tr>
                       
                        <tr><td><b>Hình đại diện</b></td><td><input type="file" placeholder="images/tênhình.jpg"  name="daidien"><%=error%></td><</tr>
                        <tr><td><b>Giá sản phẩm</b></td><td><input type="text" class="sedang" name="gia"><%=error%><b>$</b></td></tr>
                        <tr><td></td><td>

                                <input type="submit" class="button" value="Thêm sản phẩm">                                

                            </td></tr>
                    </table>
                </form>
               <!-- <form method="post" action="/MusicShop/UploadProductServlet" enctype="multipart/form-data">
                    <table width="95%">
                        <tr><td><b>Upload hình ảnh sản phẩm</b></td><td><input type="file" name="uploadFile"></td><br>
                        <td><input type="file" name="uploadFile"></td><td><input type="file"  name="uploadFile"></td></tr>
                        <br/>
                        <tr><td></td><td>
                                <input type="submit" class="button" value="Tải lên" />
                            </td></tr>
                    </table>
                </form>-->
            </div>
            <div class="clear"></div>            
            </div>
        </div>
    </body>
</html>
