/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HJ-Sistemas
 */
@Entity
@Table(name = "estados")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int est_id;
    @Column(name = "nome", length = 120, nullable = true)
    private String est_nome;
    @Column(name = "sigla", length = 120, nullable = true)
    private String est_sigla;

    public String getEst_nome() {
        return est_nome;
    }

    public void setEst_nome(String est_nome) {
        this.est_nome = est_nome;
    }

    public int getEst_id() {
        return est_id;
    }

    public void setEst_id(int est_id) {
        this.est_id = est_id;
    }

    public String getEst_sigla() {
        return est_sigla;
    }

    public void setEst_sigla(String est_sigla) {
        this.est_sigla = est_sigla;
    }

    @Override
    public String toString() {
        return est_sigla;
    }

}
