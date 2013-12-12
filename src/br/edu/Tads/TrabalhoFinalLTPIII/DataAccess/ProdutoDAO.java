/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.Tads.TrabalhoFinalLTPIII.DataAccess;

import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Fornecedor;
import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Marca;
import br.edu.Tads.TrabalhoFinalLTPIII.DomainModel.Produto;

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
public class ProdutoDAO extends DAO {

    private DAO bd;
    private Marca marca;
    
    private Fornecedor fornecedor;
    private Produto produto;

    public ProdutoDAO() {

        bd = new DAO();
        marca = new Marca();
       
        produto = new Produto();
        fornecedor = new Fornecedor();
    }

    public boolean Salvar(Produto produto) {
        try {
            if (produto.getCodProduto()== 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into Produtos(nome,marca,fornecedor,qtd,preco,descricao,ativo) values(?,?,?,?,?,?,?)");
                comando.setString(1, produto.getNome());
                comando.setInt(2, produto.getMarca().getCodMarca());
                comando.setInt(3, produto.getFornecedor().getCodigo());
                comando.setInt(4, produto.getQtd());
                comando.setDouble(5, produto.getPreco());
                comando.setString(6, produto.getDescricao());
                comando.setInt(7, produto.getAtivo());

                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update Produtos set nome = ? and marca=? and fornecedor=? and qtd=? and preco=? and descricao=? and ativo=? where idProduto = ?");
                comando.setString(1, produto.getNome());
                comando.setString(2, produto.getMarca().getNome());
                comando.setString(3, produto.getFornecedor().getNome());
                comando.setInt(4, produto.getQtd());
                comando.setDouble(5, produto.getPreco());
                comando.setString(6, produto.getDescricao());
                comando.setInt(7, produto.getAtivo());
                comando.setInt(8, produto.getCodProduto());


                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Produto AbrirProduto(int id) {
        try {

            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            MarcaDAO marcaDAO = new MarcaDAO();


            PreparedStatement sql = getConexao().prepareStatement("select * from Produtos where IdProduto=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                produto.setFornecedor(fornecedorDAO.AbrirFornecedor(resultado.getInt("Fornecedor")));
                produto.setMarca(marcaDAO.Abrir(resultado.getInt("Marca")));

                return produto;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Produto> ListarTodosProdutos() {
        try {

            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            MarcaDAO marcaDAO = new MarcaDAO();

            PreparedStatement sql = getConexao().prepareStatement("select * from Produtos where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                CarregaObjetoProduto(obj, resultado);



                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Produto> buscar(Produto filtro) {
        try {

            String sql = "select * from Produtos ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodProduto() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " IdProduto = " + filtro.getCodProduto();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Produto tmp = new Produto();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {

                    tmp.setCodProduto(resultado.getInt("IdProduto"));
                    tmp.setNome(resultado.getString("nome"));

                } catch (Exception ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update produtos where idProduto = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    protected void CarregaObjetoProduto(Produto obj, ResultSet resultado) throws Exception, SQLException {
        MarcaDAO marcaDAO = new MarcaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        obj.setCodProduto(resultado.getInt("idProduto"));
        obj.setNome(resultado.getString("Nome"));
        obj.setQtd(resultado.getInt("qtd"));
        obj.setDescricao(resultado.getString("Descricao"));
        obj.setPreco(resultado.getFloat("Preco"));
        obj.setMarca(marcaDAO.Abrir(resultado.getInt("marca")));
        obj.setFornecedor(fornecedorDAO.AbrirFornecedor(resultado.getInt("fornecedor")));
    }
}