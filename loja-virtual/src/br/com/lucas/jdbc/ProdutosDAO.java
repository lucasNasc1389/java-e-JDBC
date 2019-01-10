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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ProdutosDAO {

    private final Connection con;

    public ProdutosDAO(Connection con) {
        this.con = con;
    }
    
     public void salva(Produto produto) throws SQLException {
        String sql = "insert into Produto(nome, descricao) values(?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.execute();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    produto.setId(id);
                }
            }
            
        }
    }

    List<Produto> lista() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from Produto";
        
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
           stmt.execute();
           
           try(ResultSet rs = stmt.getResultSet()){
               while(rs.next()) {
                   int id = rs.getInt("id");
                   String nome = rs.getString("nome");
                   String descricao = rs.getString("descricao");
                   Produto produto = new Produto(nome, descricao);
                   produto.setId(id);
                   produtos.add(produto);
               }
           }
        }
        return produtos;
    }

}
