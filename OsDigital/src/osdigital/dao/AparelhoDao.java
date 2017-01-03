/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import osdigital.model.Aparelho;
import osdigital.model.Cidade;

/**
 *
 * @author HJ-Sistemas
 */
public class AparelhoDao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public void inserir(Aparelho ap) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        sessao.save(ap);
        t.commit();
        sessao.close();
    }
    
    public List<Aparelho> pesqAparelhoMarca(String marca) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List lscid = null;
        Criteria consulta = null;
        try {
            
            if (marca == null || marca.equalsIgnoreCase("")) {
                return null;
            } else {
                consulta = sessao.createCriteria(Aparelho.class);
                consulta.add(Restrictions.ilike("apcdMarca", "%" + marca + "%"));
                return lscid = consulta.list();
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
   public List<Aparelho> pesqAparelhoModelo(String modelo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List lscid = null;
        Criteria consulta = null;
        try {
            
            if (modelo == null || modelo.equalsIgnoreCase("")) {
                return null;
            } else {
                consulta = sessao.createCriteria(Aparelho.class);
                consulta.setProjection(Projections.distinct(Projections.property("apcdModelo")));
                consulta.add(Restrictions.ilike("apcdModelo", "%" + modelo + "%"));
                return lscid = consulta.list();
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
   
   
    public  List<Aparelho> pesqModelo(String modelo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List lscid = null;
        try {
            Query consulta = sessao.createQuery("select apcdModelo from Aparelho where apcdModelo like :parametro");
            consulta.setString("parametro", modelo);
            return lscid = consulta.list();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
