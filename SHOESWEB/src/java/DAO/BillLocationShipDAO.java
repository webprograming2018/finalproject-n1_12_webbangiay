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
import model.Bill;
import model.BillLocationShip;

/**
 *
 * @author Thuy Tran
 */
public class BillLocationShipDAO {
    public BillLocationShip getByIdBill(long id) throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select top 1 * from BillLocationShip where IdPX ='" + id + "' order by updateTime desc";
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        BillLocationShip billLocationShip = new BillLocationShip();
        while(rs.next()){
            billLocationShip.setIdBill(rs.getLong("IdPX"));
            billLocationShip.setIdShip(rs.getLong("IdShip"));
            billLocationShip.setLastLat(rs.getDouble("LastLat"));
            billLocationShip.setLastLng(rs.getDouble("LastLng"));
            billLocationShip.setLat(rs.getDouble("Lat"));
            billLocationShip.setLng(rs.getDouble("Lng"));
            billLocationShip.setUpdateTime(rs.getTimestamp("updateTime"));            
        }
        return billLocationShip;
    }
    
    public static void main(String[] args) throws SQLException {
        BillLocationShipDAO billLocationShipDAO = new BillLocationShipDAO();
        BillLocationShip b = billLocationShipDAO.getByIdBill(154515409);
        System.out.println(b.getIdBill() + ", " + b.getLat() + ", " + b.getLng() + ", " + b.getUpdateTime());
    }
}
