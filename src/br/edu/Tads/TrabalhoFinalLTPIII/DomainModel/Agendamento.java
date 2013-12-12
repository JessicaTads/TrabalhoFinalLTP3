/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.Tads.TrabalhoFinalLTPIII.DomainModel;



import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Agendamento {

    private int codigo;
    private Date data;
    private String Descricao;
    private Funcionario funcionario;
    private Cliente cliente;

    public Agendamento(int codigo, Date data, Funcionario funcionario, Cliente cliente) {
        this.codigo = codigo;
        this.data = data;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public Agendamento() {
        this.codigo = 0;
        this.data = data;
        this.funcionario = new Funcionario();
        this.cliente = new Cliente();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo Inválido!");
        }
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

   

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + Objects.hashCode(this.data);
        hash = 61 * hash + Objects.hashCode(this.funcionario);
        hash = 61 * hash + Objects.hashCode(this.cliente);
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
        final Agendamento other = (Agendamento) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
       
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "codigo=" + codigo + '}';
    }

    public void setCliente(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Funcionario tmp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
