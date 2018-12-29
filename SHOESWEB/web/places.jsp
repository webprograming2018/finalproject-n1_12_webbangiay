<%-- 
    Document   : places
    Created on : Dec 24, 2018, 4:46:15 PM
    Author     : Thuy Tran
--%>

<%@page import="model.BillLocationShip"%>
<%@page import="DAO.BillLocationShipDAO"%>
<%@page import="model.TaiKhoan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Theo dõi đơn hàng</title>
        <!-- Add Google API Key -->
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDqfFlpHofSXqsM7KupEX-F1cIy5gewYwg&callback=initialize" async defer>
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js">
        </script>
        <script>
            //Khoi tao Map
            function initialize() {
                var x = document.getElementById("lat").innerHTML;
                var y = document.getElementById("lng").innerHTML;
                var x2 = document.getElementById("lastlat").innerHTML;
                var y2 = document.getElementById("lastlng").innerHTML;
                var time = document.getElementById("time").innerHTML;
                var location = [
                    [x, y,2],
                    [x2, y2,1]
                ];
                //Khai bao cac thuoc tinh
                var mapProp = {
                    //Tam ban do, quy dinh boi kinh do va vi do
                    center: new google.maps.LatLng(x, y), //Học viện CN Bưu chính Viễn Thông.20.980562,105.786991
                    //set default zoom cua ban do khi duoc load
                    zoom: 12,
                    //Dinh nghia type
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                var marker = [];
                var i = 0;
                //Truyen tham so cho cac thuoc tinh Map cho the div chua Map
                var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
                for (i = 0; i < location.length; i++) {
                    new google.maps.Marker({
                        position: new google.maps.LatLng(location[i][0], location[i][1]),
                        icon: 'images/mark1.png',
                        map: map,
                        title: time                      
                    });
                    //marker[i].setMap(map);
                    
                }
            }

            //google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <%
            TaiKhoan users = (TaiKhoan) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("/SHOESWEB/login.jsp");
            }
            long idBill = Long.parseLong(request.getParameter("billId"));
            BillLocationShipDAO blsdao = new BillLocationShipDAO();
            BillLocationShip bls = new BillLocationShip();
            bls = blsdao.getByIdBill(idBill);

        %>


        <h1 id="lat" hidden><%=bls.getLat()%></h1>
        <h1 id="lng" hidden><%=bls.getLng()%></h1>
        <h1 id="lastlat" hidden><%=bls.getLastLat()%></h1>
        <h1 id="lastlng" hidden><%=bls.getLastLng()%></h1>
        <h1 id="time" hidden><%=bls.getUpdateTime()%></h1>

        <div id="googleMap" style="width:100%;height:800px;"></div>
    </body>
</html>
