<%-- 
    Document   : update_danhmuc
    Created on : Nov 12, 2018, 11:36:37 AM
    Author     : Thuy Tran
--%>

<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật danh mục</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
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
            String error = "";
            if(request.getParameter("error")!=null){
                error = (String) request.getParameter("error");
            }
        %>

        <jsp:include page="header.jsp"></jsp:include>            

            <jsp:include page="side-bar.jsp"></jsp:include>
            <div id="page-wrapper">
                <div id="rightContent">
                    <h3>Cập nhật danh mục</h3>
                    <form action="/SHOESWEB/ManagerCategoryServlet" method="post">
                    <table width="95%">
                        <tr>
                            <td style="float: right"><b>Tên danh mục:</b></td>
                            <td><input type="text" name="tenDanhMuc"><%=error%></td>
                        </tr>
                        <tr><td></td><td>
                                <input type="hidden" name="command" value="update">
                                <input type="hidden" name="category_id" value="<%=request.getParameter("category_id")%>">
                                <input type="submit" class="button" value="Lưu dữ liệu">
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
                <div class="clear"></div>

        </div>


    </body>
</html>


