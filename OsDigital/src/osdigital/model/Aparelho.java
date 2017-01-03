/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HJ-Sistemas
 */
@Entity
@Table(name = "aparelho")
public class Aparelho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "apcd_id")
    private Integer apcdId;
    @Column(name = "apcd_marca")
    private String apcdMarca;
    @Column(name = "apcd_modelo")
    private String apcdModelo;

    public Aparelho() {
    }

    public Aparelho(Integer apcdId) {
        this.apcdId = apcdId;
    }

    public Integer getApcdId() {
        return apcdId;
    }

    public void setApcdId(Integer apcdId) {
        this.apcdId = apcdId;
    }

    public String getApcdMarca() {
        return apcdMarca;
    }

    public void setApcdMarca(String apcdMarca) {
        this.apcdMarca = apcdMarca;
    }

    public String getApcdModelo() {
        return apcdModelo;
    }

    public void setApcdModelo(String apcdModelo) {
        this.apcdModelo = apcdModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apcdId != null ? apcdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aparelho)) {
            return false;
        }
        Aparelho other = (Aparelho) object;
        if ((this.apcdId == null && other.apcdId != null) || (this.apcdId != null && !this.apcdId.equals(other.apcdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  apcdMarca ;
    }


    
}
