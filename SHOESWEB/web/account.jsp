<%-- 
    Document   : account
    Created on : Dec 22, 2018, 2:03:00 PM
    Author     : Thuy Tran
--%>

<%@page import="model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.BillDAO"%>
<%@page import="model.TaiKhoan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".dropdown img.flag").addClass("flagvisibility");

                $(".dropdown dt a").click(function () {
                    $(".dropdown dd ul").toggle();
                });

                $(".dropdown dd ul li a").click(function () {
                    var text = $(this).html();
                    $(".dropdown dt a span").html(text);
                    $(".dropdown dd ul").hide();
                    $("#result").html("Selected value is: " + getSelectedValue("sample"));
                });

                function getSelectedValue(id) {
                    return $("#" + id).find("dt a span.value").html();
                }

                $(document).bind('click', function (e) {
                    var $clicked = $(e.target);
                    if (!$clicked.parents().hasClass("dropdown"))
                        $(".dropdown dd ul").hide();
                });


                $("#flagSwitcher").click(function () {
                    $(".dropdown img.flag").toggleClass("flagvisibility");
                });
            });
        </script>
        <!-- start menu -->     
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <!-- end menu -->
        <!-- top scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
                });
            });
        </script>
    </head>
    <body>
        <%
            TaiKhoan users = (TaiKhoan) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("/SHOESWEB/login.jsp");
            }

            long id_user = users.getIdTK();
            BillDAO billDAO = new BillDAO();
            ArrayList<Bill> listBill = new ArrayList<Bill>();
            listBill = billDAO.getBillByUser(id_user);

        %>

        <jsp:include page = "header.jsp"></jsp:include>
            <div class="login">
                <div class="container">
                    <!--nav-->
                    <div class="page-header">
                        <h3>LỊCH SỬ MUA HÀNG</h3>
                    </div>

                    <div class="bs-example wow fadeInRight animated" data-wow-delay=".5s" data-example-id="simple-table">
                        <table class="table">
                            <caption>Đây là danh sách lịch sử mua hàng của bạn.</caption>
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
                        <%           int count = 0;
                            String s = "";
                            for (Bill bill : listBill) {
                                count++;
                                if (bill.getStatus() == 1) {
                                    s = "Đã tiếp nhận";
                                } else if (bill.getStatus() == 2) {
                                    s = "Đang giao hàng";
                                } else {
                                    s = "Hoàn Thành";
                                }
                        %>
                        <tbody>
                            <tr> 
                                <td><%=bill.getBillID()%></td>
                                <td><%=bill.getDate()%></td>
                                <td><%=bill.getPayment()%></td>
                                <td><%=bill.getAddress()%></td>                                
                                <td><%=bill.getTotal()%></td>
                                <%
                                    if (bill.getStatus() == 2) {
                                %>
                                <td><a href="places.jsp?billId=<%=bill.getBillID()%>"><%=s%></a></td>
                                    <% } else {%>
                                <td><%=s%></td>
                                <% }%>
                            </tr>
                        </tbody>                        
                        <% }%>
                        <tfoot style="text-align: right; font-weight: bold;">Tổng số đơn: <%=count%></tfoot>
                    </table>
                </div><!-- /example -->
                <!--//table-->
                <div class="clearfix"> </div>
            </div>
        </div> 
        <div class="clearfix"> </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
