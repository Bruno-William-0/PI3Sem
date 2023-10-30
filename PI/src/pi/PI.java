/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import pi.Controller.Cardapio;
import pi.View.TelaCardapio;


/**
 *
 * @author Bruno WIlliam
 */
public class PI {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args)
    {
    /*O seguinte script tem como função adicionar um pedido que sera contabilizado 
     a partir da quantidade de palavras iguais que existe, o objetivo é que ao pedir para
     remover um lanche, ele remove a ultima vez que o nome de lanche for encontrado, então
        caso a palavra exista 10x no mesmo array, ele apagara a decima vez que a palavra aparecer*/
        
    //Criando um array list para o "carrinho" dos pedidos
    ArrayList<String> palavras = new ArrayList<String>();
    //Instãncia da classe scanner para poder testar a remoção de pedidos
    Scanner scanner = new Scanner(System.in);
    
    String linha;
    
    
    //Adicionando palavras
    palavras.add( "<html> Primeiro elemento <br>");
    palavras.add("Segundo elemento<br>");
    palavras.add("Terceiro elemento<br>");
    palavras.add("Primeiro elemento</html>");
    
    
    //preparando laço de repetição
    int n = palavras.size(); //aqui pegamos quantas palavras existem ao todo no array
    int apagar = 0;
    for(int i=0; i<n; i++)  //aqui fazemos um laço que passa por todo o array
    {
        if(palavras.get(i).equals("Primeiro elemento"))
        {
         //aqui vai a condição de remoção, preciso preparar ela ainda
         System.out.println(palavras.get(i));
         apagar = i;
        }
    }
    
    palavras.remove(apagar);
    
    System.out.println(palavras);
    
   
    
    //Tentativa falha
       /* 
       while (true) {
            System.out.println("Digite uma palavra ou 'remover' para remover uma palavra:");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("remover")) {
                if (!palavras.isEmpty()) {
                    System.out.println("Palavras disponíveis para remoção:");
                    for (int i = 0; i < palavras.size(); i++) {
                        System.out.println((i + 1) + ". " + palavras.get(i));
                    }

                    System.out.println("Digite o número da palavra que deseja remover:");
                    int indice = Integer.parseInt(scanner.nextLine()) - 1;

                    if (indice >= 0 && indice < palavras.size()) {
                        palavras.remove(indice);
                        System.out.println("Palavra removida com sucesso.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                } else {
                    System.out.println("Não há palavras para remover.");
                }
            } else {
                palavras.add(entrada);
                System.out.println("Palavra adicionada com sucesso.");
            }
        }
    }
    */
    }
       
       


}

