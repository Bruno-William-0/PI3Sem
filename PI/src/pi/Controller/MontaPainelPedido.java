/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;

import java.util.ArrayList;
import pi.View.TelaCardapio;

/**
 *
 * @author Bruno WIlliam
 */
public class MontaPainelPedido {
    
    public void adicionarValor(TelaCardapio tela, String adicionar)
    {
        
        //Convertendo string pra array
         String label = tela.getLabel();
         String[] array = label.split(" ");
         ArrayList<String> arraylabel = new ArrayList<>();
         for(String item: array)
          {
              arraylabel.add(item);   
          } 
         
         
         //bloco para incluir item  
            if(arraylabel.size() == 1)
            {
           arraylabel.add(adicionar+"<br> ");      
            }
            else
            {
             arraylabel.add(adicionar+"<br> ");   
            }
             
             
          //Convertendo array para string   
          String retorno = String.join(" ", arraylabel);
                 
          System.out.println(retorno);
          System.out.println(arraylabel);
          tela.setJlabel(13, retorno);
           
         
    }
    
    public void excluirValor(TelaCardapio tela, String excluir)
    {
          //Convertendo string pra array  
          String label = tela.getLabel(); 
          String[] array = label.split(" ");
          ArrayList<String> arraylabel = new ArrayList<>();
          for(String item: array)
          {
              arraylabel.add(item);   
          } 
          System.out.println(arraylabel);
          System.out.println(arraylabel.size());
          
           
          //Bloco para excluir item
            int n = arraylabel.size(); //aqui pegamos quantas palavras existem ao todo no array
            int apagar = 1;
             for(int i=1; i<n; i++)  //aqui fazemos um laço que passa por todo o array
             {
                 if(arraylabel.get(i).equals(excluir + "<br>"))
                 {
                    //aqui vai a condição de remoção, preciso preparar ela ainda
                    apagar = i;
                    
                  }
                  arraylabel.remove(apagar);
                 
              }
             
             
             
              

               String retorno = String.join(" ", arraylabel);
                 
                tela.setJlabel(13, retorno);
        }
    
        public void contabilizarItens(TelaCardapio tela)
        {
          //Converte String para array
          String label = tela.getLabel(); 
          String[] array = label.split(" ");
          ArrayList<String> arraylabel = new ArrayList<>();
          for(String item: array)
          {
              arraylabel.add(item);   
          } 
          System.out.println(arraylabel);
          
          
            
        }
         

    
}
