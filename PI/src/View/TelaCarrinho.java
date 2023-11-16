/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
/**
 *
 * @author Windows
 */
public class TelaCarrinho {
    
    public static void main(String[] args)
    {
        
    }
    public TelaCarrinho()
    {
     JFrame jframe = new JFrame();   
     jframe.setVisible(true);
     jframe.setBounds(0, 0, 1360, 768);
     jframe.setTitle("Carrinho");
     
     JScrollPane scroll = new JScrollPane();
     scroll.setBounds(5, 5, 800, 400);
     jframe.add(scroll);
     
     JPanel panel = new JPanel();
     panel.setBounds(850, 5, 500, 700);
     panel.add(scroll);
    }
    
   
        
    
}
