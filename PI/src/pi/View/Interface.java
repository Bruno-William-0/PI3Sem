/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.View;

import java.util.HashSet;
import javax.swing.*;

/**
 *
 * @author Bruno WIlliam
 */
public class Interface {
    /*public void tela()
    {
     JFrame jframe = new JFrame();
     jframe.setVisible(true);
     jframe.setSize(800, 500);
     jframe.setTitle("Cardápio");
     jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     jframe.setLayout(null);
     JButton jbutton = new JButton();
     jbutton.setText("Enviar");
     jbutton.setBounds(10, 10, 100, 100);
     jbutton.addActionListener(action -> {this.calcular();});
     jframe.add(jbutton);
    }
    
    public void calcular()
    {
     System.out.println("Luz");   
    }
    */
    
    public void tela() {
        JFrame frame = new JFrame("Exemplo de Quebra de Linha com JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Criar um JLabel com quebra de linha usando HTML
        JLabel label = new JLabel("<html>Isso é uma linha.<br>Isso é outra linha.</html>");

        // Adicionar o JLabel ao frame
        frame.add(label);

        frame.setVisible(true);
    }

    
}
