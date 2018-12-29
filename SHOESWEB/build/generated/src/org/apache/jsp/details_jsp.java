package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.SizeDAO;
import model.Size;
import model.SanPham;
import DAO.DsSanPhamDAO;

public final class details_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

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
      out.write("        <title>Product Details</title>\n");
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
      out.write("        <!-- start menu --> \n");
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
      out.write("        <link href=\"css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"js/megamenu.js\"></script>\n");
      out.write("        <script>$(document).ready(function () {\n");
      out.write("                $(\".megamenu\").megamenu();\n");
      out.write("            });</script>\n");
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
      out.write("\n");
      out.write("        ");

            DsSanPhamDAO spDAO = new DsSanPhamDAO();
            SanPham sanPham = new SanPham();
            String IdSP = "";
            if (request.getParameter("productID") != null) {
                IdSP = request.getParameter("productID");
                sanPham = spDAO.getProduct(Integer.parseInt(IdSP));
            }
            SizeDAO sizeDAO = new SizeDAO();
            
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"single\">\n");
      out.write("                <div class=\"wrap\">\n");
      out.write("\n");
      out.write("                    <div class=\"cont span_2_of_3\">\n");
      out.write("                        <div class=\"labout span_1_of_a1\">\n");
      out.write("                            <!-- start product_slider -->\n");
      out.write("                            <ul id=\"etalage\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"optionallink.html\">\n");
      out.write("                                        <img class=\"etalage_thumb_image\" src=\"");
      out.print( sanPham.getSPimage());
      out.write("\" />\n");
      out.write("                                </a>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- end product_slider -->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cont1 span_2_of_a1\">\n");
      out.write("                        <h3 class=\"m_3\">");
      out.print( sanPham.getTenSP());
      out.write("</h3>\n");
      out.write("\n");
      out.write("                        <div class=\"price_single\">\n");
      out.write("                            <span class=\"actual\">");
      out.print( sanPham.getDonGia());
      out.write("</span><a href=\"#\">click for offer</a>\n");
      out.write("                        </div>\n");
      out.write("                        <form action=\"CartServlet?command=plus&productID=");
      out.print(sanPham.getIdSP());
      out.write("\" method=\"POST\">                           \n");
      out.write("                            <h4 class=\"m_9\">Select a Size</h4>\n");
      out.write("                            <select name=\"size\">\n");
      out.write("                                ");

                                    for(Size size : sizeDAO.getListSizes()) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(size.getId());
      out.write('"');
      out.write('>');
      out.print(size.getName());
      out.write("</option>  \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <div class=\"btn_form\">\n");
      out.write("                                <input type=\"submit\" value=\"buy now\" title=\"\"></div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                        <ul class=\"add-to-links\">\n");
      out.write("                            <li><img src=\"images/wish.png\" alt=\"\"/><a href=\"#\">Add to wishlist</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <p class=\"m_desc\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>\n");
      out.write("\n");
      out.write("                        <div class=\"social_single\">\t\n");
      out.write("                            <ul>\t\n");
      out.write("                                <li class=\"fb\"><a href=\"#\"><span> </span></a></li>\n");
      out.write("                                <li class=\"tw\"><a href=\"#\"><span> </span></a></li>\n");
      out.write("                                <li class=\"g_plus\"><a href=\"#\"><span> </span></a></li>\n");
      out.write("                                <li class=\"rss\"><a href=\"#\"><span> </span></a></li>\t\t\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <ul id=\"flexiselDemo3\">\n");
      out.write("                        <li><img src=\"images/pic11.jpg\" /><div class=\"grid-flex\"><a href=\"#\">Bloch</a><p>Rs 850</p></div></li>\n");
      out.write("                        <li><img src=\"images/pic10.jpg\" /><div class=\"grid-flex\"><a href=\"#\">Capzio</a><p>Rs 850</p></div></li>\n");
      out.write("                        <li><img src=\"images/pic9.jpg\" /><div class=\"grid-flex\"><a href=\"#\">Zumba</a><p>Rs 850</p></div></li>\n");
      out.write("                        <li><img src=\"images/pic8.jpg\" /><div class=\"grid-flex\"><a href=\"#\">Bloch</a><p>Rs 850</p></div></li>\n");
      out.write("                        <li><img src=\"images/pic7.jpg\" /><div class=\"grid-flex\"><a href=\"#\">Capzio</a><p>Rs 850</p></div></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                        $(window).load(function () {\n");
      out.write("                            $(\"#flexiselDemo1\").flexisel();\n");
      out.write("                            $(\"#flexiselDemo2\").flexisel({\n");
      out.write("                                enableResponsiveBreakpoints: true,\n");
      out.write("                                responsiveBreakpoints: {\n");
      out.write("                                    portrait: {\n");
      out.write("                                        changePoint: 480,\n");
      out.write("                                        visibleItems: 1\n");
      out.write("                                    },\n");
      out.write("                                    landscape: {\n");
      out.write("                                        changePoint: 640,\n");
      out.write("                                        visibleItems: 2\n");
      out.write("                                    },\n");
      out.write("                                    tablet: {\n");
      out.write("                                        changePoint: 768,\n");
      out.write("                                        visibleItems: 3\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                            $(\"#flexiselDemo3\").flexisel({\n");
      out.write("                                visibleItems: 5,\n");
      out.write("                                animationSpeed: 1000,\n");
      out.write("                                autoPlay: true,\n");
      out.write("                                autoPlaySpeed: 3000,\n");
      out.write("                                pauseOnHover: true,\n");
      out.write("                                enableResponsiveBreakpoints: true,\n");
      out.write("                                responsiveBreakpoints: {\n");
      out.write("                                    portrait: {\n");
      out.write("                                        changePoint: 480,\n");
      out.write("                                        visibleItems: 1\n");
      out.write("                                    },\n");
      out.write("                                    landscape: {\n");
      out.write("                                        changePoint: 640,\n");
      out.write("                                        visibleItems: 2\n");
      out.write("                                    },\n");
      out.write("                                    tablet: {\n");
      out.write("                                        changePoint: 768,\n");
      out.write("                                        visibleItems: 3\n");
      out.write("                                    }\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                        });\n");
      out.write("                    </script>\n");
      out.write("                    <script type=\"text/javascript\" src=\"js/jquery.flexisel.js\"></script>\n");
      out.write("                    <div class=\"toogle\">\n");
      out.write("                        <h3 class=\"m_3\">Product Details</h3>\n");
      out.write("                        <p class=\"m_text\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>\n");
      out.write("                    </div>\t\t\t\t\t\n");
      out.write("                    <div class=\"toogle\">\n");
      out.write("                        <h3 class=\"m_3\">Product Reviews</h3>\n");
      out.write("                        <p class=\"m_text\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div><div class=\"fb-comments\" data-href=\"http://localhost:8084/SHOESWEB/details.jsp?productID=");
      out.print(IdSP);
      out.write("\" data-width=\"950\" data-numposts=\"5\"></div></div>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
