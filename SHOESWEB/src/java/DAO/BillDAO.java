/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectDB.DBconnect;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Bill;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaiKhoan;

/**
 *
 * @author Thuy Tran
 */
public class BillDAO {
    public void insertBill(Bill bill) throws SQLException {
        Connection connection = DBconnect.getConnecttion();
        String sql = "INSERT INTO PhieuXuat VALUES(?,?,?,?,?,GETDATE(),1,1)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setLong(1, bill.getBillID());
        ps.setLong(2, bill.getUserID());
        ps.setDouble(3, bill.getTotal());
        ps.setString(4, bill.getPayment());
        ps.setString(5, bill.getAddress());      
        //ps.setTimestamp(6, bill.getDate());
        ps.executeUpdate();
    }
    
    public Bill getBillById(long id) throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from PhieuXuat where IdPX ='" + id + "'";
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Bill bill = new Bill();
        while(rs.next()){
            bill.setBillID(rs.getLong("IdPX"));
            bill.setUserID(rs.getLong("IdKH"));
            bill.setTotal(rs.getDouble("ThanhTien"));
            bill.setPayment(rs.getString("PTTT"));
            bill.setAddress(rs.getString("DiaChi"));
            bill.setDate(rs.getTimestamp("NgayTao"));            
        }
        return bill;
    }
    
    public ArrayList<Bill> getListBill1() throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from PhieuXuat where TrangThai = 1";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Bill bill = new Bill();
            bill.setBillID(rs.getLong("IdPX"));
            bill.setUserID(rs.getLong("IdKH"));
            bill.setTotal(rs.getDouble("ThanhTien"));
            bill.setPayment(rs.getString("PTTT"));
            bill.setAddress(rs.getString("DiaChi"));
            bill.setDate(rs.getTimestamp("NgayTao"));
            bill.setStatus(rs.getInt("TrangThai"));
            list.add(bill);
        }
        con.close();
        return list;
    }
    
    public ArrayList<Bill> getListBill2() throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from PhieuXuat where TrangThai = 2";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Bill bill = new Bill();
            bill.setBillID(rs.getLong("IdPX"));
            bill.setUserID(rs.getLong("IdKH"));
            bill.setTotal(rs.getDouble("ThanhTien"));
            bill.setPayment(rs.getString("PTTT"));
            bill.setAddress(rs.getString("DiaChi"));
            bill.setDate(rs.getTimestamp("NgayTao"));
            bill.setStatus(rs.getInt("TrangThai"));
            list.add(bill);
        }
        con.close();
        return list;
    }
    
    public ArrayList<Bill> getBillByUser(long id) throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from PhieuXuat where IdKH ='" + id + "' order by TrangThai asc, NgayTao desc";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Bill bill = new Bill();
            bill.setBillID(rs.getLong("IdPX"));
            bill.setUserID(rs.getLong("IdKH"));
            bill.setTotal(rs.getDouble("ThanhTien"));
            bill.setPayment(rs.getString("PTTT"));
            bill.setAddress(rs.getString("DiaChi"));
            bill.setDate(rs.getTimestamp("NgayTao"));
            bill.setStatus(rs.getInt("TrangThai"));
            list.add(bill);
        }
        con.close();
        return list;
    }
    
    public ArrayList<Bill> getListBill3() throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from PhieuXuat where TrangThai = 3";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Bill bill = new Bill();
            bill.setBillID(rs.getLong("IdPX"));
            bill.setUserID(rs.getLong("IdKH"));
            bill.setTotal(rs.getDouble("ThanhTien"));
            bill.setPayment(rs.getString("PTTT"));
            bill.setAddress(rs.getString("DiaChi"));
            bill.setDate(rs.getTimestamp("NgayTao"));
            bill.setStatus(rs.getInt("TrangThai"));
            list.add(bill);
        }
        con.close();
        return list;
    }
    
    public ArrayList<Bill> getListBillAll() throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from PhieuXuat order by TrangThai asc, NgayTao desc";
        ArrayList<Bill> list = new ArrayList<>();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Bill bill = new Bill();
            bill.setBillID(rs.getLong("IdPX"));
            bill.setUserID(rs.getLong("IdKH"));
            bill.setTotal(rs.getDouble("ThanhTien"));
            bill.setPayment(rs.getString("PTTT"));
            bill.setAddress(rs.getString("DiaChi"));
            bill.setDate(rs.getTimestamp("NgayTao"));
            bill.setStatus(rs.getInt("TrangThai"));
            list.add(bill);
        }
        con.close();
        return list;
    }
    
    public boolean updateBill1(Bill b){
        Connection connection = DBconnect.getConnecttion();
        String sql = "UPDATE PhieuXuat SET TrangThai = 2 WHERE IdPX = ?";        
        try {
            PreparedStatement ps = connection.prepareCall(sql);    
            ps.setLong(1, b.getBillID());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public boolean updateBill2(Bill b){
        Connection connection = DBconnect.getConnecttion();
        String sql = "UPDATE PhieuXuat SET TrangThai = 3 WHERE IdPX = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);   
            ps.setLong(1, b.getBillID());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static void main(String[] args) throws SQLException {
        
        new BillDAO().insertBill(new Bill(154590928, 2, 2000000.0, "Live", "235 Nguyễn Trãi", new Timestamp(new Date().getTime())));
    }
}
