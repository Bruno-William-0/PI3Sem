/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno WIlliam
 */
public class Pedido {
    
    /**
     * 
     * @return - caso verdadeiro, query realizda com sucesso, caso falso, query fracassada 
     */
    public boolean fazerPedido()
    {
        try {
            String sql = "Insert into pedido values()"; //definir query corretamente
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();   
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    /**
     * 
     * Lista todos os pedidos que estão sendo feitos ou prontos
     * @return - caso verdadeiro, query realizda com sucesso, caso falso, query fracassada 
     * 
     */
    public boolean listarPedidos()
    {
        try {
            String sql = "Select * from pedido where";  //definir consulta
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();  
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    
    /**
     * Solicita o código e status de um pedido para atualizar seu status na tela
     * @param codigo - recebe o número do pedido
     * @param status - recebe o status do pedido
     * @return - caso verdadeiro, query realizda com sucesso, caso falso, query fracassada 
     */
    public boolean atualizarStatusPedido(int codigo, String status)
    {  
        try {
            String sql = "update pedido set status="; //defirnir query corretamente
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
          
}
