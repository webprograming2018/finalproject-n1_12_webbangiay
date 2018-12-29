<%-- 
    Document   : shop
    Created on : Nov 5, 2018, 10:23:15 PM
    Author     : Thuy Tran
--%>

<%@page import="DAO.SizeDAO"%>
<%@page import="model.Size"%>
<%@page import="java.lang.System"%>
<%@page import="DAO.DsSanPhamDAO"%>
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
        <title>My Cart</title>
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
            DsSanPhamDAO spDAO = new DsSanPhamDAO();            
            
            Carts cart = (Carts) session.getAttribute("cart");
            if (cart == null) {
                cart = new Carts();
                session.setAttribute("cart", cart);
            }
            
            SizeDAO sdao = new SizeDAO();            
        %>
        <jsp:include page = "header.jsp"></jsp:include>
            <div class="check-out">	 
                <div class="container">	 

                    <table class="table animated wow fadeInLeft" data-wow-delay=".5s">
                        <tr>
                            <th class="t-head">Hình ảnh</th>
                            <th class="t-head ">Mặt Hàng</th>
                            <th class="t-head">Giá</th>
                            <th class="t-head">Số Lượng</th>
                            <th class="t-head">Size</th>
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
                        <td class="t-data"><div class="quantity">                                
                               <div class="product-quantity cart_quantity_button">
						<a class="" href="CartServlet?command=sub&productID=<%=list.getValue().getProduct().getIdSP()%>&size=<%=list.getValue().getSize()%>"><img src="images/minus.png" class="img-responsive " alt=""></a>
						<input class="cart_quantity_input" type="number" value="<%=list.getValue().getQuantity()%>" disabled="disabled">
						<a class="cart_quantity_up" href="CartServlet?command=plus&productID=<%=list.getValue().getProduct().getIdSP()%>&size=<%=list.getValue().getSize()%>"><img src="images/plus_1.png" class="img-responsive " alt=""></a>
					</div>
					
                            </div>
                        </td>
                        <td class="t-data"><%=list.getValue().getSize()%></td>
                        <td class="t-data"><a href="CartServlet?command=remove&productID=<%=list.getValue().getProduct().getIdSP()%>&size=<%=list.getValue().getSize()%>"><img src="images/circle.png" class="img-responsive " alt=""></a></td>

                    </tr>
                    <% }%>

                </table>
                <div class=" cart-total">

                    <h5 class="continue" >Tổng Cộng Giỏ Hàng</h5>
                    <div class="price-details">
                        <h3>Chi Tiết Giá</h3>
                        <span>Tổng Cộng</span>
                        <span class="total1"></span>
                        <span>Giảm giá</span>
                        <span class="total1">---</span>
                        <span>Phí vận chuyển</span>
                        <span class="total1"></span>
                        <div class="clearfix"></div>				 
                    </div>	
                    <ul class="total_price">
                        <li class="last_price"> <h4>Tổng Cộng</h4></li>	
                        <li class="last_price"><span>$<%=(cart.totalCart())%></span></li>
                        <div class="clearfix"> </div>
                    </ul>

                    <a href="checkout.jsp">Thanh Toán</a>

                </div>


            </div>
        </div>
    
        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
