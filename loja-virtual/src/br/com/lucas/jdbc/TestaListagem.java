/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        
        Connection connection =
                DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
        
        Statement statement = connection.createStatement();
        boolean resultado = statement.execute("select * from Produto");
        ResultSet resultSet = statement.getResultSet();
        
        
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            System.out.println(id);
            System.out.println(nome);
            System.out.println(descricao);
            }
        
        resultSet.close();
        statement.close();
        
        
    }
}
