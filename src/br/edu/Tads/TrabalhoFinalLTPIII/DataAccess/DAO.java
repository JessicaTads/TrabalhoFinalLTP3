/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.Tads.TrabalhoFinalLTPIII.DataAccess;

import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jessica
 */
public class DAO {

    public static boolean SalvarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection conexao;

    public DAO() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/TrabalhoFinalTPIII", "root", "");
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
    }

    public java.sql.Connection getConexao() {

        return conexao;


    }
}
