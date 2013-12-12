/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.Tads.TrabalhoFinalLTPIII.DomainModel;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Produto {

    private int codigo;
    private Marca marca;
    private Fornecedor fornecedor;
    private String Nome;
    private int qtd;
    private double Preco;
    private int ativo;
    private String descricao;

    public Produto() {
        this.ativo = 1;
    }

    public Produto(int CodProduto, Marca marca, Fornecedor fornecedor, String Nome, int qtd, double Preco, int ativo, String descricao) {
        this.codigo = CodProduto;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.Nome = Nome;
        this.qtd = qtd;
        this.Preco = Preco;
        this.ativo = ativo;
        this.descricao = descricao;
    }

    public int getCodProduto() {
        return codigo;
    }

    public void setCodProduto(int CodProduto) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) throws Exception {
        if (Preco > 0) {
            this.Preco = Preco;
        } else {
            throw new Exception("Valor passado para o campo 'preco' não pode ser negativo!");
        }
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao)throws Exception {
        Pattern Descricao = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Descricao.matcher(descricao);

        if (verifica.matches()) {
            this.descricao = descricao;
        } else {
            throw new Exception("Campo 'Descrição' deve ter no mínimo 3 caracteres");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.codigo;
        hash = 43 * hash + Objects.hashCode(this.marca);
        hash = 43 * hash + Objects.hashCode(this.fornecedor);
        hash = 43 * hash + Objects.hashCode(this.Nome);
        hash = 43 * hash + this.qtd;
        
        hash = 43 * hash + this.ativo;
        hash = 43 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
