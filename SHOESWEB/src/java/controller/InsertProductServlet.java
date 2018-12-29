/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connectDB.DBconnect;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;

@WebServlet("/images")
@MultipartConfig(maxFileSize = 16177215)
/**
 *
 * @author Thuy Tran
 */
public class InsertProductServlet extends HttpServlet {

    // database connection settings
    private String dbURL = "jdbc:sqlserver://localhost:1433/WEB";
    private String dbUser = "sa";
    private String dbPass = "thuy";
    private static final String UPLOAD_DIRECTORY = "images";

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
        // gets values of text fields
        String tenSanPham = request.getParameter("tenSanPham");
        long maloai = Long.parseLong(request.getParameter("maloai"));        
        double gia = Double.parseDouble(request.getParameter("gia"));        

        InputStream inputStream = null;
        // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("daidien");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();

        }
        
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            Connection connection = DBconnect.getConnecttion();

            // constructs SQL statement
            String sql = "INSERT INTO SanPham (IdSP, IdDM, TenSP, SPimage, DonGia) VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, new Date().getTime()/10000);
            ps.setLong(2, maloai);
            ps.setString(3, tenSanPham);            
            if (inputStream != null) {

                String filename = filePart.getSubmittedFileName();
                ps.setString(4, UPLOAD_DIRECTORY + "/" + filename);
            }            
            ps.setDouble(5, gia);           

            // sends the statement to the database server
            int row = ps.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (Exception ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);

            // forwards to the message page
            getServletContext().getRequestDispatcher("/admin/qlsanpham.jsp").forward(request, response);
        }
    }

}
