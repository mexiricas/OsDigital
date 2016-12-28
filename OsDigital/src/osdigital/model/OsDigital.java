/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HJ-Sistemas
 */
@Entity
public class OsDigital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "osdg_id")
    int osdg_id;
    @Column(name = "pes_id")
    int pes_id;
    @Column(name = "apcd_id")
    int apcd_id;
    @Column(name = "osdg_obs", length = 500, nullable = true)
    String osdg_obs;
    @Column(name = "osdg_data_entrada")
    @Temporal(TemporalType.DATE)
    Date osdg_data_entrada;
    @Column(name = "osdg_data_saida")
    @Temporal(TemporalType.DATE)
    Date osdg_data_saida;

    public int getOsdg_id() {
        return osdg_id;
    }

    public void setOsdg_id(int osdg_id) {
        this.osdg_id = osdg_id;
    }

    public int getPes_id() {
        return pes_id;
    }

    public void setPes_id(int pes_id) {
        this.pes_id = pes_id;
    }

    public int getApcd_id() {
        return apcd_id;
    }

    public void setApcd_id(int apcd_id) {
        this.apcd_id = apcd_id;
    }

    public String getOsdg_obs() {
        return osdg_obs;
    }

    public void setOsdg_obs(String osdg_obs) {
        this.osdg_obs = osdg_obs;
    }

    public Date getOsdg_data_entrada() {
        return osdg_data_entrada;
    }

    public void setOsdg_data_entrada(Date osdg_data_entrada) {
        this.osdg_data_entrada = osdg_data_entrada;
    }

    public Date getOsdg_data_saida() {
        return osdg_data_saida;
    }

    public void setOsdg_data_saida(Date osdg_data_saida) {
        this.osdg_data_saida = osdg_data_saida;
    }

}
