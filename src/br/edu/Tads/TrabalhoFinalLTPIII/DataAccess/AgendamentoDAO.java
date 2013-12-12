/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.Tads.TrabalhoFinalLTPIII.DataAccess;

import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Agendamento;
import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Cliente;
import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class AgendamentoDAO extends DAO {

    private DAO bd;
    private Cliente cliente;
    private Funcionario funcionario;
    private Agendamento Agendamento;

    public AgendamentoDAO() {
        super();

        bd = new DAO();
        cliente = new Cliente();

        funcionario = new Funcionario();
    }

    public boolean Salvar(Agendamento obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Agendamentos(data,idfuncionario, descricao, idCliente) values(?,?,?,?,?)");

                sqlInsert.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sqlInsert.setInt(3, obj.getCliente().getCodigo());
                sqlInsert.setInt(4, obj.getFuncionario().getCodigo());
                sqlInsert.setString(5, obj.getDescricao());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select idAgendamento from Agendamentos where data=? and descricao=? and idFuncionario=? and idCliente=?");
                sqlConsulta.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sqlConsulta.setInt(3, obj.getCliente().getCodigo());
                sqlConsulta.setString(4, obj.getDescricao());
                sqlConsulta.setInt(4, obj.getFuncionario().getCodigo());


                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("idAgendamento"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Agendamentos set data=? and descricao=? where idAgendamento=?");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setInt(2, obj.getCliente().getCodigo());
                sql.setInt(3, obj.getFuncionario().getCodigo());
                sql.setString(4, obj.getDescricao());
                sql.setInt(4, obj.getCodigo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Método Remover Agendamento
    public boolean Remover(Agendamento obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement("delete from Agendamentos where IdAgendamento=?");
                sqlDelete.setInt(1, obj.getCodigo());
                sqlDelete.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    public Agendamento AbrirAgendamento(int id) {
        try {

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            ClienteDAO clienteDAO = new ClienteDAO();


            PreparedStatement sql = getConexao().prepareStatement("select * from Agendamentos where IdAgendamento=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                Agendamento.setCliente(ClienteDAO.Abrir(resultado.getInt("Cliente")));


                return Agendamento;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public Agendamento buscar(Agendamento filtro) {
        try {

            String sql = "select * from Cliente p join Agendamneto A on C.IdCliente = A.IdCliente where ativo = 1 ";
            String where = "";

            if (filtro.getDescricao().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "and descricao like '%" + filtro.getDescricao() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " IdCliente = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            // Cria uma lista de produtos vazia
            List<Agendamento> agendamentos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Funcionario tmp = new Funcionario();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {

                    tmp.setCodigo(resultado.getInt("IdCliente"));


                } catch (Exception ex) {
                    Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                Agendamento.add(tmp);
            }
            return Agendamento;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Agendamento> ListarAgendamentos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from agendamentos");

            ResultSet resultado = sql.executeQuery();

            List<Agendamento> lista = new ArrayList<Agendamento>();

            while (resultado.next()) {
                Agendamento obj = new Agendamento();
                UsuarioDAO user = new UsuarioDAO();
                CaixaDAO caixa = new CaixaDAO();

                CarregaObjetoAgendamento(obj, resultado, user, caixa);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    private void CarregaObjetoAgendamento(Agendamento obj, ResultSet resultado, UsuarioDAO user, CaixaDAO caixa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
