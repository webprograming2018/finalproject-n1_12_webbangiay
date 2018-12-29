<%-- 
    Document   : index
    Created on : Nov 11, 2018, 3:38:36 PM
    Author     : Thuy Tran
--%>

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
            $(function () {
                var startDate;
                var endDate;

                var selectCurrentWeek = function () {
                    window.setTimeout(function () {
                        $('.ui-weekpicker').find('.ui-datepicker-current-day a').addClass('ui-state-active').removeClass('ui-state-default');
                    }, 1);
                }

                var setDates = function (input) {
                    var $input = $(input);
                    var date = $input.datepicker('getDate');
                    if (date !== null) {
                        var firstDay = $input.datepicker("option", "firstDay");
                        var dayAdjustment = date.getDay() - firstDay;
                        if (dayAdjustment < 0) {
                            dayAdjustment += 7;
                        }
                        startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - dayAdjustment);
                        endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - dayAdjustment + 7);

                        var inst = $input.data('datepicker');
                        var dateFormat = inst.settings.dateFormat || $.datepicker._defaults.dateFormat;
                        $('#startDate').text($.datepicker.formatDate(dateFormat, startDate, inst.settings));
                        $('#endDate').text($.datepicker.formatDate(dateFormat, endDate, inst.settings));
                        var x = document.getElementById("startDate").innerHTML;
                        var x2 = x.replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$1-$2");
                        var y = document.getElementById("endDate").innerHTML;
                        var y2 = y.replace(/(\d\d)\/(\d\d)\/(\d{4})/, "$3-$1-$2");
                        $('#test3').val(x2);
                        $('#test4').val(y2);
                    }
                }

                $('.week-picker').datepicker({
                    beforeShow: function () {
                        $('#ui-datepicker-div').addClass('ui-weekpicker');
                        selectCurrentWeek();
                    },
                    onClose: function () {
                        $('#ui-datepicker-div').removeClass('ui-weekpicker');
                    },
                    showOtherMonths: true,
                    selectOtherMonths: true,
                    onSelect: function (dateText, inst) {
                        setDates(this);
                        selectCurrentWeek();
                        $(this).change();
                    },
                    beforeShowDay: function (date) {
                        var cssClass = '';
                        if (date >= startDate && date <= endDate)
                            cssClass = 'ui-datepicker-current-day';
                        return [true, cssClass];
                    },
                    onChangeMonthYear: function (year, month, inst) {
                        selectCurrentWeek();
                    }
                });

                setDates('.week-picker');

                var $calendarTR = $('.ui-weekpicker .ui-datepicker-calendar tr');
                $calendarTR.live('mousemove', function () {
                    $(this).find('td a').addClass('ui-state-hover');
                });
                $calendarTR.live('mouseleave', function () {
                    $(this).find('td a').removeClass('ui-state-hover');
                });
            });
        </script>
    </head>
    <body>
        <%
            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }
            String ngaybd = "";
            String ngaykt = "";

            ngaybd = request.getParameter("ngaybd");
            ngaykt = request.getParameter("ngaykt");

            ThongKeDAO thongKeDAO = new ThongKeDAO();
            ArrayList<Bill> listBill = thongKeDAO.doanhThuTuan(ngaybd, ngaykt);
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
                                <div><h2>Thống kê doanh thu</h2></div>                                
                                <form action="/SHOESWEB/ThongKeServlet" method="POST">
                                    <input class="week-picker" placeholder="Click to select week"></input>
                                    <br /><br />
                                    <label>Week :</label> <span id="startDate"></span> - <span id="endDate"></span>
                                    <p>Ngày bắt đầu: <input type="text" name ="ngaybd" id="test3"  ></p>
                                    <p>Ngày kết thúc: <input type="text" name="ngaykt" id="test4"  ></p>
                                    <p>
                                        <input type="hidden" name="command" value="doanhthuweek">
                                        <input type="submit" class="button" value="Xem">
                                    </p>
                                </form>
                                <!--<form action="/SHOESWEB/ThongKeServlet" method="POST">
                                    <p><input id="startDate" name ="ngaybd" placeholder="DD/MM/YYYY"></p>
                                    <p><input id="endDate" name="ngaykt" placeholder="DD/MM/YYYY" ></p>
                                    <p>
                                        <input type="hidden" name="command" value="doanhthuweek">
                                        <input type="submit" class="button" value="Xem">
                                    </p>
                                </form>-->                                

                                <div><h4>Doanh Thu Theo Ngày</h4></div>
                                <div>
                                    <form action="/SHOESWEB/ThongKeServlet" method="POST">
                                        <div><input type="text" name="ngaybd" placeholder="Chọn Ngày"></input>
                                        </div>
                                        <div><input type="text" name="ngaykt" placeholder="Chọn Ngày"></input>
                                        </div>
                                        <p>
                                            <input type="hidden" name="command" value="doanhthuday">
                                            <input type="submit" class="button" value="Xem">
                                        </p>                                        
                                    </form>
                                </div>


                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>

                                            <th>ID Đơn Hàng</th>
                                            <th>Ngày đặt</th>
                                            <!--<th>Trang Thai</th>-->
                                            <th>Thành Tiền</th>                                            
                                        </tr>
                                    </thead>
                                <%
                                    int tongdt = 0, count = 0;
                                    for (Bill bill : listBill) {
                                        tongdt += bill.getTotal();
                                        count++;
                                %>
                                <tbody>
                                    <tr>

                                        <td><%=bill.getBillID()%></td>
                                        <td><%=bill.getDate()%></td>                                       
                                        <td><%=bill.getTotal()%></td>
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
