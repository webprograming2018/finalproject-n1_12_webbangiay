<%-- 
    Document   : login
    Created on : Nov 3, 2018, 10:02:56 AM
    Author     : Thuy Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
        <!--validate form-->
        <script>
            function validateform() {
                var name = document.loginForm.username.value;
                var password = document.loginForm.password.value;

                if (name == null || name == "") {
                    alert("Tên không được để trống.");
                    return false;
                } else if (password == null || password == "") {
                    alert("Password không được để trống.");
                    return false;
                }
            }
        </script>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <!-- content -->
            <div class="login">
                <div class="wrap">
                    <div class="col_1_of_login span_1_of_login">
                        <h4 class="title">New Customers</h4>
                        <h5 class="sub_title">Register Account</h5>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan</p>
                        <div class="button1">
                            <a href="register.jsp"><input type="submit" name="Submit" value="Continue"></a>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="col_1_of_login span_1_of_login">
                        <div class="login-title">
                            <h4 class="title">Registered Customers</h4>
                            <div class="comments-area">
                                <form action="UsersServlet" method="POST" name="loginForm" onsubmit="return validateform()">
                                <%if (request.getAttribute("error") != null) {%>
                                <div>
                                    <p style="color:red"><%=request.getAttribute("error")%></p>
                                </div> 
                                <%}%>
                                <p>
                                    <label>Username</label>
                                    <span>*</span>
                                    <input type="text" name="username">
                                </p>
                                <p>
                                    <label>Password</label>
                                    <span>*</span>
                                    <input type="password" name="password">
                                </p>
                                <p id="login-form-remember">
                                    <label><a href="#">Forget Your Password ? </a></label>
                                </p>
                                <p>
                                    <input type="hidden" value="login" name="command">
                                    <input type="submit" value="Login">
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
