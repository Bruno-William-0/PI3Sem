/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.TelaLanche;
/**
 *
 * @author Bruno WIlliam
 */
public class Cardapio {
    
    public String lanche(TelaLanche tela)
    {
        String descricao = "";
        try {
            String sql = "Select * from produto where tipo='lanche'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             //descricao = String.valueOf(rs.getInt("cod_produto"))+ "" + rs.getString("nome")+";"+String.valueOf(rs.getDouble("preco"))+";"+rs.getString("descricao");
             tela.setJlabel1(rs.getString("nome"));
             tela.setJlabel2(rs.getString("descricao"));
             tela.setJlabel3(rs.getString("preco"));
            }
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return null;
    }
    
      public String bebida()
    {
        
        try {
            String sql = "Select * from produto where tipo='bebida'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             System.out.println(String.valueOf(rs.getInt("cod_produto"))+" " +rs.getString("nome")+" "+String.valueOf(rs.getDouble("preco"))+" "+rs.getString("descricao")); 
            }
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return null;
    }

    
    public String acompanhamento()
    {
        
        try {
            String sql = "Select * from produto where tipo='acompanhamento'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             return String.valueOf(rs.getInt("cod_produto"))+" " +rs.getString("nome")+" "+String.valueOf(rs.getDouble("preco"))+" "+rs.getString("descricao"); 
            }
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return null;
    }
    
    
  }
