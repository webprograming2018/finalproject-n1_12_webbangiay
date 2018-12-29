<%-- 
    Document   : header
    Created on : Nov 3, 2018, 9:23:04 AM
    Author     : Thuy Tran
--%>

<%@page import="model.Carts"%>
<%@page import="model.Items"%>
<%@page import="java.util.Map"%>
<%@page import="model.TaiKhoan"%>
<%@page import="model.danhmuc"%>
<%@page import="DAO.DanhMucDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
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
    <div id="fb-root"></div>
    <script>(function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id))
                return;
            js = d.createElement(s);
            js.id = id;
            js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.2&appId=281377142524546&autoLogAppEvents=1';
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>
</head>
<body>

    <% DanhMucDAO dmdao = new DanhMucDAO();
        TaiKhoan users = null;
        if (session.getAttribute("user") != null) {
            users = (TaiKhoan) session.getAttribute("user");
        }
        Carts cart = (Carts) session.getAttribute("cart");
        if (cart == null) {
            cart = new Carts();
            session.setAttribute("cart", cart);
        }
    %>

    <div class="header-top">
        <div class="wrap"> 
            <div class="logo">
                <a href="index.jsp"><img src="images/logo.png" alt=""/></a>
            </div>
            <div class="cssmenu">
                <ul>
                    <%if (users != null) {%>
                    <li><a href="account.jsp"><%=users.getUsername()%></a> </li>
                    <li><a href="shop.jsp">Giỏ Hàng</a></li>
                    <li><div class="cart">
                            <a href="#" class="cart-in"> </a>
                            <span> <%=cart.countItem()%></span>
                        </div>
                        
                    </li>
                    <li><a href="LogoutServlet">Logout</a> </li>
                        <%} else {%>
                    <li class="active"><a href="register.jsp">Sign up</a></li> 
                    <!--<li><a href="shop.html">Giỏ Hàng</a></li> -->
                    <li><a href="login.jsp">Log in</a></li> 

                    <%}%>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="wrap">
            <!-- start header menu -->
            <ul class="megamenu skyblue">
                <li><a class="color1" href="#">Home</a></li>
                    <%
                        for (danhmuc dm : dmdao.getListCategory()) {
                    %>
                <li class="grid"><a class="color2" href="product.jsp?danhmuc=<%=dm.getIdDM()%>"><%=dm.getTenDM()%></a>   
                </li>
                <% }%>
            </ul>
            <div class="clear"></div>
        </div>
    </div>
</body>
</html>
