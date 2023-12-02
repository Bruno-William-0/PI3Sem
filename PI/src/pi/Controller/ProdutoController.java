/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.Model.Produto;
import pi.View.TelaCardapio;

/**
 *
 * @author Bruno
 */
 public class ProdutoController extends Produto{
    /**
     * Listagem dos produtos do tipo lanche e retorna um valor verdadeiro caso o sucesso e falso caso fracasso
     * @param tela - referência do objeto
     * @return -  retorno verdadeiro ou falso 
     */
    
    public boolean CriarCard(TelaCardapio tela, int i, String sql)
            
    {
         try {
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
             codigo = rs.getInt("cod_produto");
             nome = rs.getString("nome");
             descricao = rs.getString("descricao");
             preco = rs.getDouble("preco");
             tela.setJlabel(i, "<html>" + nome + "<br>" + descricao + "<br>" + "R$" + preco);
             i++;   
            }
            
            
             ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       return true;
    }
}
