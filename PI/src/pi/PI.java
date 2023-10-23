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
    ArrayList<String> palavras = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
     
    palavras.add( "Primeiro elemento");
    palavras.add("Segundo elemento");
    palavras.add("Terceiro elemento");
    palavras.add("Primeiro elemento");
    
    int n = palavras.size();
    for(int i=0; i<n; i++)   
    {
        
         System.out.println(palavras.indexOf("Primeiro elemento"));   
        
    }
   
       
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
    
    }
       
       




