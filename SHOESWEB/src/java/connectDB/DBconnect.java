/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thuy Tran
 */
public class DBconnect {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=WEB;"
                + "integratedSecurity=true";
        private static String USER_NAME = "sa";
        private static String PASSWORD = "thuy";
    public static Connection getConnecttion() {
        Connection cons = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
 
    public static void main(String[] args) {
        System.out.println(getConnecttion());
    }

}
