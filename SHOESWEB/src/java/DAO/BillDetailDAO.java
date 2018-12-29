/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.BillDetail;

/**
 *
 * @author Thuy Tran
 */
public class BillDetailDAO {
    public void insertBillDetail(BillDetail bd) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO CTPhieuXuat VALUES(?,?,?,?,1,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        //ps.setLong(1, bd.getBillDetailID());
        ps.setLong(1, bd.getBillID());
        ps.setLong(2, bd.getProductID());
        ps.setDouble(3, bd.getPrice());
        ps.setInt(4, bd.getQuantity());
        ps.setLong(5, bd.getSize());
        ps.executeUpdate();
    }
    public static void main(String[] args) throws SQLException {
        //new BillDetailDAO().insertBillDetail(new BillDetail(154411416, 1, 20, 1));
    }
}
