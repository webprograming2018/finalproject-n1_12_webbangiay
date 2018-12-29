<%-- 
    Document   : details
    Created on : Nov 4, 2018, 1:21:46 AM
    Author     : Thuy Tran
--%>

<%@page import="DAO.SizeDAO"%>
<%@page import="model.Size"%>
<%@page import="model.SanPham"%>
<%@page import="DAO.DsSanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details</title>
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
            SanPham sanPham = new SanPham();
            String IdSP = "";
            if (request.getParameter("productID") != null) {
                IdSP = request.getParameter("productID");
                sanPham = spDAO.getProduct(Integer.parseInt(IdSP));
            }
            SizeDAO sizeDAO = new SizeDAO();
            
        %>

        <jsp:include page = "header.jsp"></jsp:include>

            <div class="single">
                <div class="wrap">

                    <div class="cont span_2_of_3">
                        <div class="labout span_1_of_a1">
                            <!-- start product_slider -->
                            <ul id="etalage">
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image" src="<%= sanPham.getSPimage()%>" />
                                </a>
                        </ul>


                        <!-- end product_slider -->
                    </div>
                    <div class="cont1 span_2_of_a1">
                        <h3 class="m_3"><%= sanPham.getTenSP()%></h3>

                        <div class="price_single">
                            <span class="actual"><%= sanPham.getDonGia()%></span><a href="#">click for offer</a>
                        </div>
                        <form action="CartServlet?command=plus&productID=<%=sanPham.getIdSP()%>" method="POST">                           
                            <h4 class="m_9">Select a Size</h4>
                            <select name="size">
                                <%
                                    for(Size size : sizeDAO.getListSizes()) {
                                %>
                                <option value="<%=size.getId()%>"><%=size.getId()%></option>  
                                <%}%>
                            </select>
                            <div class="btn_form">
                                <input type="submit" value="buy now" title=""></div>
                        </form>

                        <ul class="add-to-links">
                            <li><img src="images/wish.png" alt=""/><a href="#">Add to wishlist</a></li>
                        </ul>
                        <p class="m_desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>

                        <div class="social_single">	
                            <ul>	
                                <li class="fb"><a href="#"><span> </span></a></li>
                                <li class="tw"><a href="#"><span> </span></a></li>
                                <li class="g_plus"><a href="#"><span> </span></a></li>
                                <li class="rss"><a href="#"><span> </span></a></li>		
                            </ul>
                        </div>
                    </div>
                    <div class="clear"></div>


                    <ul id="flexiselDemo3">
                        <li><img src="images/pic11.jpg" /><div class="grid-flex"><a href="#">Bloch</a><p>Rs 850</p></div></li>
                        <li><img src="images/pic10.jpg" /><div class="grid-flex"><a href="#">Capzio</a><p>Rs 850</p></div></li>
                        <li><img src="images/pic9.jpg" /><div class="grid-flex"><a href="#">Zumba</a><p>Rs 850</p></div></li>
                        <li><img src="images/pic8.jpg" /><div class="grid-flex"><a href="#">Bloch</a><p>Rs 850</p></div></li>
                        <li><img src="images/pic7.jpg" /><div class="grid-flex"><a href="#">Capzio</a><p>Rs 850</p></div></li>
                    </ul>
                    <script type="text/javascript">
                        $(window).load(function () {
                            $("#flexiselDemo1").flexisel();
                            $("#flexiselDemo2").flexisel({
                                enableResponsiveBreakpoints: true,
                                responsiveBreakpoints: {
                                    portrait: {
                                        changePoint: 480,
                                        visibleItems: 1
                                    },
                                    landscape: {
                                        changePoint: 640,
                                        visibleItems: 2
                                    },
                                    tablet: {
                                        changePoint: 768,
                                        visibleItems: 3
                                    }
                                }
                            });

                            $("#flexiselDemo3").flexisel({
                                visibleItems: 5,
                                animationSpeed: 1000,
                                autoPlay: true,
                                autoPlaySpeed: 3000,
                                pauseOnHover: true,
                                enableResponsiveBreakpoints: true,
                                responsiveBreakpoints: {
                                    portrait: {
                                        changePoint: 480,
                                        visibleItems: 1
                                    },
                                    landscape: {
                                        changePoint: 640,
                                        visibleItems: 2
                                    },
                                    tablet: {
                                        changePoint: 768,
                                        visibleItems: 3
                                    }
                                }
                            });

                        });
                    </script>
                    <script type="text/javascript" src="js/jquery.flexisel.js"></script>
                    <div class="toogle">
                        <h3 class="m_3">Product Details</h3>
                        <p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
                    </div>					
                    <div class="toogle">
                        <h3 class="m_3">Product Reviews</h3>
                        <p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
                    </div>
                </div>
                <div><div class="fb-comments" data-href="http://localhost:8084/SHOESWEB/details.jsp?productID=<%=IdSP%>" data-width="950" data-numposts="5"></div></div>
                <div class="clear"></div>
            </div>
        </div>
        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
