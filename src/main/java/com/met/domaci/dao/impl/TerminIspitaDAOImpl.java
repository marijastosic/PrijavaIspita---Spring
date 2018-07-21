package com.met.domaci.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.met.domaci.dao.TerminIspitaDAO;
import com.met.domaci.entities.TerminIspita;

@Repository
@Transactional
public class TerminIspitaDAOImpl implements TerminIspitaDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TerminIspita> getListaSvihTermina() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(TerminIspita.class).list();
	}

	@Override
	public TerminIspita getTerminIspitaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (TerminIspita) session.createCriteria(TerminIspita.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
