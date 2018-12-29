/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaiKhoan;

/**
 *
 * @author Thuy Tran
 */
public class TkhoanDAO {

    // kiểm tra email tồn tại chưa
    public boolean checkUsername(String username) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * FROM KhachHang WHERE username = '" + username + "'";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TkhoanDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    // phương thức thêm tài khoản
    public boolean insertUser(TaiKhoan u) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO KhachHang VALUES(?,?,?,GETDATE(),1)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getName());
            // ps.setInt(4, u.getLevel());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TkhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // kiểm tra đăng nhập
    public TaiKhoan login(String username, String password) {
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from KhachHang where username='" + username + "' and password='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TaiKhoan u = new TaiKhoan();
                u.setIdTK(rs.getLong("idKH"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("TenKH"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TaiKhoan getUserById(long id) throws SQLException {
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from KhachHang where idKH ='" + id + "'";
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        TaiKhoan user = new TaiKhoan();
        while (rs.next()) {
            user.setIdTK(rs.getLong("idKH"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("TenKH"));
        }
        return user;
    }
}
