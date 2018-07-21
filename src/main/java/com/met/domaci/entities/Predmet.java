/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.met.domaci.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marija
 */
@Entity
@Table(name = "predmet")
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "espb")
    private String espb;
    @OneToMany(mappedBy = "predmetId")
    private List<TerminIspita> terminIspitaList;
    
   

    public Predmet() {
    }

    public Predmet(Integer id) {
        this.id = id;
    }

    public Predmet(Integer id, String naziv, String opis, String espb) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.espb = espb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getEspb() {
        return espb;
    }

    public void setEspb(String espb) {
        this.espb = espb;
    }

    public List<TerminIspita> getTerminIspitaList() {
		return terminIspitaList;
	}

	public void setTerminIspitaList(List<TerminIspita> terminIspitaList) {
		this.terminIspitaList = terminIspitaList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pica{" + "id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", espb=" + espb +'}';
    }

}
