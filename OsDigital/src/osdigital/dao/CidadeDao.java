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
import org.hibernate.Query;
import org.hibernate.Session;
import osdigital.model.Cidade;

/**
 *
 * @author HJ-Sistemas
 */
public class CidadeDao implements Serializable {

    private static final long serialVersionUID = 1L;

    public static List<Cidade> listagemCidades(String cid_nome) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query consulta = sessao.createQuery("from Cidades");
        if (cid_nome == null) {
            consulta = sessao.createQuery("from Cidades order by nome");
        } else {
            consulta = sessao
                    .createQuery("from Cidades where nome like:parametro order by id");
            consulta.setString("parametro", "%" + cid_nome + "%");
        }
        List lscid = consulta.list();
        sessao.close();

        return lscid;
    }

}
