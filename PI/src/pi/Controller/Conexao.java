/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;
import java.sql.*;
/**
 *
 * @author Bruno WIlliam
 */
public class Conexao {
    private static final String url = "jdbc:postgresql://kesavan.db.elephantsql.com/wluhqrnx";
    private static final String user = "wluhqrnx";
    private static final String pass = "vulNbtDhjc-SVqibvTMv1CX4dL7Tj3bs";
    
    private static Connection conn;
    
    public static Connection getConexao()
    {
        try{
     if(conn == null)   
     {
      conn = DriverManager.getConnection(url, user, pass);
      return conn;
     }
     else
     {
      return conn;
     }
    }
    catch(SQLException ex)
    {
     ex.printStackTrace();
     return null;
    }
        
    }        
}
