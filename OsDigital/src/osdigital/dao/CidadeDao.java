/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import osdigital.model.Cidade;
import osdigital.model.Estado;

/**
 *
 * @author HJ-Sistemas
 */
public class CidadeDao implements Serializable {

    private static final long serialVersionUID = 1L;

    public static List<Cidade> listagemCidades(int est_id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = null;
            if (est_id == 0) {
                consulta = sessao.createCriteria(Cidade.class);
            } else {
                consulta = sessao.createCriteria(Cidade.class);
                consulta.add(Restrictions.eq("estado_id", est_id));

                List lscid = consulta.list();

                return lscid;
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();

        }
        return null;
    }

    public List<Estado> listagemSiglaEstados(String filtro) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Query consulta = null;
            if (filtro == null || filtro.equals("")) {
                consulta = sessao.createQuery("from Estado order by sigla");
            } else {
                consulta = sessao
                        .createQuery("from Estado where sigla like :parametro");
                consulta.setString("parametro", "%" + filtro + "%");
                List lsest = consulta.list();
                return lsest;
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();

        }
        return null;
    }

    public Estado pesqEstado(String est_sigla) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Estado.class);
            consulta.add(Restrictions.eq("est_sigla", est_sigla));
            if (consulta.list().size() == 0) {
                return null;
            } else {
                return (Estado) consulta.uniqueResult();
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
}
