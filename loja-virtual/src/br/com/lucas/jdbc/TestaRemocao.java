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
public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
         Connection connection = Database.getConnection();
         
         Statement statement = connection.createStatement();
         statement.execute("delete from Produto where id>3");
         int count = statement.getUpdateCount();
         System.out.println(count + " linhas atualizadas");  
             
         
         
         
         
         statement.close();
         connection.close();
         
    }
}
