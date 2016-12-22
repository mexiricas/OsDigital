/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.dao;

import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
            Criteria consulta = sessao.createCriteria(Usuario.class);
            //na tabela usuário deve constar os campos login e senha.
            consulta.add(Restrictions.eq("usrs_login", usuario));
            consulta.add(Restrictions.eq("usrs_senha", senha));
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
