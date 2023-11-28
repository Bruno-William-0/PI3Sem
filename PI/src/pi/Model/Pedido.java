/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Model;

/**
 *
 * @author Bruno
 */
public class Pedido {
    protected int cod;
    protected String nome;
    protected String status;

    public Pedido(int cod, String nome, String status) {
        this.cod = cod;
        System.out.println(this.nome = nome);
        this.status = status;
    }
    
    public Pedido()
    {}

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
