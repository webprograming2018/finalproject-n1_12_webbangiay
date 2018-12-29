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
import model.SanPham;
import model.danhmuc;

/**
 *
 * @author Thuy Tran
 */
public class DsSanPhamDAO {

    public ArrayList<SanPham> getListProduct() {
        Connection cons = DBconnect.getConnecttion();
        String sql = "SELECT * FROM SanPham";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham product = new SanPham();
                product.setIdSP(rs.getInt("IdSP"));
                product.setTenSP(rs.getString("TenSP"));
                product.setIdDM(rs.getLong("IdDM"));
                product.setSPimage(rs.getString("SPimage"));
                product.setDonGia(rs.getDouble("DonGia"));
                list.add(product);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListProductByCategory(int IdDM) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * FROM SanPham WHERE IdDM = '" + IdDM + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<SanPham> list = new ArrayList<>();
        while (rs.next()) {
            SanPham product = new SanPham();
            product.setIdSP(rs.getInt("IdSP"));
            product.setTenSP(rs.getString("TenSP"));
            product.setSPimage(rs.getString("SPimage"));
            product.setDonGia(rs.getDouble("DonGia"));
            list.add(product);
        }
        return list;
    }

    public SanPham getProduct(long IdSP) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "SELECT * FROM SanPham WHERE IdSP = '" + IdSP + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        SanPham product = new SanPham();
        while (rs.next()) {
            product.setIdSP(rs.getLong("IdSP"));
            product.setTenSP(rs.getString("TenSP"));
            product.setSPimage(rs.getString("SPimage"));
            product.setDonGia(rs.getDouble("DonGia"));
        }
        return product;
    }

    public boolean delete(long product_id) throws SQLException {
        try {
            Connection connection = DBconnect.getConnecttion();
            String sql = "DELETE FROM product WHERE product_id = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, product_id);
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertProduct(SanPham c) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO SanPham VALUES(?,1,?,?,GETDATE(),1,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, c.getIdSP());
            ps.setLong(2, c.getIdDM());
            ps.setString(3, c.getTenSP());
            ps.setDouble(4, c.getDonGia());
            ps.setString(5, c.getSPimage());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DsSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // cập nhật dữ liệu
    public boolean updateProduct(SanPham c) {

        Connection connection = DBconnect.getConnecttion();
        String sql = "UPDATE SanPham SET IdDM=?, TenSP=?, DonGia=?, SPimage=? WHERE IdSP = ?";

        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, c.getIdDM());
            ps.setString(2, c.getTenSP());
            ps.setDouble(3, c.getDonGia());
            ps.setString(4, c.getSPimage());
            ps.setLong(5, c.getIdSP());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DsSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // xóa dữ liệu
    public boolean deleteProduct(long product_id) {
        Connection connection = DBconnect.getConnecttion();
        String sql = "DELETE FROM SanPham WHERE IdSP = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, product_id);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DsSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        DsSanPhamDAO dao = new DsSanPhamDAO();
        for(SanPham sp : dao.getListProductByCategory(1)){
            System.out.println(sp.getIdSP() + ": " + sp.getTenSP());
        }
        
    }
}
