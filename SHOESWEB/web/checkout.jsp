<%-- 
    Document   : checkout
    Created on : Nov 8, 2018, 11:03:40 PM
    Author     : Thuy Tran
--%>

<%@page import="model.TaiKhoan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
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
        <script>
            function validateform() {
                var address = document.checkoutForm.address.value;
                var payment = document.checkoutForm.payment.value;

                if (address == null || address == "") {
                    alert("Địa chỉ không được để trống.");
                    return false;
                } else if (payment == null || payment == "") {
                    alert("Phươnng thức thanh toán không được để trống.");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%
            TaiKhoan users = (TaiKhoan) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("/SHOESWEB/login.jsp");
            }
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");            
        %>
        <jsp:include page = "header.jsp"></jsp:include>

            <div class="register_account">
                <div class="wrap">
                    <h4 class="title">checkout</h4>
                    <form action="preview.jsp" method="POST" name="checkoutForm" onsubmit="return validateform()">

                        <div>
                            <span>Address *</span>
                            <input type="text" name="address" required>>
                        </div> 	
                        <div>
                            <span>Payment *</span>
                            <select name="payment">
                                <option value="COD"> COD</option>
                            </select>
                        </div>                        
                        <input type="submit" value="Checkout"> 

                    </form>
                </div>
            </div>

        <jsp:include page = "footer.jsp"></jsp:include>

    </body>
</html>
