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
public class Cargo {

    private int codigo;
    private String cargo;

    public Cargo() {
    }

    public Cargo(int codigo, String cargo) {
        this.codigo = codigo;
        this.cargo = cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception{
        Pattern Cargo = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Cargo.matcher(cargo);

        if (verifica.matches()) {
            this.cargo = cargo;
        } else {
            throw new Exception("Campo 'Cargo' deve ter no mínimo 3 caracteres");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.cargo);
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
        final Cargo other = (Cargo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cargo;
    }
}
