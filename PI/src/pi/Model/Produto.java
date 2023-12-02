/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.Controller.Conexao;
import pi.Controller.Conexao;
import pi.View.TelaCardapio;


/**
 *
 * @author Guilherme
 */
abstract public class Produto {
    
    protected int codigo;
    protected String nome;
    protected String descricao;
    protected double preco;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
        
    
    
    
    
    
  }
