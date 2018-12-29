/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DanhMucDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale.Category;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.danhmuc;

/**
 *
 * @author Thuy Tran
 */
public class ManagerCategoryServlet extends HttpServlet {

    DanhMucDAO categoryDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        String command = request.getParameter("command");
//        String category_id = request.getParameter("category_id");
//
//        String url = "";
//        try {
//            switch (command) {
//
//                case "delete":
//                    categoryDAO.deleteCategory(Long.parseLong(category_id));
//                    url = "/admin/manager_category.jsp";
//                    break;
//            }
//        } catch (Exception e) {
//        }
//        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String tenDanhMuc = request.getParameter("tenDanhMuc");

        String url = "", error = "";
        if (tenDanhMuc.equals("")) {
            error = "Vui lòng nhập tên danh mục!";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                        categoryDAO.insertCategory( new danhmuc(new Date().getTime()/10000,tenDanhMuc));
                        url = "/admin/qldanhmuc.jsp";
                        break;
                    case "update":
                        categoryDAO.updateCategory(new danhmuc(Long.parseLong(request.getParameter("category_id")),tenDanhMuc));
                        url = "/admin/qldanhmuc.jsp";
                        break;
                }
            } else {
                url = "/admin/insert-danhmuc.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }

}
//Long.parseLong(request.getParameter("category_id")), 