/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifnmg.tads.ltp3.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jessica
 */
public class DAO {
     private Connection conexao;
     public DAO() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/SalaodeBeleza", "root", "");
        } catch (Exception ex) {

            System.err.print(ex.getMessage());
        }
    }

    public java.sql.Connection getConexao() {

        return conexao;


    }
    
    
    
    
}
