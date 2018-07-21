package com.met.domaci.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.met.domaci.dao.StudentDAO;
import com.met.domaci.entities.Student;
import com.met.domaci.entities.UserRoles;
import com.met.domaci.entities.Users;

@Repository
@Transactional

public class StudentDAOImpl  implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Student getStudentByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		return (Student)session.createCriteria(Student.class).add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public Student getStudentByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		return (Student)session.createCriteria(Student.class).add(Restrictions.eq("username", username)).uniqueResult();
	}

	@Override
	public List<Student> getListaSvihStudenata() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Student.class).list();
	}

	@Override
	public void dodajStudenta(Student student) {
		Session session = sessionFactory.getCurrentSession();
		int studentId = (Integer)session.save(student);
		session.flush();
		
		Users user = new Users();
		user.setStudentId(studentId);
		user.setUsername(student.getUsername());
		user.setPassword(student.getPassword());
		user.setEnabled(true);
		
		session.save(user);
		session.flush();
		
		UserRoles userRole = new UserRoles();
		userRole.setUsername(user.getUsername());
		userRole.setRole("ROLE_USER");
		
		session.save(userRole);
		session.flush();
		
	}

}
