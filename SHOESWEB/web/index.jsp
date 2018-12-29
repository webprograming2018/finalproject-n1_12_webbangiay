<%-- 
    Document   : index
    Created on : Nov 3, 2018, 9:22:49 AM
    Author     : Thuy Tran
--%>

<%@page import="model.SanPham"%>
<%@page import="DAO.DsSanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
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
            DsSanPhamDAO spDAO = new DsSanPhamDAO();

        %>
        <jsp:include page = "header.jsp"></jsp:include>

            <div class="index-banner">
                <div class="wmuSlider example1" style="height: 560px;">
                    <div class="wmuSliderWrapper">
                        <article style="position: relative; width: 100%; opacity: 1;"> 
                            <div class="banner-wrap">
                                <div class="slider-left">
                                    <img src="images/banner1.jpg" alt=""/> 
                                </div>
                                <div class="slider-right">
                                    <h1>Classic</h1>
                                    <h2>White</h2>                                    
                                    <div class="btn"><a href="details.jsp?productID=1">Shop Now</a></div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;"> 
                            <div class="banner-wrap">
                                <div class="slider-left">
                                    <img src="images/banner2.jpg" alt=""/> 
                                </div>
                                <div class="slider-right">
                                    <h1>Classic</h1>
                                    <h2>White</h2>                                    
                                    <div class="btn"><a href="details.jsp?productID=2">Shop Now</a></div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="slider-left">
                                    <img src="images/banner1.jpg" alt=""/> 
                                </div>
                                <div class="slider-right">
                                    <h1>Classic</h1>
                                    <h2>White</h2>                                    
                                    <div class="btn"><a href="details.jsp?productID=3">Shop Now</a></div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="slider-left">
                                    <img src="images/banner2.jpg" alt=""/> 
                                </div>
                                <div class="slider-right">
                                    <h1>Classic</h1>
                                    <h2>White</h2>                                   
                                    <div class="btn"><a href="details.jsp?productID=4">Shop Now</a></div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;"> 
                            <div class="banner-wrap">
                                <div class="slider-left">
                                    <img src="images/banner1.jpg" alt=""/> 
                                </div>
                                <div class="slider-right">
                                    <h1>Classic</h1>
                                    <h2>White</h2>                                    
                                    <div class="btn"><a href="details.jsp?productID=5">Shop Now</a></div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </article>
                    </div>
                    <a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
                    <ul class="wmuSliderPagination">
                        <li><a href="#" class="">0</a></li>
                        <li><a href="#" class="">1</a></li>
                        <li><a href="#" class="wmuActive">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                    </ul>
                    <a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a><ul class="wmuSliderPagination"><li><a href="#" class="wmuActive">0</a></li><li><a href="#" class="">1</a></li><li><a href="#" class="">2</a></li><li><a href="#" class="">3</a></li><li><a href="#" class="">4</a></li></ul></div>
                <script src="js/jquery.wmuSlider.js"></script> 
                <script type="text/javascript" src="js/modernizr.custom.min.js"></script> 
                <script>
            $('.example1').wmuSlider();
                </script> 	           	      
            </div>
            <div class="main">
                <div class="wrap">

                    <div class="content-bottom">
                        <div><h2 style="font-weight: bold;">Hot Shoes</h2></div>
                        
                        <div class="box1">
                           <%                                for (SanPham sp : spDAO.getListProduct()) {
                        %>
                        <div>                         
                            <a href="details.jsp?productID=<%=sp.getIdSP()%>">
                                <div class="view view-fifth">
                                    <div class="top_box">
                                        <h3 class="m_1"><%=sp.getTenSP()%></h3>                                        
                                        <div class="grid_img">
                                            <div class="css3"><img src="<%=sp.getSPimage()%>" alt=""/></div>
                                            <div class="mask">
                                                <div class="info">Quick View</div>
                                            </div>
                                        </div>
                                        <div class="price"><%=sp.getDonGia()%></div>
                                    </div>
                                </div>
                                <span class="rating">
                                    <input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1">
                                    <label for="rating-input-1-5" class="rating-star1"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1">
                                    <label for="rating-input-1-4" class="rating-star1"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1">
                                    <label for="rating-input-1-3" class="rating-star1"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1">
                                    <label for="rating-input-1-2" class="rating-star"></label>
                                    <input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1">
                                    <label for="rating-input-1-1" class="rating-input"></label>&nbsp;
                                    (45)
                                </span>
                                <ul class="list">
                                    <li>
                                        <img src="images/plus.png" alt=""/>
                                        <ul class="icon1 sub-icon1 profile_img">
                                            <li><a class="active-icon c1" href="details.jsp?productID=<%=sp.getIdSP()%>">Add To Cart </a>                                                
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                                
                                <div class="clear"></div>
                                
                            </a></div> 	   
                                <div class="clear"></div>
                                <%}%>
                    </div> 
                                                
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
