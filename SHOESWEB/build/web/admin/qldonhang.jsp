<%-- 
    Document   : qldonhang
    Created on : Dec 22, 2018, 2:58:25 PM
    Author     : Thuy Tran
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Bill"%>
<%@page import="DAO.BillDAO"%>
<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý đơn hàng</title>
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
            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }
            BillDAO billDAO = new BillDAO();
            ArrayList<Bill> listBill1 = new ArrayList<>();
            listBill1 = billDAO.getListBill1();
            ArrayList<Bill> listBill2 = new ArrayList<>();
            listBill2 = billDAO.getListBill2();
            ArrayList<Bill> listBill3 = new ArrayList<>();
            listBill3 = billDAO.getListBill3();
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
                                    Đơn Hàng
                                </h1>
                                <ol class="breadcrumb">
                                    <li>
                                        <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                                    </li>
                                    <li class="active">
                                        <i class="fa fa-table"></i> Đơn Hàng
                                    </li>
                                </ol>
                            </div>

                        </div>
                        <div class="row">
                            <h3>Đơn hàng đang chờ xử lý</h3>
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Mã Hóa Đơn</th>
                                            <th>Ngày Mua</th>
                                            <th>Thanh Toán</th>
                                            <th>Địa Chỉ</th>
                                            <th>Tổng Hóa Đơn</th>
                                            <th>Trạng Thái Đơn Hàng</th>
                                            <th>Tuy chon</th>
                                        </tr>
                                    </thead>
                                <%           int count = 0;
                                    String s = "Đã tiếp nhận";
                                    for (Bill bill : listBill1) {
                                        count++;                                        
                                %>
                                <tbody>
                                    <tr> 
                                        <td><%=bill.getBillID()%></td>
                                        <td><%=bill.getDate()%></td>
                                        <td><%=bill.getPayment()%></td>
                                        <td><%=bill.getAddress()%></td>                                
                                        <td><%=bill.getTotal()%></td>
                                        <td><%=s%></td>
                                        <td>
                                <center>
                                    <a href="/SHOESWEB/ManageBillServlet?command=giao&billid=<%=bill.getBillID()%>">Đang giao</a>&nbsp;                                   
                                </center>
                                </td>
                                </tr>
                                </tbody>                                
                                <% }%>
                                <h4 style="text-align: right; font-weight: bold;">Tổng số đơn: <%=count%></h4>
                            </table>
                        </div>

                        <h3>Đơn hàng đang giao</h3>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Mã Hóa Đơn</th>
                                        <th>Ngày Mua</th>
                                        <th>Thanh Toán</th>
                                        <th>Địa Chỉ</th>
                                        <th>Tổng Hóa Đơn</th>
                                        <th>Trạng Thái Đơn Hàng</th>
                                        <th>Tuy chon</th>
                                    </tr>
                                </thead>
                                <%           int count1 = 0;
                                    String s1 = "Đang giao hàng";
                                    for (Bill bill : listBill2) {
                                        count1++;                                        
                                %>
                                <tbody>
                                    <tr> 
                                        <td><%=bill.getBillID()%></td>
                                        <td><%=bill.getDate()%></td>
                                        <td><%=bill.getPayment()%></td>
                                        <td><%=bill.getAddress()%></td>                                
                                        <td><%=bill.getTotal()%></td>
                                        <td><%=s1%></td>
                                        <td>
                                <center>
                                    <a href="/SHOESWEB/ManageBillServlet?command=hoanthanh&billid=<%=bill.getBillID()%>">Hoàn thành</a>&nbsp;                                   
                                </center>
                                </td>
                                </tr>
                                </tbody>                                
                                <% }%>
                                <h4 style="text-align: right; font-weight: bold;">Tổng số đơn: <%=count1%></h4>
                            </table>
                        </div>

                        <h3>Đơn hàng đã hoàn thành</h3>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Mã Hóa Đơn</th>
                                        <th>Ngày Mua</th>
                                        <th>Thanh Toán</th>
                                        <th>Địa Chỉ</th>
                                        <th>Tổng Hóa Đơn</th>
                                        <th>Trạng Thái Đơn Hàng</th>                                            
                                    </tr>
                                </thead>
                                <%           int count2 = 0;
                                    String s2 = "Hoàn Thành";
                                    for (Bill bill : listBill3) {
                                        count2++;                                        
                                %>
                                <tbody>
                                    <tr> 
                                        <td><%=bill.getBillID()%></td>
                                        <td><%=bill.getDate()%></td>
                                        <td><%=bill.getPayment()%></td>
                                        <td><%=bill.getAddress()%></td>                                
                                        <td><%=bill.getTotal()%></td>
                                        <td><%=s2%></td>
                                    </tr>
                                </tbody>                                
                                <% }%>
                                <h4 style="text-align: right; font-weight: bold;">Tổng số đơn: <%=count2%></h4>
                            </table>
                        </div>
                    </div>

                    </body>
                    </html>
