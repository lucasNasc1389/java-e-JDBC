/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc;

import br.com.lucas.jdbc.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author lucas
 */
public class TestaDAODeProduto {

    public static void main(String[] args) throws SQLException {
        Produto produto = new Produto("mesa azul", "mesa com 4 pés");

        try (Connection con = new ConnectionPool().getConnection()) {
            ProdutosDAO dao = new ProdutosDAO(con);
            dao.salva(produto);
            
            List<Produto> produtos = dao.lista();
             for(Produto prod : produtos){
                System.out.println("Existe um produto: " + prod);
            }
        }
        
        
    }

   
}
