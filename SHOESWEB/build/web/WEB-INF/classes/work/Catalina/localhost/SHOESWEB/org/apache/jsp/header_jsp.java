/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.11
 * Generated at: 2018-12-27 10:54:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Carts;
import model.Items;
import java.util.Map;
import model.TaiKhoan;
import model.danhmuc;
import DAO.DanhMucDAO;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("model.Carts");
    _jspx_imports_classes.add("model.danhmuc");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("model.TaiKhoan");
    _jspx_imports_classes.add("model.Items");
    _jspx_imports_classes.add("DAO.DanhMucDAO");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>header</title>\n");
      out.write("        <!-- start menu -->  \n");
      out.write("        <link href=\"css/bootstrap_1.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <link href=\"css/style_1.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <!-- js -->\n");
      out.write("        <script src=\"js/jquery.min_1.js\"></script>\n");
      out.write("        <!-- //js -->\n");
      out.write("        <!-- cart -->\n");
      out.write("        <script src=\"js/simpleCart.min.js\"></script>\n");
      out.write("        <!-- cart -->\n");
      out.write("        <!-- for bootstrap working -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap-3.1.1.min.js\"></script>\n");
      out.write("        <!-- //for bootstrap working -->\n");
      out.write("        <!-- animation-effect -->\n");
      out.write("        <link href=\"css/animate.min.css\" rel=\"stylesheet\"> \n");
      out.write("        <script src=\"js/wow.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            new WOW().init();\n");
      out.write("        </script>\n");
      out.write("        <!-- //animation-effect -->\n");
      out.write("    <div id=\"fb-root\"></div>\n");
      out.write("    <script>(function (d, s, id) {\n");
      out.write("            var js, fjs = d.getElementsByTagName(s)[0];\n");
      out.write("            if (d.getElementById(id))\n");
      out.write("                return;\n");
      out.write("            js = d.createElement(s);\n");
      out.write("            js.id = id;\n");
      out.write("            js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.2&appId=281377142524546&autoLogAppEvents=1';\n");
      out.write("            fjs.parentNode.insertBefore(js, fjs);\n");
      out.write("        }(document, 'script', 'facebook-jssdk'));</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    ");
 DanhMucDAO dmdao = new DanhMucDAO();
        TaiKhoan users = null;
        if (session.getAttribute("user") != null) {
            users = (TaiKhoan) session.getAttribute("user");
        }
        Carts cart = (Carts) session.getAttribute("cart");
        if (cart == null) {
            cart = new Carts();
            session.setAttribute("cart", cart);
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"header-top\">\n");
      out.write("        <div class=\"wrap\"> \n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <a href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"\"/></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"cssmenu\">\n");
      out.write("                <ul>\n");
      out.write("                    ");
if (users != null) {
      out.write("\n");
      out.write("                    <li><a href=\"account.jsp\">");
      out.print(users.getUsername());
      out.write("</a> </li>\n");
      out.write("                    <li><a href=\"shop.jsp\">Giỏ Hàng</a></li>\n");
      out.write("                    <li><div class=\"cart\">\n");
      out.write("                            <a href=\"#\" class=\"cart-in\"> </a>\n");
      out.write("                            <span> ");
      out.print(cart.countItem());
      out.write("</span>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"LogoutServlet\">Logout</a> </li>\n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("                    <li class=\"active\"><a href=\"register.jsp\">Sign up</a></li> \n");
      out.write("                    <!--<li><a href=\"shop.html\">Giỏ Hàng</a></li> -->\n");
      out.write("                    <li><a href=\"login.jsp\">Log in</a></li> \n");
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"clear\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"header-bottom\">\n");
      out.write("        <div class=\"wrap\">\n");
      out.write("            <!-- start header menu -->\n");
      out.write("            <ul class=\"megamenu skyblue\">\n");
      out.write("                <li><a class=\"color1\" href=\"#\">Home</a></li>\n");
      out.write("                    ");

                        for (danhmuc dm : dmdao.getListCategory()) {
                    
      out.write("\n");
      out.write("                <li class=\"grid\"><a class=\"color2\" href=\"product.jsp?danhmuc=");
      out.print(dm.getIdDM());
      out.write('"');
      out.write('>');
      out.print(dm.getTenDM());
      out.write("</a>   \n");
      out.write("                </li>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"clear\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
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