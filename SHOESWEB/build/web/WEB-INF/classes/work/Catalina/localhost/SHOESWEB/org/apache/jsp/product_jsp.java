/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.11
 * Generated at: 2018-12-27 19:43:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Carts;
import model.SanPham;
import DAO.DsSanPhamDAO;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("DAO.DsSanPhamDAO");
    _jspx_imports_classes.add("model.SanPham");
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
      out.write("        <title>Product</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\".dropdown img.flag\").addClass(\"flagvisibility\");\n");
      out.write("\n");
      out.write("                $(\".dropdown dt a\").click(function () {\n");
      out.write("                    $(\".dropdown dd ul\").toggle();\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\".dropdown dd ul li a\").click(function () {\n");
      out.write("                    var text = $(this).html();\n");
      out.write("                    $(\".dropdown dt a span\").html(text);\n");
      out.write("                    $(\".dropdown dd ul\").hide();\n");
      out.write("                    $(\"#result\").html(\"Selected value is: \" + getSelectedValue(\"sample\"));\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                function getSelectedValue(id) {\n");
      out.write("                    return $(\"#\" + id).find(\"dt a span.value\").html();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                $(document).bind('click', function (e) {\n");
      out.write("                    var $clicked = $(e.target);\n");
      out.write("                    if (!$clicked.parents().hasClass(\"dropdown\"))\n");
      out.write("                        $(\".dropdown dd ul\").hide();\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("                $(\"#flagSwitcher\").click(function () {\n");
      out.write("                    $(\".dropdown img.flag\").toggleClass(\"flagvisibility\");\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <!-- start menu -->    \n");
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
      out.write("                    new WOW().init();\n");
      out.write("        </script>\n");
      out.write("        <!-- //animation-effect -->\n");
      out.write("        <link href=\"css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"js/megamenu.js\"></script>\n");
      out.write("        <script>$(document).ready(function () {\n");
      out.write("                $(\".megamenu\").megamenu();});</script>\n");
      out.write("        <!-- end menu -->\n");
      out.write("        <!-- top scrolling -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/move-top.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/easing.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            jQuery(document).ready(function ($) {\n");
      out.write("                $(\".scroll\").click(function (event) {\n");
      out.write("                    event.preventDefault();\n");
      out.write("                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"login\">\n");
      out.write("            <div class=\"wrap\">\n");
      out.write("\n");
      out.write("                <div class=\"cont span_2_of_3\">\n");
      out.write("                    <div class=\"mens-toolbar\">\n");
      out.write("                        <div class=\"sort\">\n");
      out.write("                            <div class=\"sort-by\">\n");
      out.write("                                <label>Sort By</label>\n");
      out.write("                                <select>\n");
      out.write("                                    <option value=\"\">\n");
      out.write("                                        Popularity               </option>\n");
      out.write("                                    <option value=\"\">\n");
      out.write("                                        Price : High to Low               </option>\n");
      out.write("                                    <option value=\"\">\n");
      out.write("                                        Price : Low to High               </option>\n");
      out.write("                                </select>\n");
      out.write("                                <a href=\"\"><img src=\"images/arrow2.gif\" alt=\"\" class=\"v-middle\"></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pager\">   \n");
      out.write("                            <div class=\"limiter visible-desktop\">\n");
      out.write("                                <label>Show</label>\n");
      out.write("                                <select>\n");
      out.write("                                    <option value=\"\" selected=\"selected\">\n");
      out.write("                                        9                </option>\n");
      out.write("                                    <option value=\"\">\n");
      out.write("                                        15                </option>\n");
      out.write("                                    <option value=\"\">\n");
      out.write("                                        30                </option>\n");
      out.write("                                </select> per page        \n");
      out.write("                            </div>\n");
      out.write("                            <ul class=\"dc_pagination dc_paginationA dc_paginationA06\">\n");
      out.write("                                <li><a href=\"#\" class=\"previous\">Pages</a></li>\n");
      out.write("                                <li><a href=\"#\">1</a></li>\n");
      out.write("                                <li><a href=\"#\">2</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                            <div class=\"clear\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clear\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"box1\">\n");
      out.write("                        ");

                        for (SanPham sp : spDAO.getListProductByCategory(Integer.parseInt(IdDM))) {
                        
      out.write("\n");
      out.write("                        <div class=\"col_1_of_single1 span_1_of_single1\"><a href=\"details.jsp?productID=");
      out.print(sp.getIdSP());
      out.write("\">\n");
      out.write("                                <div class=\"view1 view-fifth1\">\n");
      out.write("                                    <div class=\"top_box\">\n");
      out.write("                                        <h3 class=\"m_1\">");
      out.print(sp.getTenSP() );
      out.write("</h3>\n");
      out.write("                                        <p class=\"m_2\">Lorem ipsum</p>\n");
      out.write("                                        <div class=\"grid_img\">\n");
      out.write("                                            <div class=\"css3\"><img src=\"");
      out.print(sp.getSPimage() );
      out.write("\" alt=\"");
      out.print(sp.getTenSP() );
      out.write("\"/></div>\n");
      out.write("                                            <div class=\"mask1\">\n");
      out.write("                                                <div class=\"info\">Quick View</div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"price\">");
      out.print(sp.getDonGia() );
      out.write("</div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <span class=\"rating1\">\n");
      out.write("                                    <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-5\" name=\"rating-input-1\">\n");
      out.write("                                    <label for=\"rating-input-1-5\" class=\"rating-star1\"></label>\n");
      out.write("                                    <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-4\" name=\"rating-input-1\">\n");
      out.write("                                    <label for=\"rating-input-1-4\" class=\"rating-star1\"></label>\n");
      out.write("                                    <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-3\" name=\"rating-input-1\">\n");
      out.write("                                    <label for=\"rating-input-1-3\" class=\"rating-star1\"></label>\n");
      out.write("                                    <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-2\" name=\"rating-input-1\">\n");
      out.write("                                    <label for=\"rating-input-1-2\" class=\"rating-star\"></label>\n");
      out.write("                                    <input type=\"radio\" class=\"rating-input\" id=\"rating-input-1-1\" name=\"rating-input-1\">\n");
      out.write("                                    <label for=\"rating-input-1-1\" class=\"rating-star\"></label>&nbsp;\n");
      out.write("                                    (45)\n");
      out.write("                                </span>\n");
      out.write("                                <ul class=\"list2\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <img src=\"images/plus.png\" alt=\"\"/>\n");
      out.write("                                        <ul class=\"icon1 sub-icon1 profile_img\">\n");
      out.write("                                            <li><a class=\"active-icon c1\" href=\"details.jsp?productID=");
      out.print(sp.getIdSP());
      out.write("\">Add To Bag </a>\n");
      out.write("                                                <ul class=\"sub-icon1 list\">\n");
      out.write("                                                    <li><h3>sed diam nonummy</h3><a href=\"\"></a></li>\n");
      out.write("                                                    <li><p>Lorem ipsum dolor sit amet, consectetuer  <a href=\"\">adipiscing elit, sed diam</a></p></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                                <div class=\"clear\"></div>\n");
      out.write("                            </a></div>\n");
      out.write("                        ");
 } 
                        
      out.write("\n");
      out.write("                        <div class=\"clear\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("         \n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
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