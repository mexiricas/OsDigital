/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.negocio;

import javax.swing.JOptionPane;
import osdigital.dao.PessoaDAO;
import osdigital.forms.frmCliente;
import osdigital.forms.frmOsPrincipal;
import osdigital.model.Pessoa;
import osdigital.util.Utilitarios;

/**
 *
 * @author HJ-Sistemas
 */
public class PessoaRN {

    private PessoaDAO clDao = new PessoaDAO();
    private Pessoa cliente = new Pessoa();

    public Pessoa trazCadastro(String cpf) {
        this.cliente = clDao.pesqPessoaCPF(cpf);
        return cliente;
    }

    public void salvar(Pessoa pes) {
        if (pes.getPes_id() == 0) {
            this.clDao.inserir(pes);
        } else {
            this.clDao.alterar(pes);
        }
    }

    // getter setter
    public PessoaDAO getClDao() {
        return clDao;
    }

    public void setClDao(PessoaDAO clDao) {
        this.clDao = clDao;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

}
