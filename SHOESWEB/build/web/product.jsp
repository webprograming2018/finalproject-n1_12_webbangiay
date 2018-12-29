<%-- 
    Document   : product
    Created on : Nov 3, 2018, 11:45:37 PM
    Author     : Thuy Tran
--%>

<%@page import="model.Carts"%>
<%@page import="model.SanPham"%>
<%@page import="DAO.DsSanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
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
                $(".megamenu").megamenu();});</script>
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
            String IdDM = "";
            if(request.getParameter("danhmuc") != null){
                IdDM = request.getParameter("danhmuc");
            }
            Carts cart = (Carts) session.getAttribute("cart");
            if (cart == null) {
                cart = new Carts();
                session.setAttribute("cart", cart);
            }
        %>
        
         <jsp:include page = "header.jsp"></jsp:include>
        
        <div class="login">
            <div class="wrap">

                <div class="cont span_2_of_3">                                        
                    <div class="box1">
                        <%
                        for (SanPham sp : spDAO.getListProductByCategory(Integer.parseInt(IdDM))) {
                        %>
                        <div class="col_1_of_single1 span_1_of_single1"><a href="details.jsp?productID=<%=sp.getIdSP()%>">
                                <div class="view1 view-fifth1">
                                    <div class="top_box">
                                        <h3 class="m_1"><%=sp.getTenSP() %></h3>
                                        <p class="m_2">Lorem ipsum</p>
                                        <div class="grid_img">
                                            <div class="css3"><img src="<%=sp.getSPimage() %>" alt="<%=sp.getTenSP() %>"/></div>
                                            <div class="mask1">
                                                <div class="info">Quick View</div>
                                            </div>
                                        </div>
                                        <div class="price"><%=sp.getDonGia() %></div>
                                    </div>
                                </div>
                                <span class="rating1">
                                    <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                    <label for="rating-input-1-5" class="rating-star1"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                    <label for="rating-input-1-4" class="rating-star1"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                    <label for="rating-input-1-3" class="rating-star1"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                    <label for="rating-input-1-2" class="rating-star"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                    <label for="rating-input-1-1" class="rating-star"></label>&nbsp;
                                    (45)
                                </span>
                                <ul class="list2">
                                    <li>
                                        <img src="images/plus.png" alt=""/>
                                        <ul class="icon1 sub-icon1 profile_img">
                                            <li><a class="active-icon c1" href="details.jsp?productID=<%=sp.getIdSP()%>">Add To Bag </a>
                                                <ul class="sub-icon1 list">
                                                    <li><h3>sed diam nonummy</h3><a href=""></a></li>
                                                    <li><p>Lorem ipsum dolor sit amet, consectetuer  <a href="">adipiscing elit, sed diam</a></p></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                                <div class="clear"></div>
                            </a></div>
                        <% } 
                        %>
                        <div class="clear"></div>
                    </div>
                    
                </div>
                <div class="clear"></div>
            </div>
        </div>
         
         <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
