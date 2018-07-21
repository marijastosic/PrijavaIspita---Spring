package com.met.domaci.dao;

import java.util.List;

import com.met.domaci.entities.TerminIspita;

public interface TerminIspitaDAO {
	public List<TerminIspita> getListaSvihTermina();

	public TerminIspita getTerminIspitaById(int id);
}
