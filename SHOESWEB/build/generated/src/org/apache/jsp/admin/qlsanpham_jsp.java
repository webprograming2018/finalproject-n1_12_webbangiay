package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.SanPham;
import java.util.ArrayList;
import DAO.DsSanPhamDAO;
import model.danhmuc;

public final class qlsanpham_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Quản lý sản phẩm</title>\n");
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
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            DsSanPhamDAO dsSanPhamDAO = new DsSanPhamDAO();
            ArrayList<SanPham> listProduct = dsSanPhamDAO.getListProduct();
        
      out.write("\n");
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
      out.write("                                    Sản Phẩm\n");
      out.write("                                </h1>\n");
      out.write("                                <ol class=\"breadcrumb\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <i class=\"fa fa-dashboard\"></i>  <a href=\"index.jsp\">Dashboard</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"active\">\n");
      out.write("                                        <i class=\"fa fa-table\"></i> Sản Phẩm\n");
      out.write("                                    </li>\n");
      out.write("                                </ol>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"table-responsive\">\n");
      out.write("                                <table class=\"table table-bordered table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("\n");
      out.write("                                            <th>ID sản phẩm</th>\n");
      out.write("                                            <th>Tên sản phẩm</th>\n");
      out.write("                                            <th>Id danh mục</th>\n");
      out.write("                                            <th>Hình ảnh</th>\n");
      out.write("                                            <!--<th>Trang Thai</th>-->\n");
      out.write("                                            <th>Đơn giá</th>\n");
      out.write("                                            <th>Ngay tao</th>\n");
      out.write("                                            <th>Tuy chon</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                ");

                                    int count = 0;
                                    for (SanPham sanPham : listProduct) {
                                        count++;
                                
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("\n");
      out.write("                                        <td>");
      out.print(sanPham.getIdSP());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(sanPham.getTenSP());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(sanPham.getIdDM());
      out.write("</td>\n");
      out.write("                                        <td><img src=\"../");
      out.print(sanPham.getSPimage());
      out.write("\"/></td>\n");
      out.write("                                        <td>");
      out.print(sanPham.getDonGia());
      out.write("</td>\n");
      out.write("                                        <!--<td>");
      out.print(sanPham.isTrangThai());
      out.write("</td>-->\n");
      out.write("                                        <td>");
      out.print(sanPham.getNgayTao());
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                <center>\n");
      out.write("                                    <a href=\"update_sanpham.jsp?command=update&product_id=");
      out.print(sanPham.getIdSP());
      out.write("\">Sửa</a>&nbsp;| &nbsp;\n");
      out.write("                                    <a href=\"/SHOESWEB/ManagerProductServlet?command=delete&product_id=");
      out.print(sanPham.getIdSP());
      out.write("\">Xóa</a>\n");
      out.write("\n");
      out.write("                                </center>\n");
      out.write("                                </td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                            <div><a href=\"insert-sanpham.jsp\">Thêm sản phẩm</a></div>\n");
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
