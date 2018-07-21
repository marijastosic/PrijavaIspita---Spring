package com.met.domaci.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="termin_ispita")
public class TerminIspita implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 5)
    @Column(name = "vreme")
    private String vreme;
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    @ManyToOne
    private Predmet predmetId;
    @OneToMany(mappedBy = "terminIspitaId")
    private List<PrijavaIspita> prijavaIspitaList;
    
	public TerminIspita() {
		super();
	}
	public TerminIspita(Date datum, String vreme, Predmet predmetId) {
		super();
		this.datum = datum;
		this.vreme = vreme;
		this.predmetId = predmetId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public Predmet getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(Predmet predmetId) {
		this.predmetId = predmetId;
	}
	public List<PrijavaIspita> getPrijavaIspitaList() {
		return prijavaIspitaList;
	}
	public void setPrijavaIspitaList(List<PrijavaIspita> prijavaIspitaList) {
		this.prijavaIspitaList = prijavaIspitaList;
	}
	public String getDatumString() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		return dateFormat.format(datum);
	}
	@Override
	public String toString() {
		return "TerminIspita [id=" + id + ", datum=" + datum + ", vreme=" + vreme + ", predmetId=" + predmetId + "]";
	}
    
    
}
