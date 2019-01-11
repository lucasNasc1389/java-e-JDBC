/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.lucas.jdbc.dao.CategoriasDAO;
import br.com.lucas.jdbc.dao.ProdutosDAO;
import br.com.lucas.jdbc.modelo.Categoria;
import br.com.lucas.jdbc.modelo.Produto;

/**
 *
 * @author lucas
 */
public class TestaCategorias {
    public static void main(String[] args) throws SQLException {
        
        try(Connection con = new ConnectionPool().getConnection()) {
            
           List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();
           
           for(Categoria categoria : categorias){
               System.out.println(categoria.getNome());
               
               for(Produto produto : categoria.getProdutos()){
                   System.out.println(categoria.getNome() + " - " + produto.getNome());
          }
           
        }
    }
}}
