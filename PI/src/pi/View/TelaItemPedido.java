/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.View;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import pi.Controller.Conexao;
import pi.Controller.ItemPedido;
import pi.Controller.ProdutoController;
/**
 *
 * @author Caio
 */
public class TelaItemPedido{
    /**
     * 
     * @param cod_pedido - recebe código do pedido para utilizar na consulta sql
     */
    public void Tela(int cod_pedido)
    {
        JFrame tela = new JFrame("ItemDoPedido");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        tela.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        tela.setVisible(true);
          // Criação do JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Criação do JPanel para armazenar os cards
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(0,3));
        
        try {
            String sql = String.format("Select p.nome, p.descricao, tp.quantidade from produto as p inner join tem_pedido as tp on tp.fk_produto_cod_produto = p.cod_produto inner join pedido as pe on pe.cod_pedido = tp.fk_pedido_cod_pedido where pe.cod_pedido = %d", cod_pedido); //pedido, tem_pedido e produto 
            //definir query corretamente
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery(); 
            while(rs.next())
            {
            String label = String.format("<html>%s<br>%s<br>%s",rs.getString("nome"), rs.getString("descricao"), rs.getString("quantidade"));
            JPanel cardPanel = new JPanel();
                cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
            JLabel cardLabel = new JLabel(label);
                cardPanel.add(cardLabel);

                // Configuração do setBounds para o JPanel
                cardPanel.setBounds(10, 10, 50, 50); // Ajuste conforme necessário

                // Adiciona o JPanel principal ao JScrollPane
                cardsPanel.add(cardPanel);
            }
            scrollPane.setViewportView(cardsPanel);
            tela.add(scrollPane);
        } catch (SQLException ex) {
            Logger.getLogger(ItemPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }
}
