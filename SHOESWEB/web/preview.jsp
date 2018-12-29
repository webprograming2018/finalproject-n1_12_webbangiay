<%-- 
    Document   : preview
    Created on : Dec 19, 2018, 11:20:49 AM
    Author     : Thuy Tran
--%>

<%@page import="model.TaiKhoan"%>
<%@page import="model.Carts"%>
<%@page import="java.util.Map"%>
<%@page import="model.Items"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/SHOESWEB/css">
        <base href="http://localhost:8080/SHOESWEB/js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preview Your Bill</title>
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
        <link href="css/bootstrap_1.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style_1.css" rel="stylesheet" type="text/css" media="all" />
        <!-- js -->
        <script src="js/jquery.min_1.js"></script>
        <!-- //js -->
        <!-- cart -->
        <script src="js/simpleCart.min.js"></script>
        <!-- cart -->
        <!-- for bootstrap working -->
        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
        <!-- //for bootstrap working -->
        <!-- animation-effect -->
        <link href="css/animate.min.css" rel="stylesheet"> 
        <script src="js/wow.min.js"></script>
        <script>
            new WOW().init();
        </script>
        <!-- //animation-effect -->
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
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            Carts cart = (Carts) session.getAttribute("cart");
            String payment = request.getParameter("payment");
            String address = request.getParameter("address");
            TaiKhoan users = (TaiKhoan) session.getAttribute("user");
            
        %>
        <jsp:include page = "header.jsp"></jsp:include>
            <div class="check-out">	 
                <div class="container">	 

                    <table class="table animated wow fadeInLeft" data-wow-delay=".5s">
                        <tr>
                            <th class="t-head">Hình ảnh</th>
                            <th class="t-head ">Mặt Hàng</th>
                            <th class="t-head">Giá</th>
                            <th class="t-head">Size</th>
                            <th class="t-head">Số Lượng</th>
                            <th class="t-head"></th>

                        </tr>

                    <%for (Map.Entry<Integer, Items> list : cart.getCartItems().entrySet()) {%>
                    <tr class="cross1">
                        <td class="t-data">
                            <div class="list_img">
                                <img src="<%=list.getValue().getProduct().getSPimage()%>" class="fashion-grid" alt=""> 

                            </div>
                        </td>
                        <td class="t-data">

                            <h3><%=list.getValue().getProduct().getTenSP()%></h3>
                        </td>
                        <td class="t-data">$<%=(list.getValue().getProduct().getDonGia())%></td>
                        <td class="t-data"><%=list.getValue().getSize()%></td>
                        <td class="t-data"><%=list.getValue().getQuantity()%></td>
                    </tr>

                    <% }%>
                </table>
                <div>Tên khách hàng: <span><%=users.getName()%></span></div><br>
                <form action="CheckOutServlet" method="POST">
                    <div>Địa chỉ giao hàng: <input name="address" value="<%=request.getParameter("address")%>"></div><br>
                    <div>Phương thức thanh toán: <input name="payment" value="<%=request.getParameter("payment")%>"></div><br>                    
                    <div>Tổng tiền thanh toán: <span>$<%=(cart.totalCart())%></span></div><br>                    
                    <input type="submit" value="Xác nhận">
                </form>
                <a href=""></a>
            </div>
        </div>
        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
