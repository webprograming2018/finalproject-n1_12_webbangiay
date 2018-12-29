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
import model.Admin;

/**
 *
 * @author Thuy Tran
 */
public class AdminDAO {
    public Admin login(String username, String password) {
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from QuanLy where username='" + username + "' and password='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin ad = new Admin();
                ad.setAdminID(rs.getLong("idQL"));
                ad.setAdminUsername(rs.getString("username"));
                ad.setAdminPass(rs.getString("password"));
                ad.setAdminName(rs.getString("TenQL"));
                con.close();
                return ad;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
