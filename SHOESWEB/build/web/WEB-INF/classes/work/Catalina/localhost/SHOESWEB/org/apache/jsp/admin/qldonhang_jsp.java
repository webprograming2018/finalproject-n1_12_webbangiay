/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.11
 * Generated at: 2018-12-22 09:34:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Bill;
import DAO.BillDAO;
import model.Admin;

public final class qldonhang_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("model.Bill");
    _jspx_imports_classes.add("model.Admin");
    _jspx_imports_classes.add("DAO.BillDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
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
