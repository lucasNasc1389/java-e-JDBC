/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
         String nome = "Notebook 'i3' 2013";
         String descricao = "Notebook i3";
        
         Connection connection = Database.getConnection();
         
         String sql = "insert into Produto(nome, descricao) values(?, ?)";
         PreparedStatement statement = connection.prepareStatement(sql, 
                 Statement.RETURN_GENERATED_KEYS);
         statement.setString(1, nome);
         statement.setString(2, descricao);
         
         boolean resultado = statement.execute();
         
         System.out.println(resultado);
         
         ResultSet resultSet = statement.getGeneratedKeys();
         while(resultSet.next()) {
            String id = resultSet.getString("id");
             System.out.println(id + " gerado");
         }
         
         resultSet.close();
         statement.close();
         connection.close();
    }
}
