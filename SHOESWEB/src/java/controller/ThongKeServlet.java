/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BillDAO;
import DAO.ThongKeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
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
public class ThongKeServlet extends HttpServlet {

    BillDAO billDAO = new BillDAO();
    ThongKeDAO thongKeDAO = new ThongKeDAO();

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
        String ngaybd = request.getParameter("ngaybd");
        String ngaykt = request.getParameter("ngaykt");
        String ngayxem = request.getParameter("ngayxem");
        PrintWriter out = response.getWriter();
        String url = "", error = "";
        try {
            if (error.length() == 0) {
                switch (command) {
                    case "doanhthuweek":
                        //            out.println(id);
//                        out.println(ngaybd);
//
//                        out.println(ngaykt);
//              out.println(payment);
//              out.println(new Timestamp(new Date().getTime()));
                        thongKeDAO.doanhThuTuan(ngaybd, ngaykt);
                        url = "/admin/tkdoanhthu.jsp";
                        break;
                    case "doanhthuday":
                        thongKeDAO.doanhThuNgay(ngaybd, ngaykt);
                        url = "/admin/tkdoanhthu.jsp";
                        break;
                    case "ctdonhang":
                        thongKeDAO.chiTietDh(ngaybd, ngaykt);
                        url = "/admin/tkchitiet.jsp";
                        break;
                }
            } else {
                url = "/admin/index.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            //out.println("Loi cmnr");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }

}
