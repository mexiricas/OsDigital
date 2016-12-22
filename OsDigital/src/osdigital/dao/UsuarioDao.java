/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.dao;

import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;
import osdigital.model.Usuario;

/**
 *
 * @author HJ-Sistemas
 */
public class UsuarioDao implements Serializable {

    private static final long serialVersionUID = 1L;

    public Usuario pesqUsuario(String usuario, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Query consulta = sessao.createQuery("from Usuario where usrs_login = :parametro");
            consulta.setString("parametro", usuario);
            if (consulta.list().size() == 0) {
                return null;
            } else {
                return (Usuario) consulta.uniqueResult();
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
}
