/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifnmg.tads.ltp3.DoMainModel;

import edu.ifnmg.tads.ltp3.DoMainModel.Email;
import edu.ifnmg.tads.ltp3.DoMainModel.Endereco;
import edu.ifnmg.tads.ltp3.DoMainModel.Pessoa;
import edu.ifnmg.tads.ltp3.DoMainModel.Telefone;
import edu.ifnmg.tads.ltp3.DataAccess.PessoaDAO;


/**
 *
 * @author Jessica
 */
public class Principal {

    public static void main(String[] args) throws Exception {

        Pessoa pessoa = new Pessoa();
        Email email= new Email();
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();

        
        pessoa.setNome("Dayane");
        pessoa.setDataNascimento("13/09/1991");
        pessoa.setCPF(11111111);
        pessoa.setRG("1212121");
        //email.setEmail("Day@yahoo.com");
       // endereco.setBairro("Realengo");
        //endereco.setCidade("Rio de Janeiro");
        //endereco.setRua("Rua A");
        //endereco.setNumero(12);
        //telefone.setDDD(38);
       // telefone.setTelefone(69154205);
        
        
       // pessoa.addEmail(email);
        //pessoa.addEndereco(endereco);
        //pessoa.addTelefone(telefone);
        
        PessoaDAO dao = new PessoaDAO();
        
        dao.Salvar(pessoa);






    }
}
