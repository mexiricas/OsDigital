/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import osdigital.model.Cidade;
import osdigital.model.Pessoa;

/**
 *
 * @author HJ-Sistemas
 */
public class ClienteDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public void inserir(Pessoa pessoa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        sessao.save(pessoa);
        t.commit();
        sessao.close();
    }

    public List<Pessoa> listagemPessoa(int est_id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = null;
            if (est_id == 0) {
                consulta = sessao.createCriteria(Pessoa.class);
                if (consulta.list().size() == 0) {
                    return null;
                } else {
                    return consulta.list();
                }
            } else {
                consulta = sessao.createCriteria(Pessoa.class);
                consulta.add(Restrictions.eq("pes_id", est_id));
                if (consulta.list().size() == 0) {
                    return null;
                } else {
                    return consulta.list();
                }
            }

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();

        }
    }

    public List<Pessoa> listagemPessoaPorCPF(String pes_cpf) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = null;
            if (pes_cpf == null) {
                consulta = sessao.createCriteria(Pessoa.class);
                if (consulta.list().size() == 0) {
                    return null;
                } else {
                    return consulta.list();
                }
            } else {
                consulta = sessao.createCriteria(Pessoa.class);
                consulta.add(Restrictions.eq("pes_cpf", pes_cpf));
                if (consulta.list().size() == 0) {
                    return null;
                } else {
                    return consulta.list();
                }
            }

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();

        }
    }
    
    public Pessoa pesqPessoaNome(String pes_nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Pessoa.class);
            consulta.add(Restrictions.eq("pes_nome", pes_nome));
            if (consulta.list().size() == 0) {
                return null;
            } else {
                return (Pessoa) consulta.uniqueResult();
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
}
