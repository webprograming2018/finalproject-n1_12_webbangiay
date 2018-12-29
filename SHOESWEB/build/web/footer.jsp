<%-- 
    Document   : footer
    Created on : Nov 3, 2018, 9:23:19 AM
    Author     : Thuy Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>footer</title>
    </head>
    <body>
        <div class="footer">
            <div class="footer-top">
                <div class="wrap">
                    <div class="col_1_of_footer-top span_1_of_footer-top">
                        <ul class="f_list">
                            <li><img src="images/f_icon.png" alt=""/><span class="delivery">Free delivery on all orders over $90</span></li>
                        </ul>
                    </div>
                    <div class="col_1_of_footer-top span_1_of_footer-top">
                        <ul class="f_list">
                            <li><img src="images/f_icon1.png" alt=""/><span class="delivery">Customer Service :<span class="orange"> (+84)-0972-513-172</span></span></li>
                        </ul>
                    </div>
                    <div class="col_1_of_footer-top span_1_of_footer-top">
                        <ul class="f_list">
                            <li><img src="images/f_icon2.png" alt=""/><span class="delivery">Fast delivery & free returns</span></li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="footer-middle">
                <div class="wrap">
                    <div class="col_1_of_middle span_1_of_middle">
                        <ul class="f_list1">
                            <li><span class="m_8">Search for any shoes you want!</span>                       
                                <div class="search">	  
                                    <input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Search';
                                            }">
                                    <input type="submit" value="Subscribe" id="submit" name="submit">
                                    <div id="response"> </div>
                                </div><div class="clear"></div>
                            </li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="wrap">
                <div class="section group">
                    <div class="col_1_of_5 span_1_of_5">
                        <h3 class="m_9">Shop</h3>
                        <ul class="sub_list">
                            <h4 class="m_10">Men's Shoes</h4>

                        </ul>
                        <ul class="sub_list">
                            <h4 class="m_10">Women's Shoes</h4>

                        </ul>
                        <ul class="sub_list">
                            <h4 class="m_10">Kids Shoes</h4>

                        </ul>
                    </div>


                    <div class="col_1_of_5 span_1_of_5">
                        <h3 class="m_9">Support</h3>
                        <ul class="list1">
                            <li><a href="shop.html">Store finder</a></li>
                            <li><a href="shop.html">Customer Service</a></li>
                            <li><a href="shop.html">Online Shop Contact Us</a></li>
                            <li><a href="shop.html">About Adidas Products</a></li>
                            <li><a href="shop.html">Payment </a></li>
                            <li><a href="shop.html">Shipping </a></li>
                            <li><a href="shop.html">Returning</a></li>
                            <li><a href="shop.html">Delivery Terms</a></li>
                            <li><a href="shop.html">Site Map</a></li>

                        </ul>
                        <ul class="sub_list2">
                            <h4 class="m_10">Company Info</h4>
                            <li><a href="shop.html">About Us</a></li>
                            <li><a href="shop.html">Careers</a></li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {

            var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear'
            };


            $().UItoTop({easingType: 'easeOutQuart'});

        });
    </script>
    <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
</body>
</html>
