package com.met.domaci;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.met.domaci.dao.StudentDAO;
import com.met.domaci.entities.Student;

@Controller
public class RegistracijaController {

	@Autowired
	private StudentDAO studentDao;

	@RequestMapping(value = "/registracija", method = RequestMethod.GET)
	public String registracija(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);

		return "registracija";
	}

	@RequestMapping(value = "/registracija", method = RequestMethod.POST)
	public String registracijaPost(@Valid @ModelAttribute("student") Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registracija";
		}

		Student postojeciKorisnikSaEmailom = studentDao.getStudentByEmail(student.getEmail());
		Student postojeciKorisnikSaUsername = studentDao.getStudentByUsername(student.getUsername());

		if (postojeciKorisnikSaEmailom != null) {
			model.addAttribute("error", "Postoji korisnik sa unetim email-om!");
			return "registracija";
		}

		if (postojeciKorisnikSaUsername != null) {
			model.addAttribute("error", "Postoji korisnik sa unetim username-om!");
			return "registracija";
		}

		studentDao.dodajStudenta(student);

		model.addAttribute("msg", "Uspešno ste izvršili registraciju. Molimo Vas da se ulogujete:");
		model.addAttribute("username", student.getUsername());
		return "login";
	}

}
