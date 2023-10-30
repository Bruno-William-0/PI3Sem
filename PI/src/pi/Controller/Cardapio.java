/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.View.TelaCardapio;


/**
 *
 * @author Bruno WIlliam
 */
public class Cardapio {
    
    public boolean lanche(TelaCardapio tela)
    {
        int i = 1;
        String descricao = "";
        try {
            String sql = "Select * from produto where tipo='lanche'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             descricao = String.valueOf(rs.getInt("cod_produto"))+ "" + rs.getString("nome")+";"+String.valueOf(rs.getDouble("preco"))+";"+rs.getString("descricao");
             tela.setJlabel(i, "<html>" + rs.getString("nome") + "<br>" + rs.getString("descricao") + "<br>" + "R$" + rs.getString("preco"));
             i++;   
            }
            
            
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       return true;
    }
    
      public boolean bebida(TelaCardapio tela)
    {
         int i = 6;
       try {
            String sql = "Select * from produto where tipo='bebida'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             tela.setJlabel(i, "<html>" + rs.getString("nome") + "<br>" + rs.getString("descricao") + "<br>" + "R$" + rs.getString("preco"));
             i++;   
            }
            
            
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       return true;
    }

    
    public boolean acompanhamento(TelaCardapio tela)
    {
         int i = 10;
       try {
            String sql = "Select * from produto where tipo='acompanhamento'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             tela.setJlabel(i, "<html>" + rs.getString("nome") + "<br>" + rs.getString("descricao") + "<br>" + "R$" + rs.getString("preco"));
             i++;   
            }
            
            
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex); 
            return false;
        }
        
       return true;
    }
    
    
  }
