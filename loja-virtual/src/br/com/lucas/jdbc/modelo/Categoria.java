/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Categoria {
   
    private int id;
    private String nome;
    private final List<Produto> produtos = new ArrayList<>();
    
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void adiciona(Produto p) {
        produtos.add(p);
    }

    @Override
    public String toString() {
        return String.format("%s", nome);
    }
    
    
}
