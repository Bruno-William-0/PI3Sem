/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teste;

import java.util.ArrayList;

/**
 *
 * @author Bruno WIlliam
 */
public class java {
    
         
      public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Item 1");
        lista.add("Item 2");
        lista.add("Item 3");

        // Transformando ArrayList em String
        String listaComoString = String.join(", ", lista);
        System.out.println("ArrayList como String: " + listaComoString);

        // Transformando String em ArrayList
        String string = "Item 1, Item 2, Item 3";
        String[] array = string.split(", ");
        ArrayList<String> novaLista = new ArrayList<>();
        for (String item : array) {
            novaLista.add(item);
        }
        System.out.println("String como ArrayList: " + novaLista);
    }
}

    

