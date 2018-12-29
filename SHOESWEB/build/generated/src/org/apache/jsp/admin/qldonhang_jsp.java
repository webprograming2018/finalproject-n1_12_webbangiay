package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Bill;
import DAO.BillDAO;
import model.Admin;

public final class qldonhang_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <base href=\"http://localhost:8080/SHOESWEB/admin/css\">\n");
      out.write("        <base href=\"http://localhost:8080/SHOESWEB/admin/font-awesome\">\n");
      out.write("        <base href=\"http://localhost:8080/SHOESWEB/admin/js\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Quản lý đơn hàng</title>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Morris Charts CSS -->\n");
      out.write("        <link href=\"css/plugins/morris.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Admin useradmin = (Admin) session.getAttribute("useradmin");
            if (useradmin == null) {
                response.sendRedirect("/SHOESWEB/admin/login.jsp");
            }
            BillDAO billDAO = new BillDAO();
            ArrayList<Bill> listBill1 = new ArrayList<>();
            listBill1 = billDAO.getListBill1();
            ArrayList<Bill> listBill2 = new ArrayList<>();
            listBill2 = billDAO.getListBill2();
            ArrayList<Bill> listBill3 = new ArrayList<>();
            listBill3 = billDAO.getListBill3();
        
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
      out.write("                                    Đơn Hàng\n");
      out.write("                                </h1>\n");
      out.write("                                <ol class=\"breadcrumb\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <i class=\"fa fa-dashboard\"></i>  <a href=\"index.jsp\">Dashboard</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"active\">\n");
      out.write("                                        <i class=\"fa fa-table\"></i> Đơn Hàng\n");
      out.write("                                    </li>\n");
      out.write("                                </ol>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <h3>Đơn hàng đang chờ xử lý</h3>\n");
      out.write("                            <div class=\"table-responsive\">\n");
      out.write("                                <table class=\"table table-bordered table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Mã Hóa Đơn</th>\n");
      out.write("                                            <th>Ngày Mua</th>\n");
      out.write("                                            <th>Thanh Toán</th>\n");
      out.write("                                            <th>Địa Chỉ</th>\n");
      out.write("                                            <th>Tổng Hóa Đơn</th>\n");
      out.write("                                            <th>Trạng Thái Đơn Hàng</th>\n");
      out.write("                                            <th>Tuy chon</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                ");
           int count = 0;
                                    String s = "Đã tiếp nhận";
                                    for (Bill bill : listBill1) {
                                        count++;                                        
                                
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr> \n");
      out.write("                                        <td>");
      out.print(bill.getBillID());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getDate());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getPayment());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getAddress());
      out.write("</td>                                \n");
      out.write("                                        <td>");
      out.print(bill.getTotal());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(s);
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                <center>\n");
      out.write("                                    <a href=\"/SHOESWEB/ManageBillServlet?command=giao&billid=");
      out.print(bill.getBillID());
      out.write("\">Đang giao</a>&nbsp;                                   \n");
      out.write("                                </center>\n");
      out.write("                                </td>\n");
      out.write("                                </tr>\n");
      out.write("                                </tbody>                                \n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                                <h4 style=\"text-align: right; font-weight: bold;\">Tổng số đơn: ");
      out.print(count);
      out.write("</h4>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <h3>Đơn hàng đang giao</h3>\n");
      out.write("                        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table table-bordered table-hover\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Mã Hóa Đơn</th>\n");
      out.write("                                        <th>Ngày Mua</th>\n");
      out.write("                                        <th>Thanh Toán</th>\n");
      out.write("                                        <th>Địa Chỉ</th>\n");
      out.write("                                        <th>Tổng Hóa Đơn</th>\n");
      out.write("                                        <th>Trạng Thái Đơn Hàng</th>\n");
      out.write("                                        <th>Tuy chon</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                ");
           int count1 = 0;
                                    String s1 = "Đang giao hàng";
                                    for (Bill bill : listBill2) {
                                        count1++;                                        
                                
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr> \n");
      out.write("                                        <td>");
      out.print(bill.getBillID());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getDate());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getPayment());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getAddress());
      out.write("</td>                                \n");
      out.write("                                        <td>");
      out.print(bill.getTotal());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(s1);
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                <center>\n");
      out.write("                                    <a href=\"/SHOESWEB/ManageBillServlet?command=hoanthanh&billid=");
      out.print(bill.getBillID());
      out.write("\">Hoàn thành</a>&nbsp;                                   \n");
      out.write("                                </center>\n");
      out.write("                                </td>\n");
      out.write("                                </tr>\n");
      out.write("                                </tbody>                                \n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                                <h4 style=\"text-align: right; font-weight: bold;\">Tổng số đơn: ");
      out.print(count1);
      out.write("</h4>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <h3>Đơn hàng đã hoàn thành</h3>\n");
      out.write("                        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table table-bordered table-hover\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Mã Hóa Đơn</th>\n");
      out.write("                                        <th>Ngày Mua</th>\n");
      out.write("                                        <th>Thanh Toán</th>\n");
      out.write("                                        <th>Địa Chỉ</th>\n");
      out.write("                                        <th>Tổng Hóa Đơn</th>\n");
      out.write("                                        <th>Trạng Thái Đơn Hàng</th>                                            \n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                ");
           int count2 = 0;
                                    String s2 = "Hoàn Thành";
                                    for (Bill bill : listBill3) {
                                        count2++;                                        
                                
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr> \n");
      out.write("                                        <td>");
      out.print(bill.getBillID());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getDate());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getPayment());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(bill.getAddress());
      out.write("</td>                                \n");
      out.write("                                        <td>");
      out.print(bill.getTotal());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(s2);
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>                                \n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                                <h4 style=\"text-align: right; font-weight: bold;\">Tổng số đơn: ");
      out.print(count2);
      out.write("</h4>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    </body>\n");
      out.write("                    </html>\n");
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
