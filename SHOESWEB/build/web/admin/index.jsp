<%-- 
    Document   : index
    Created on : Nov 11, 2018, 3:38:36 PM
    Author     : Thuy Tran
--%>

<%@page import="model.TaiKhoan"%>
<%@page import="DAO.BillDAO"%>
<%@page import="DAO.DsSanPhamDAO"%>
<%@page import="DAO.TkhoanDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Bill"%>
<%@page import="DAO.ThongKeDAO"%>
<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <base href="http://localhost:8080/SHOESWEB/admin/css">
        <base href="http://localhost:8080/SHOESWEB/admin/font-awesome">
        <base href="http://localhost:8080/SHOESWEB/admin/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
        <!-- Custom CSS -->
        <link href="css/bootstrap-datetimepicker.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">
        <script src="js/locales/bootstrap-datetimepicker.pt-BR.js" type="text/javascript"></script>
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css">        
        <script type="text/javascript">
            var time = new Date().getTime();
            $(document.body).bind("mousemove keypress", function (e) {
                time = new Date().getTime();
            });

            function refresh() {
                if (new Date().getTime() - time >= 6000)
                    window.location.reload(true);
                else
                    setTimeout(refresh, 1000);
            }

            setTimeout(refresh, 1000);
        </script>

    </head>
    <body>
        <%
            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }

            BillDAO billDAO = new BillDAO();
            ArrayList<Bill> listBill = new ArrayList<>();
            listBill = billDAO.getListBillAll();
            TkhoanDAO user = new TkhoanDAO();            
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
                                    Dashboard <small>Overview</small>
                                </h1>
                                <div><h2>Thống kê</h2></div>                                

                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>

                                            <th>ID Đơn Hàng</th>
                                            <th>Ngày đặt</th>
                                            <th>Ten KH</th>
                                            <!---->
                                            <th>Thành Tiền</th> 
                                            <th>Trang Thai</th>
                                        </tr>
                                    </thead>
                                <%
                                    int tongdt = 0, count = 0;
                                    for (Bill bill : listBill) {
                                        tongdt += bill.getTotal();
                                        count++;
                                        TaiKhoan u = user.getUserById(bill.getUserID());
                                %>
                                <tbody>
                                    <tr>

                                        <td><%=bill.getBillID()%></td>
                                        <td><%=bill.getDate()%></td>  
                                        <td><%=u.getName()%></td>  
                                        <td><%=bill.getTotal()%></td>
                                        <td><%=bill.getStatus()%></td>  
                                    </tr>
                                </tbody>                                
                                <%}%>

                            </table>
                            <div style="text-align: right; font-weight: bold;">TỔNG SỐ ĐƠN: <%=count%></div>
                            <div style="text-align: right; font-weight: bold;">TỔNG DOANH THU: <%=tongdt%></div>

                        </div>
                    </div>
                    <!-- /.row -->
                </div>
            </div>
        </div>
    </body>
</html>
