package com.met.domaci.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prijava_ispita")
public class PrijavaIspita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@JoinColumn(name = "termin_ispita_id", referencedColumnName = "id")
	@ManyToOne
	private TerminIspita terminIspitaId;

	@JoinColumn(name = "student_id", referencedColumnName = "id")
	@ManyToOne
	private Student studentId;

	public PrijavaIspita() {
		super();
	}

	public PrijavaIspita(TerminIspita terminIspitaId, Student studentId) {
		super();
		this.terminIspitaId = terminIspitaId;
		this.studentId = studentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TerminIspita getTerminIspitaId() {
		return terminIspitaId;
	}

	public void setTerminIspitaId(TerminIspita terminIspitaId) {
		this.terminIspitaId = terminIspitaId;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "PrijavaIspita [id=" + id + ", terminIspitaId=" + terminIspitaId + ", studentId=" + studentId + "]";
	}

}
