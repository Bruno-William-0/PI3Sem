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
import pi.Model.*;
/**
 *
 * @author Bruno
 */
public class ItemPedido extends ProdutoController{
    
    /**
     * 
     * @param cod_pedido - recebe o código referente ao pedido que quer ser retirado os itens  
     */
    public void encontrarItem(int cod_pedido)
    {        
        try {
            String sql = String.format("Select p.nome, p.descricao, tp.quantidade from produto as p inner join tem_pedido as tp on tp.fk_produto_cod_produto = p.cod_produto inner join pedido as pe on pe.cod_pedido = tp.fk_pedido_cod_pedido where pe.cod_pedido = %d", cod_pedido); //pedido, tem_pedido e produto 
            //definir query corretamente
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery(); 
            while(rs.next())
            {
            System.out.println(rs.getString("nome") + " " + rs.getString("descricao") + " " + rs.getString("quantidade"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
}
