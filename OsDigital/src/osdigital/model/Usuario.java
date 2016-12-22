/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author HJ-Sistemas
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usrs_id")
    int usrs_id;
    @Column(name = "pes_id")
    int pes_id;
    @Column(name = "usrs_nome", length = 250, nullable = true)
    String usrs_nome;
    @Column(name = "usrs_login", length = 250, nullable = true)
    String usrs_login;
    @Column(name = "usrs_senha", length = 250, nullable = true)
    String usrs_senha;
    @Column(name = "usrs_nivel", length = 250, nullable = true)
    String usrs_nivel;

    public int getUsrs_id() {
        return usrs_id;
    }

    public void setUsrs_id(int usrs_id) {
        this.usrs_id = usrs_id;
    }

    public int getPes_id() {
        return pes_id;
    }

    public void setPes_id(int pes_id) {
        this.pes_id = pes_id;
    }

    public String getUsrs_nome() {
        return usrs_nome;
    }

    public void setUsrs_nome(String usrs_nome) {
        this.usrs_nome = usrs_nome;
    }

    public String getUsrs_login() {
        return usrs_login;
    }

    public void setUsrs_login(String usrs_login) {
        this.usrs_login = usrs_login;
    }

    public String getUsrs_senha() {
        return usrs_senha;
    }

    public void setUsrs_senha(String usrs_senha) {
        this.usrs_senha = usrs_senha;
    }

    public String getUsrs_nivel() {
        return usrs_nivel;
    }

    public void setUsrs_nivel(String usrs_nivel) {
        this.usrs_nivel = usrs_nivel;
    }



}
