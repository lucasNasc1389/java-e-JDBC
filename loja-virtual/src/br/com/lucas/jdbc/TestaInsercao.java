/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
         Connection connection = Database.getConnection();
         
         Statement statement = connection.createStatement();
         boolean resultado = statement.execute("insert into Produto(nome, descricao) values('Notebook', 'Asus2')",
                 Statement.RETURN_GENERATED_KEYS);
         System.out.println(resultado);
         
         ResultSet resultSet = statement.getGeneratedKeys();
         
         while(resultSet.next()) {
            String id = resultSet.getString("id");
             System.out.println(id + " gerado");
         }
         
         statement.close();
         connection.close();
    }
}
