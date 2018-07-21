package com.met.domaci.dao;

import java.util.List;

import com.met.domaci.entities.PrijavaIspita;
import com.met.domaci.entities.Student;
import com.met.domaci.entities.TerminIspita;

public interface PrijavaIspitaDAO {
	public void prijaviIspit(PrijavaIspita prijavaIspita);
	public List<PrijavaIspita> listaPrijavljenihIspitaZaStudenta(Student student);
	public boolean proveriPrijavuZaStudenta(TerminIspita termin, Student student);
	public PrijavaIspita getPrijavaIspitaById(int id);
	public void odjaviIspit(PrijavaIspita prijavaIspita);
}
