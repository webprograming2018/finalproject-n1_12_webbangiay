<%-- 
    Document   : register
    Created on : Nov 3, 2018, 10:06:15 AM
    Author     : Thuy Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
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
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#username").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="img/ajax-loader.gif"/>');
                    $.post('CheckUsernameServlet1', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
            });
        </script>
        <script type="text/javascript">
            function matchpass() {
                var firstpassword = document.form1.password.value;
                var name = document.form1.name.value;
                var username = document.form1.username.value;

                if (name == null || name == "") {
                    alert("Tên không được để trống.");
                    return false;
                } else if (firstpassword == null || firstpassword == "") {
                    alert("Password không được để trống.");
                    return false;
                } else if (username == null || username == "") {
                    alert("Username không được để trống.");
                    return false;
                }
            }


        </script>

    </head>
    <body>

        <jsp:include page = "header.jsp"></jsp:include>

            <!-- content -->
            <div class="register_account">
                <div class="wrap">
                    <h4 class="title">Create an Account</h4>

                    <form action="UsersServlet" method="POST" name="form1" onsubmit="return matchpass()">
                        <div>
                            <script>

                                var check = function () {
                                    if (document.getElementById('password').value ==
                                            document.getElementById('confirmpassword').value) {
                                        document.getElementById('message').style.color = 'green';
                                        document.getElementById('message').innerHTML = 'matching';
                                    } else {
                                        document.getElementById('message').style.color = 'red';
                                        document.getElementById('message').innerHTML = 'not matching';
                                    }
                                }
                            </script>
                            <div>Username<input type="text" name="username" id = "username">
                                <span id="user-result"></span>
                            </div>
                            <div>Your full name<input type="text" name="name" id = "name"> 
                            </div>
                            Password<div><input type="password" name="password" id="password" onkeyup='check();'>
                                <span></span>
                            </div>
                            Comfirm Password
                            <div><input type="password" name="confirmpassword" id="confirmpassword" onkeyup='check();'>
                                <span id='message'></span>
                            </div>
                        </div><br>
                        <div>
                            <input type="hidden" value="insert" name="command">
                            <button class="grey">Submit</button>
                            <p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.</p>
                        </div><div class="clear"></div>
                    </form>
                </div> 
            </div>

        <jsp:include page = "footer.jsp"></jsp:include>
    </body>
</html>
