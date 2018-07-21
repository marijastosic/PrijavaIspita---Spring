package com.met.domaci.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.met.domaci.dao.PrijavaIspitaDAO;
import com.met.domaci.entities.PrijavaIspita;
import com.met.domaci.entities.Student;
import com.met.domaci.entities.TerminIspita;

@Repository
@Transactional

public class PrijavaIspitaDAOImpl implements PrijavaIspitaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void prijaviIspit(PrijavaIspita prijavaIspita) {
		Session session = sessionFactory.getCurrentSession();
		session.save(prijavaIspita);
		session.flush();
	}

	@Override
	public List<PrijavaIspita> listaPrijavljenihIspitaZaStudenta(Student student) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(PrijavaIspita.class).add(Restrictions.eq("studentId", student)).list();
	}

	@Override
	public boolean proveriPrijavuZaStudenta(TerminIspita termin, Student student) {
		Session session = sessionFactory.getCurrentSession();
		PrijavaIspita prijava = (PrijavaIspita)session.createCriteria(PrijavaIspita.class)
				.add(Restrictions.eq("terminIspitaId", termin))
				.add(Restrictions.eq("studentId", student)).uniqueResult();
		
		if(prijava != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public PrijavaIspita getPrijavaIspitaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (PrijavaIspita)session.createCriteria(PrijavaIspita.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public void odjaviIspit(PrijavaIspita prijavaIspita) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(prijavaIspita);
		session.flush();
	}

}
