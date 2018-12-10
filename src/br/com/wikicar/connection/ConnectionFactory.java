package br.com.wikicar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivanilson P Mota
 */

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/WikiCar";
    private static final String USER = "mysql";
    private static final String PASS = "12345";
    
    public static Connection getConnection(){
        try {
            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException("ERROR: ", e);
        }
        
    }
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("ERROR: "+ e);
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pstmt){
        
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                 System.err.println("ERROR: "+ e);
            }
        }
        closeConnection(conn);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs){
        
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                 System.err.println("ERROR: "+ e);
            }
        }
        closeConnection(conn, pstmt);
    }
    
}
