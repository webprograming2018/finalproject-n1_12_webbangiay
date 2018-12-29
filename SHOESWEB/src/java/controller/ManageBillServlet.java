/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;

/**
 *
 * @author Thuy Tran
 */
public class ManageBillServlet extends HttpServlet {

    private final BillDAO billDAO = new BillDAO();

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
        doPost(request, response);
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
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        long id_bill = Long.parseLong(request.getParameter("billid"));
        //String idBill = request.getParameter("billid");
        //PrintWriter out = response.getWriter();
        //String url = "";
        //Bill bill = (Bill) session.getAttribute("bill");
        try {
            switch (command) {
                case "giao":
//                    out.println(id_bill);
//                    out.println(command);
                    billDAO.updateBill1(new Bill(id_bill));                    
                    break;
                case "hoanthanh":
                    billDAO.updateBill2(new Bill(id_bill));                    
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/SHOESWEB/admin/qldonhang.jsp");
            //out.println("loi");
        }
        //session.setAttribute("bill", bill);
        response.sendRedirect("/SHOESWEB/admin/qldonhang.jsp");
    }

}
