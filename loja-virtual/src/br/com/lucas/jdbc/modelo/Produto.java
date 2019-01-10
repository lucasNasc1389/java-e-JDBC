/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc.modelo;

/**
 *
 * @author lucas
 */
public class Produto {
    
    private Integer id;
    private String nome;
    private String descricao;
    
    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("[produto: %d %s %s]", id, nome,descricao);
    }
    
    
    
    
    
}
