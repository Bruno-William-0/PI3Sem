    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Controller;

import java.util.ArrayList;
import pi.View.TelaCardapio;
import java.util.HashMap;
import java.util.Map;
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
        if (arraylabel.size() == 1) {
            arraylabel.add(adicionar + "<br> ");
        } else {
            arraylabel.add(adicionar + "<br> ");
        }

        //Convertendo array para string   
        String retorno = String.join(" ", arraylabel);

        System.out.println(retorno);
        System.out.println(arraylabel);
        tela.setJlabel(13, retorno);

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

            }
            arraylabel.remove(apagar);

        }

        String retorno = String.join(" ", arraylabel);

        tela.setJlabel(13, retorno);
    }

    /**
     * Contabiliza quantos itens diferentes tem e a quantidade
     *
     * @param tela - referência de um objeto
     */
    public void contabilizarItens(TelaCardapio tela) {
        //Converte String para array
        String label = tela.getLabel();
        String[] array = label.split(" ");
        ArrayList<String> arraylabel = new ArrayList<>();
        for (String item : array) {
            arraylabel.add(item);
        }
        System.out.println(array);
        int n = arraylabel.size();
        String item;
        int i;
        //laço deve se repetir de acordo com o tamanho do array
         // Crie um mapa para armazenar as contagens de letras
         /*
        Map<, Integer> contagemLetras = new HashMap<>();

        // Itere pelo array de letras
        for (char letra : letras) {
            // Verifique se a letra já está no mapa
            if (contagemLetras.containsKey(letra)) {
                // Se estiver, incremente o contador
                contagemLetras.put(letra, contagemLetras.get(letra) + 1);
            } else {
                // Se não estiver, adicione a letra ao mapa com contagem 1
                contagemLetras.put(letra, 1);
            }
        }

        // Itere pelo mapa e mostre as contagens de cada letra
        for (Map.Entry<Character, Integer> entrada : contagemLetras.entrySet()) {
            System.out.println("Letra " + entrada.getKey() + ": " + entrada.getValue() + " ocorrência(s)");
        }
*/  
    }

}
