    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;

import java.util.ArrayList;
import pi.View.TelaCardapio;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.View.TelaCardapio;
/**
 *
 * @author Bruno WIlliam
 */
public class MontaPainelPedido {
  

    
    /**
     * Recebe um referência e uma label e adiciona um valor a label
     *
     * @param tela - parametro de referencia a um objeto
     * @param adicionar - recebe o conteúdo da label a ser editado
     */
    public void adicionarValor(TelaCardapio tela, String adicionar) {

        //Convertendo string pra array
        String label = tela.getLabel();
        String[] array = label.split(" ");
        ArrayList<String> arraylabel = new ArrayList<>();
        for (String item : array) {
            arraylabel.add(item);
        }

        //bloco para incluir item  
        
            arraylabel.add(adicionar + "<br> ");
        
            

        //Convertendo array para string   
        String retorno = String.join(" ", arraylabel);
        System.out.println(retorno);
        System.out.println(arraylabel);
        tela.setJlabel(13, retorno);
        System.out.println( tela.getPreco().replace("Total R$:", "").trim());
        System.out.println(consultarPreco(adicionar));
        System.out.println(Double.parseDouble(tela.getPreco().replace("Total R$:", "").trim()) + consultarPreco(adicionar));
        tela.setJlabel(14, "Total R$: " + Double.toString(Double.parseDouble(tela.getPreco().replace("Total R$:", "").trim()) + consultarPreco(adicionar)));
    }

    /**
     * Recebe uma referência de objeto e uma label, a label é editada excluindo
     * um dos valores
     *
     * @param tela - parametro de referencia a um objeto
     * @param excluir - recebe o conteúdo da label a ser editado
     */
    public void excluirValor(TelaCardapio tela, String excluir) {
        //Convertendo string pra array  
        String label = tela.getLabel();
        String[] array = label.split(" ");
        ArrayList<String> arraylabel = new ArrayList<>();
        for (String item : array) {
            arraylabel.add(item);
        }
        System.out.println(arraylabel);
        System.out.println(arraylabel.size());

        //Bloco para excluir item
        int n = arraylabel.size(); //aqui pegamos quantas palavras existem ao todo no array
        int apagar = 1;
        for (int i = 1; i < n; i++) //aqui fazemos um laço que passa por todo o array
        {
            if (arraylabel.get(i).equals(excluir + "<br>")) {
                //aqui vai a condição de remoção, preciso preparar ela ainda
                apagar = i;
                System.out.println("Seu id é" + apagar);
                System.out.println(arraylabel);
            }
            

        }
        
        if(arraylabel.get(apagar).equals(excluir + "<br>"))
        {
        arraylabel.remove(apagar);
        
        
        String retorno = String.join(" ", arraylabel);

        tela.setJlabel(13, retorno);
        tela.setJlabel(14, "Total R$: " + Double.toString(Double.parseDouble(tela.getPreco().replace("Total R$:", "").trim()) - consultarPreco(excluir)));}
    }

    /**
     * Contabiliza quantos itens diferentes tem e a quantidade
     *
     * @param tela - referência de um objeto
     */
    public void contabilizarItens(String label,  int cod) {
        
        //Converte String para array
        
        String[] array = label.split(" ");
        ArrayList<String> arraylabel = new ArrayList<>();
        for (String item : array) {
            arraylabel.add(item);
         }
        
        // Remover a substring "<br>" de cada elemento
        for (int i = 0; i < arraylabel.size(); i++) {
          if(i==0)
          {
              arraylabel.remove(i);
          }
          arraylabel.set(i, arraylabel.get(i).replace("<br>", ""));      
          System.out.println("A formatação atual é" + arraylabel);
    }
        
        
        

        
      //Preparando segundo array para contabilizar os itens e fazer query de pedido e quantidade  
      ArrayList<String> conta = new ArrayList();
       for (String comidas : arraylabel) {
            boolean encontrou = false;  
            for (String elemento : conta) {
                if (comidas.equals(elemento)) {
                    encontrou = true;
                    System.out.println(comidas + "É igual a" + elemento + "?");
                }
            }

            if (!encontrou) {
                conta.add(comidas);
                System.out.println("O valor que está sendo salvo no array de comparação é:" + comidas);
                System.out.println("O valor total do array de comparação é" + conta);
            }
       }
            //Adiciona os itens no pedido
            
            int qtd = 0;
            int ccod = 0;
            for(int i=0; i<conta.size(); i++)
            { 
             System.out.println("Começando o laço com" + arraylabel + " E " + conta);
             for(String pedido: arraylabel)   
             {
                if(conta.get(i).equals(pedido))
                {
                 qtd = qtd + 1;   
                }
             }
              System.out.println("A quantidade atual de "+ conta.get(i) +" é igual a:" + qtd);
              consultarCodigo(conta.get(i), qtd, cod);
              System.out.println("Fim do laço" + i);
              qtd = 0;
            }   
             
            
            
            
            
            
        }
        
    
    public static void consultarCodigo(String nome, int qtd, int cod)
    {
        int cpro;
        try {
                     String sql = String.format("Select * from produto where nome='%s'", nome); //definir query corretamente
                     System.out.println(sql);
                     PreparedStatement ps = null;         
                     ResultSet rs = null;
                     ps = Conexao.getConexao().prepareStatement(sql);   
                     rs = ps.executeQuery();
                     if(rs.next())
                     {
                        cpro = rs.getInt("cod_produto");   
                        System.out.println("Resultado do cod igual a" + rs.getInt("cod_produto"));
                     }
                     else
                     {
                     sql = String.format("Select * from combo where nome='%s'", nome); //definir query corretamente
                     ps = Conexao.getConexao().prepareStatement(sql);   
                     rs = ps.executeQuery();
                     cpro = rs.getInt("cod_combo");
                     System.out.println("Resultado do cod igual a" + rs.getInt("cod_combo"));
                     }
                     sql = String.format("Insert into tem_pedido values(%d, %d, %d)", cpro, cod, qtd);
                     System.out.println(sql);
                     ps = Conexao.getConexao().prepareStatement(sql);   
                     ps.executeUpdate();
            ps.close();
            rs.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(MontaPainelPedido.class.getName()).log(Level.SEVERE, null, ex);
                 } 
    }
                
    public static Double consultarPreco(String nome)
    {
        double preco = 0;
        try {
            String sql = String.format("Select preco from produto where nome='%s'", nome); //definir query corretamente
            System.out.println(sql);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
         ps.close();
            rs.close();
            if(rs.next())
            {
             preco = rs.getDouble("preco");   
            }
            else
            {
            sql = String.format("Select preco from combo where nome='%s'", nome); //definir query corretamente
            System.out.println(sql);
            ps = null;
            rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            preco = rs.getDouble("preco");
            ps.close();
            rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MontaPainelPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preco;
    }
       
       
       
       
    }

      
