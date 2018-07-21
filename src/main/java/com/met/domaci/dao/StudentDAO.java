package com.met.domaci.dao;

import java.util.List;
import com.met.domaci.entities.Student;

public interface StudentDAO {
	public List<Student> getListaSvihStudenata();
	public void dodajStudenta(Student student);
	public Student getStudentByEmail(String email);
	public Student getStudentByUsername(String username);
	
}
