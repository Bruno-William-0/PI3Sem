/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.Model.Pedido;
import pi.View.TelaCardapio;

/**
 *
 * @author Bruno
 */
public class PedidoController extends Pedido{
    
    /**
     * 
     * @return - caso verdadeiro, query realizda com sucesso, caso falso, query fracassada 
     */
 
   
    
    
  /**
   * 
   * @param tela - recebe uma instância com os valores atuais da tela do cardapio
   * @return - retorna se o pedido foi feito com sucesso ou não
   */
    public boolean fazerPedido(TelaCardapio tela)
    {
        try {
            String label = tela.getLabel();
            String sql = "Select max(cod_pedido) from pedido";
            //definir query corretamente
            PreparedStatement ps = null;
             ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();   
            while(rs.next())
            {
             this.cod = rs.getInt("max");
             System.out.println("O código atual é:" + cod);
            }
            System.out.println("O código final é" + cod);
            this.cod = this.cod + 1;
            sql = "Insert into pedido values (" + this.cod + ","+ "'" + nome + "'"+ "," + "'" + this.status + "'" + ")";
            System.out.println(sql);
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Pedido no nome de" + nome);
            MontaPainelPedido m = new MontaPainelPedido();
            m.contabilizarItens(label, this.cod);
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
        return true;
        

        }
    }
    

    
    /**
     * 
     * Lista todos os pedidos
     * @return - retorno de array de todos os pedidos 
     * 
     */
    public List<String> listarPedidos()
    {
        List <String> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido ORDER BY cod_pedido ASC"; //definir consulta
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();  
            
            while(rs.next())
            {
            pedido.add(String.format("%d, %s, %s", rs.getInt("cod_pedido"), rs.getString("nome_cliente"), rs.getString("Status"))); 
            }
            //System.out.println(numObj);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
    }
    /**
     * 
     * @param Status - recebe o status que será listado
     * @return - retorna um array com todos os pedidos com o status solicitado
     */
    public List<String> listarPedidosStatus(String Status)
    {
        List <String> pedido = new ArrayList<>();
        try {
            String sql = String.format("Select * from pedido where status='%s'", Status); //definir status da consulta
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();  
            
            while(rs.next())
            {
            pedido.add(String.format("%d  %s",rs.getInt("cod_pedido"), rs.getString("nome_cliente"))); 
            }
            //System.out.println(numObj);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
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
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
          
}
