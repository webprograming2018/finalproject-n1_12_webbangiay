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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Size;
/**
 *
 * @author Thuy Tran
 */
public class SizeDAO {
    public ArrayList<Size> getListSizes() throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from Size";
        ArrayList<Size> list = new ArrayList<>();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Size size = new Size();
            size.setId(rs.getLong("IdSize"));
            size.setName(rs.getLong("TenSize"));
            list.add(size);
        }
        con.close();
        return list;
    }
    
    public Size getSizeByName( long id) throws SQLException{
        Connection con = DBconnect.getConnecttion();
        String sql = "select * from Size where TenSize = '" + id + "'";
        Size size = new Size();
        PreparedStatement ps;
        ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){           
            size.setId(rs.getLong("IdSize"));
            size.setName(rs.getLong("TenSize"));            
        }
        con.close();
        return size;
    }
    
    public static void main(String[] args) throws SQLException {
        
       SizeDAO sdao = new SizeDAO();
       for(Size s : sdao.getListSizes()){
           System.out.println(s.getId() + ": " + s.getName());
       }
    }
}
