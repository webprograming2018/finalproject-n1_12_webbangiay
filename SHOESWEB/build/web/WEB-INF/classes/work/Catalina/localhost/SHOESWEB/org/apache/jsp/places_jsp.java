/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.11
 * Generated at: 2018-12-28 18:51:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.BillLocationShip;
import DAO.BillLocationShipDAO;
import model.TaiKhoan;

public final class places_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("DAO.BillLocationShipDAO");
    _jspx_imports_classes.add("model.BillLocationShip");
    _jspx_imports_classes.add("model.TaiKhoan");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Theo dõi đơn hàng</title>\n");
      out.write("        <!-- Add Google API Key -->\n");
      out.write("        <script src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyDqfFlpHofSXqsM7KupEX-F1cIy5gewYwg&callback=initialize\" async defer>\n");
      out.write("        </script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js\">\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            //Khoi tao Map\n");
      out.write("            function initialize() {\n");
      out.write("                var x = document.getElementById(\"lat\").innerHTML;\n");
      out.write("                var y = document.getElementById(\"lng\").innerHTML;\n");
      out.write("                var x2 = document.getElementById(\"lastlat\").innerHTML;\n");
      out.write("                var y2 = document.getElementById(\"lastlng\").innerHTML;\n");
      out.write("                var time = document.getElementById(\"time\").innerHTML;\n");
      out.write("                var location = [\n");
      out.write("                    [x, y,2],\n");
      out.write("                    [x2, y2,1]\n");
      out.write("                ];\n");
      out.write("                //Khai bao cac thuoc tinh\n");
      out.write("                var mapProp = {\n");
      out.write("                    //Tam ban do, quy dinh boi kinh do va vi do\n");
      out.write("                    center: new google.maps.LatLng(x, y), //Học viện CN Bưu chính Viễn Thông.20.980562,105.786991\n");
      out.write("                    //set default zoom cua ban do khi duoc load\n");
      out.write("                    zoom: 12,\n");
      out.write("                    //Dinh nghia type\n");
      out.write("                    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("                };\n");
      out.write("                var marker = [];\n");
      out.write("                var i = 0;\n");
      out.write("                //Truyen tham so cho cac thuoc tinh Map cho the div chua Map\n");
      out.write("                var map = new google.maps.Map(document.getElementById(\"googleMap\"), mapProp);\n");
      out.write("                for (i = 0; i < location.length; i++) {\n");
      out.write("                    new google.maps.Marker({\n");
      out.write("                        position: new google.maps.LatLng(location[i][0], location[i][1]),\n");
      out.write("                        icon: 'images/mark1.png',\n");
      out.write("                        map: map,\n");
      out.write("                        title: time                      \n");
      out.write("                    });\n");
      out.write("                    //marker[i].setMap(map);\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            //google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            TaiKhoan users = (TaiKhoan) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("/SHOESWEB/login.jsp");
            }
            long idBill = Long.parseLong(request.getParameter("billId"));
            BillLocationShipDAO blsdao = new BillLocationShipDAO();
            BillLocationShip bls = new BillLocationShip();
            bls = blsdao.getByIdBill(idBill);

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h1 id=\"lat\" hidden>");
      out.print(bls.getLat());
      out.write("</h1>\n");
      out.write("        <h1 id=\"lng\" hidden>");
      out.print(bls.getLng());
      out.write("</h1>\n");
      out.write("        <h1 id=\"lastlat\" hidden>");
      out.print(bls.getLastLat());
      out.write("</h1>\n");
      out.write("        <h1 id=\"lastlng\" hidden>");
      out.print(bls.getLastLng());
      out.write("</h1>\n");
      out.write("        <h1 id=\"time\" hidden>");
      out.print(bls.getUpdateTime());
      out.write("</h1>\n");
      out.write("\n");
      out.write("        <div id=\"googleMap\" style=\"width:100%;height:800px;\"></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
