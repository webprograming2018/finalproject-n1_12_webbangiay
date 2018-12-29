package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.TaiKhoan;
import DAO.BillDAO;
import DAO.DsSanPhamDAO;
import DAO.TkhoanDAO;
import java.util.ArrayList;
import model.Bill;
import DAO.ThongKeDAO;
import model.Admin;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>        \n");
      out.write("        <base href=\"http://localhost:8080/SHOESWEB/admin/css\">\n");
      out.write("        <base href=\"http://localhost:8080/SHOESWEB/admin/font-awesome\">\n");
      out.write("        <base href=\"http://localhost:8080/SHOESWEB/admin/js\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin</title>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap-datetimepicker.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap-datetimepicker.min.js\"></script>\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/bootstrap-datetimepicker.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Morris Charts CSS -->\n");
      out.write("        <link href=\"css/plugins/morris.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"js/locales/bootstrap-datetimepicker.pt-BR.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css\">        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var time = new Date().getTime();\n");
      out.write("            $(document.body).bind(\"mousemove keypress\", function (e) {\n");
      out.write("                time = new Date().getTime();\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            function refresh() {\n");
      out.write("                if (new Date().getTime() - time >= 6000)\n");
      out.write("                    window.location.reload(true);\n");
      out.write("                else\n");
      out.write("                    setTimeout(refresh, 1000);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            setTimeout(refresh, 1000);\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }

            BillDAO billDAO = new BillDAO();
            ArrayList<Bill> listBill = new ArrayList<>();
            listBill = billDAO.getListBillAll();
            TkhoanDAO user = new TkhoanDAO();            
        
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!-- Navigation -->\n");
      out.write("            <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "side-bar.jsp", out, false);
      out.write("\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                        <!-- Page Heading -->\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <h1 class=\"page-header\">\n");
      out.write("                                    Dashboard <small>Overview</small>\n");
      out.write("                                </h1>\n");
      out.write("                                <div><h2>Thống kê</h2></div>                                \n");
      out.write("\n");
      out.write("                                <table class=\"table table-bordered table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("\n");
      out.write("                                            <th>ID Đơn Hàng</th>\n");
      out.write("                                            <th>Ngày đặt</th>\n");
      out.write("                                            <th>Ten KH</th>\n");
      out.write("                                            <!---->\n");
      out.write("                                            <th>Thành Tiền</th> \n");
      out.write("                                            <th>Trang Thai</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                ");

                                    int tongdt = 0, count = 0;
                                    for (Bill bill : listBill) {
                                        tongdt += bill.getTotal();
                                        count++;
                                        TaiKhoan u = user.getUserById(bill.getUserID());
                                
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("\n");
      out.write("                                        <td>");
      out.print(bill.getBillID());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getDate());
      out.write("</td>  \n");
      out.write("                                        <td>");
      out.print(u.getName());
      out.write("</td>  \n");
      out.write("                                        <td>");
      out.print(bill.getTotal());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getStatus());
      out.write("</td>  \n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>                                \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                            <div style=\"text-align: right; font-weight: bold;\">TỔNG SỐ ĐƠN: ");
      out.print(count);
      out.write("</div>\n");
      out.write("                            <div style=\"text-align: right; font-weight: bold;\">TỔNG DOANH THU: ");
      out.print(tongdt);
      out.write("</div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.row -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
