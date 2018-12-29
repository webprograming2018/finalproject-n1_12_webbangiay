/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BillDAO;
import DAO.BillDetailDAO;
import DAO.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
//import java.sql.Date;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetail;
import model.Carts;
import model.Items;
import model.Size;
import model.TaiKhoan;

/**
 *
 * @author Thuy Tran
 */
public class CheckOutServlet extends HttpServlet {

    private final BillDAO billDAO = new BillDAO();
    private final BillDetailDAO billDetailDAO = new BillDetailDAO();
    private final SizeDAO sdao = new SizeDAO();

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
        String payment = request.getParameter("payment");
        String address = request.getParameter("address");
        //long IdSize = Long.parseLong(request.getParameter("idsize"));
        HttpSession session = request.getSession();
        Carts cart = (Carts) session.getAttribute("cart");
        TaiKhoan users = (TaiKhoan) session.getAttribute("user");
        PrintWriter out = response.getWriter();

        try {
            long id = new Date().getTime() / 10000;
            Bill bill = new Bill();
            bill.setBillID(id);
            bill.setUserID(users.getIdTK());
            bill.setTotal(cart.totalCart());
            bill.setPayment(payment);
            bill.setAddress(address);
            bill.setDate(new Timestamp(new Date().getTime()));
            //System.out.println("thong tin dh: ");

//            out.println(id);
//             out.println(users.getIdTK());
//             out.println(cart.totalCart());
//              out.println(payment);
//               out.println(address);
              //out.println(new Timestamp(new Date().getTime()));
//              
            billDAO.insertBill(bill);
            for (Map.Entry<Integer, Items> list : cart.getCartItems().entrySet()) {
                billDetailDAO.insertBillDetail(new BillDetail(id,
                        list.getValue().getProduct().getIdSP(),
                        list.getValue().getProduct().getDonGia(),
                        list.getValue().getQuantity(), list.getValue().getSize()));
            }
            cart = new Carts();
            session.setAttribute("cart", cart);
        } catch (Exception e) {
            //PrintWriter out = new PrintWriter();
            out.println("Loi cmnr");
        }
        response.sendRedirect("/SHOESWEB/index.jsp");
    }

}
