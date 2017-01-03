/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Type;

/**
 *
 * @author HJ-Sistemas
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_id")
    private int pes_id;
    @Column(name = "pes_nome", length = 60, nullable = true)
    private String pes_nome;
    @Column(name = "pes_cpf", length = 14, nullable = true)
    private String pes_cpf;
    @Column(name = "pes_rg", length = 20, nullable = true)
    private String pes_rg;
    @Column(name = "pes_rua", length = 60, nullable = true)
    private String pes_rua;
    @Column(name = "pes_bairro", length = 30, nullable = true)
    private String pes_bairro;
    @Column(name = "pes_cep", length = 20, nullable = true)
    private String pes_cep;
    @Column(name = "pes_email", length = 40, nullable = true)
    private String pes_email;
    @Column(name = "pes_data_nasc")
    @Temporal(TemporalType.DATE)
    private Date pesDataNasc;
    @Column(name = "pes_quadra")
    private String pes_quadra;
    @Column(name = "pes_lote")
    private String pes_lote;

    public int getPes_id() {
        return pes_id;
    }

    public void setPes_id(int pes_id) {
        this.pes_id = pes_id;
    }

    public String getPes_nome() {
        return pes_nome;
    }

    public void setPes_nome(String pes_nome) {
        this.pes_nome = pes_nome;
    }

    public String getPes_cpf() {
        return pes_cpf;
    }

    public void setPes_cpf(String pes_cpf) {
        this.pes_cpf = pes_cpf;
    }

    public String getPes_rg() {
        return pes_rg;
    }

    public void setPes_rg(String pes_rg) {
        this.pes_rg = pes_rg;
    }

    public String getPes_rua() {
        return pes_rua;
    }

    public void setPes_rua(String pes_rua) {
        this.pes_rua = pes_rua;
    }

    public String getPes_bairro() {
        return pes_bairro;
    }

    public void setPes_bairro(String pes_bairro) {
        this.pes_bairro = pes_bairro;
    }

    public String getPes_cep() {
        return pes_cep;
    }

    public void setPes_cep(String pes_cep) {
        this.pes_cep = pes_cep;
    }

    public String getPes_email() {
        return pes_email;
    }

    public void setPes_email(String pes_email) {
        this.pes_email = pes_email;
    }

    public Pessoa() {
    }

    public Date getPesDataNasc() {
        return pesDataNasc;
    }

    public void setPesDataNasc(Date pesDataNasc) {
        this.pesDataNasc = pesDataNasc;
    }

    public String getPes_quadra() {
        return pes_quadra;
    }

    public void setPes_quadra(String pes_quadra) {
        this.pes_quadra = pes_quadra;
    }

    public String getPes_lote() {
        return pes_lote;
    }

    public void setPes_lote(String pes_lote) {
        this.pes_lote = pes_lote;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "cid_id", nullable = true)
    private Cidade cid;

    public Cidade getCid() {
        return cid;
    }

    public void setCid(Cidade cid) {
        this.cid = cid;
    }

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Fone> fones = new ArrayList<Fone>();

    public List<Fone> getFones() {
        return fones;
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }
}
