/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.Tads.TrabalhoFinalLTPIII.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Caixa {
    
    private int codigo;
    private double Saldo;

    public Caixa() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo)throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo)  {
        this.Saldo = Saldo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Float.floatToIntBits((float) this.Saldo);
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
        final Caixa other = (Caixa) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Float.floatToIntBits((float) this.Saldo) != Float.floatToIntBits((float) other.Saldo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "CodCaixa=" + codigo + ", Saldo=" + Saldo + '}';
    }

    
}
