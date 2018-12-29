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
import java.util.ArrayList;
import java.util.Date;
import model.Bill;
import model.BillDetail;
import model.TaiKhoan;

/**
 *
 * @author Thuy Tran
 */
public class ThongKeDAO {
    BillDAO billDAO = new BillDAO();
    public ArrayList<Bill> doanhThuTuan(String ngaybd, String ngaykt){
        Connection con = DBconnect.getConnecttion();
        String sql = "SELECT * FROM PhieuXuat WHERE NgayTao >= '" + ngaybd + "' AND NgayTao <= '" + ngaykt + "'";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill u = new Bill();
                u.setBillID(rs.getLong("IdPX"));
                u.setUserID(rs.getLong("idKH"));
                u.setTotal(rs.getDouble("ThanhTien"));
                u.setPayment(rs.getString("PTTT"));
                u.setAddress(rs.getString("DiaChi"));
                u.setDate(rs.getTimestamp("NgayTao"));
                list.add(u);                  
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Bill> doanhThuNgay(String ngaybd, String ngaykt){
        Connection con = DBconnect.getConnecttion();
        String sql = "SELECT * FROM PhieuXuat WHERE NgayTao >= '" + ngaybd + "' AND NgayTao <= '" + ngaykt + "'";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill u = new Bill();
                u.setBillID(rs.getLong("IdPX"));
                u.setUserID(rs.getLong("idKH"));
                u.setTotal(rs.getDouble("ThanhTien"));
                u.setPayment(rs.getString("PTTT"));
                u.setAddress(rs.getString("DiaChi"));
                u.setDate(rs.getTimestamp("NgayTao"));
                list.add(u);                
            }
            con.close();                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<BillDetail> chiTietDh(String ngaybd, String ngaykt){
        Connection con = DBconnect.getConnecttion();
        String sql = "SELECT * FROM CTPhieuXuat AS C JOIN PhieuXuat AS P ON C.IdPX = P.IdPX WHERE P.NgayTao >= '" + ngaybd + "' AND P.NgayTao <= '" + ngaykt + "'";
        ArrayList<BillDetail> list = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillDetail u = new BillDetail();
                u.setBillID(rs.getLong("IdPX"));
                u.setBillDetailID(rs.getLong("IdCTPX"));
                u.setProductID(rs.getLong("IdSP"));
                u.setQuantity(rs.getInt("SoLuongXuat"));
                u.setPrice(rs.getDouble("DonGiaXuat"));                
                list.add(u);                
            }
            con.close();                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        ThongKeDAO tkdao = new ThongKeDAO();
        for(BillDetail bill : tkdao.chiTietDh("2018-12-09","2018-12-19")){
                System.out.println(bill.getBillDetailID()+ "," + bill.getQuantity());
    }
}
}
