/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.DBconnect;
import static connectDB.DBconnect.getConnecttion;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.danhmuc;

/**
 *
 * @author Thuy Tran
 */
public class DanhMucDAO {
    public ArrayList<danhmuc> getListCategory() {
        Connection cons = DBconnect.getConnecttion();
        String sql = "SELECT * FROM DanhMuc";
        ArrayList<danhmuc> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhmuc dmuc = new danhmuc();
                dmuc.setIdDM(rs.getLong("IdDM"));
                dmuc.setTenDM(rs.getString("TenDM"));
                list.add(dmuc);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // thêm mới dữ liệu
    public boolean insertCategory(danhmuc c) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO DanhMuc VALUES(?,?,1, GETDATE())";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, c.getIdDM());
            ps.setString(2, c.getTenDM());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // cập nhật dữ liệu
    public boolean updateCategory(danhmuc c) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "UPDATE DanhMuc SET TenDM = ? WHERE IdDM = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, c.getTenDM());
            ps.setLong(2, c.getIdDM());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    public static void main(String[] args) {
        DanhMucDAO dao = new DanhMucDAO();
        //dao.updateCategory(new danhmuc(5, "aa"));
        //dao.insertCategory(new danhmuc(5, "Category " + 5));
        for(danhmuc dm : dao.getListCategory()){
            System.out.println(dm.getIdDM() + ": " + dm.getTenDM());
        }
    
    //CategoryDAO dao = new CategoryDAO();
        
        //System.out.println(dao.deleteCategory(7));
    }
}
