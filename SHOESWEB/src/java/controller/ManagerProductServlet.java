/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DsSanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author Thuy Tran
 */
public class ManagerProductServlet extends HttpServlet {

    DsSanPhamDAO productGet = new DsSanPhamDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String command = request.getParameter("command");
        String product_id = request.getParameter("product_id");
        String tenSanPham = request.getParameter("tenSanPham");
        String maloai = request.getParameter("maloai");
        String daidien = request.getParameter("daidien");
        String gia = request.getParameter("gia");

        String url = "";
        try {
            switch (command) {

                case "delete":
                    productGet.deleteProduct(Long.parseLong(product_id));
                    url = "/admin/qlsanpham.jsp";
                    break;

            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
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
        String tenSanPham = request.getParameter("tenSanPham");
        long maloai = Long.parseLong(request.getParameter("maloai"));       
        String daidien = request.getParameter("daidien");        
        double gia = Double.parseDouble(request.getParameter("gia"));
        
        String url = "", error = "";
        if (tenSanPham.equals("")) {
            error = "Vui lòng nhập tên sản phẩm!";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                        productGet.insertProduct(new SanPham(new Date().getTime(), maloai, tenSanPham, daidien, gia, new Timestamp(new Date().getTime()) ,true));
                        url = "/admin/qlsanpham.jsp";
                        break;
                    case "update":                        
                        productGet.updateProduct(new SanPham(Long.parseLong(request.getParameter("product_id")), maloai, tenSanPham,
                                daidien, gia, new Timestamp(new Date().getTime()) ,true));
                        url = "/admin/qlsanpham.jsp";
                        break;

                }
            } else {
                url = "/admin/insert-sanpham.jsp";
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
