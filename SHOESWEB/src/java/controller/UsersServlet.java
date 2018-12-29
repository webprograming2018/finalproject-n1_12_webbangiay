/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TkhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author Thuy Tran
 */
public class UsersServlet extends HttpServlet {

    TkhoanDAO usersDAO = new TkhoanDAO();

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
        String url = "";
        TaiKhoan users = new TaiKhoan();
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        switch (command) {
            case "insert":
                //users.setIdTK(new java.util.Date().getTime());
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                users.setUsername(request.getParameter("username"));
                users.setPassword(request.getParameter("password"));
                users.setName(request.getParameter("name"));
                //out.println(request.getParameter("name"));
                //users.setLevel(2);
                usersDAO.insertUser(users);
                if (users != null) {
                    session.setAttribute("user", users);
                    url = "/index.jsp";
                }
                break;
            case "login":
                users = usersDAO.login(request.getParameter("username"), (request.getParameter("password")));
                if (users != null) {
                    session.setAttribute("user", users);
                    url = "/index.jsp";
                } else {
                    request.setAttribute("error", "Error username or password!");
                    url = "/login.jsp";
                }
                break;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
