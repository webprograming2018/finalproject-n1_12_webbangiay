/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DsSanPhamDAO;
import DAO.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.BreakNode;
import model.Carts;
import model.Items;
import model.SanPham;
import model.Size;

/**
 *
 * @author Thuy Tran
 */
public class CartServlet extends HttpServlet {

    private final DsSanPhamDAO productDAO = new DsSanPhamDAO();
    private final SizeDAO sdao = new SizeDAO();

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
        String productID = request.getParameter("productID");
        Carts cart = (Carts) session.getAttribute("cart");
        String s = request.getParameter("size");        
        PrintWriter out = response.getWriter();
        try {
            
            int IdSize = Integer.parseInt(s);
            int idProduct = Integer.parseInt(productID);
//            out.println(IdSize);
//            out.println(idProduct);
            SanPham product = productDAO.getProduct(idProduct);           
            switch (command) {
                case "plus":
                    if (cart.getCartItems().containsKey(idProduct)) {
                        cart.plusToCart(idProduct, new Items(product,
                                cart.getCartItems().get(idProduct).getQuantity(), cart.getCartItems().get(idProduct).getSize()));
                    } else {
                        cart.plusToCart(idProduct, new Items(product, 1, IdSize));                        
                    }
                    
                    break;
                case "remove":
                    cart.removeToCart(idProduct);
                    break;
                case "sub":
                    cart.subToCart(idProduct, new Items(product,
                            cart.getCartItems().get(idProduct).getQuantity(), cart.getCartItems().get(idProduct).getSize()));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
           out.println("loi");
            //response.sendRedirect("/SHOESWEB/shop.jsp");
            
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("/SHOESWEB/shop.jsp");
        
    }
}
