package pi.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;

import javax.swing.*;
import pi.Controller.PedidoController;

/**
 * 
 * @author Caio
 */
public class TelaStatus {
	
	
	JFrame j = new JFrame();
	
	public void iniciar() {
        //Obtem a tela padrão
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Obtem a dimensão da tela
        Dimension screenSize = toolkit.getScreenSize();
        j.setTitle("Pedidos");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        // Cria um layout de grade com 1 linha e 3 colunas
        j.setLayout(new GridLayout(1, 2));
        // Cria a primeira coluna com labels
        JPanel coluna1 = new JPanel();
        coluna1.setLayout(new BoxLayout(coluna1, BoxLayout.Y_AXIS));
        
        coluna1.add(new JLabel("Em preparo"));
        coluna1.add(new JLabel(" "));
        PedidoController p = new PedidoController();
        for(String pedido: p.listarPedidosStatus("preparando"))
        {
           JLabel l = new JLabel();
            l.setText(pedido);
            l.setForeground(Color.orange);
            coluna1.add(l);
        }

        // Cria a segunda coluna com labels
        JPanel coluna2 = new JPanel();
        coluna2.setLayout(new BoxLayout(coluna2, BoxLayout.Y_AXIS));
        coluna2.add(new JLabel("Pronto"));
        coluna2.add(new JLabel(" "));
        for(String pedido: p.listarPedidosStatus("pronto"))
        {
            JLabel l = new JLabel();
            l.setText(pedido);
            l.setForeground(Color.green);
            coluna2.add(l);
            
        }
        
         // Adiciona as colunas à tela
        j.setVisible(true);
        j.add(coluna1);
        j.add(coluna2);
        
        }
     
	
}
    