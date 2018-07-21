package com.met.domaci;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.met.domaci.dao.PrijavaIspitaDAO;
import com.met.domaci.dao.StudentDAO;
import com.met.domaci.dao.TerminIspitaDAO;
import com.met.domaci.entities.PrijavaIspita;
import com.met.domaci.entities.Student;
import com.met.domaci.entities.TerminIspita;

@Controller
public class HomeController {
	
	@Autowired
	private TerminIspitaDAO terminIspitaDao;
	
	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private PrijavaIspitaDAO prijavaIspitaDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/oNama", method = RequestMethod.GET)
	public String oNama() {
		return "oNama";
	}

	@RequestMapping(value = "/kontakt", method = RequestMethod.GET)
	public String kontakt() {
		return "kontakt";
	}
	
	@RequestMapping(value = "/prijavaIspita", method = RequestMethod.GET)
	public String prijavaIspita(Model model, HttpServletRequest request) {
		
		
		Student student = studentDao.getStudentByUsername(request.getUserPrincipal().getName());
		List<PrijavaIspita> prijavljeniIspiti = prijavaIspitaDao.listaPrijavljenihIspitaZaStudenta(student);
		model.addAttribute("prijavljeniIspiti", prijavljeniIspiti);
		
		List<TerminIspita> sviIspiti = terminIspitaDao.getListaSvihTermina();
		
		List<TerminIspita> ispiti = new ArrayList<>();
		
		for(TerminIspita termin : sviIspiti) {
			if(!prijavaIspitaDao.proveriPrijavuZaStudenta(termin, student)) {
				ispiti.add(termin);
			}
		}
		
		model.addAttribute("ispiti", ispiti);
		
		
		return "prijavaIspita";
	}
	
	@RequestMapping(value = "/prijavaIspita/{id}", method = RequestMethod.GET)
	public String prijavaIspita(@PathVariable(value="id") int id, Model model, HttpServletRequest request) {
		TerminIspita terminIspita = terminIspitaDao.getTerminIspitaById(id);
		Student student = studentDao.getStudentByUsername(request.getUserPrincipal().getName());
		
		if(!prijavaIspitaDao.proveriPrijavuZaStudenta(terminIspita, student)) {
			PrijavaIspita prijavaIspita = new PrijavaIspita();
			prijavaIspita.setStudentId(student);
			prijavaIspita.setTerminIspitaId(terminIspita);
			
			prijavaIspitaDao.prijaviIspit(prijavaIspita);
		}
		
		List<PrijavaIspita> prijavljeniIspiti = prijavaIspitaDao.listaPrijavljenihIspitaZaStudenta(student);
		model.addAttribute("prijavljeniIspiti", prijavljeniIspiti);
				
		List<TerminIspita> sviIspiti = terminIspitaDao.getListaSvihTermina();
		
		List<TerminIspita> ispiti = new ArrayList<>();
		
		for(TerminIspita termin : sviIspiti) {
			if(!prijavaIspitaDao.proveriPrijavuZaStudenta(termin, student)) {
				ispiti.add(termin);
			}
		}
		
		model.addAttribute("ispiti", ispiti);
		
		return "prijavaIspita";
	}
	
	@RequestMapping(value = "/odjavaIspita/{id}", method = RequestMethod.GET)
	public String odjavaIspita(@PathVariable(value="id") int id, Model model, HttpServletRequest request) {
		PrijavaIspita prijavaIspita = prijavaIspitaDao.getPrijavaIspitaById(id);
		if(prijavaIspita != null) {
			prijavaIspitaDao.odjaviIspit(prijavaIspita);
		}
		
		Student student = studentDao.getStudentByUsername(request.getUserPrincipal().getName());
				
		List<PrijavaIspita> prijavljeniIspiti = prijavaIspitaDao.listaPrijavljenihIspitaZaStudenta(student);
		model.addAttribute("prijavljeniIspiti", prijavljeniIspiti);
				
		List<TerminIspita> sviIspiti = terminIspitaDao.getListaSvihTermina();
		
		List<TerminIspita> ispiti = new ArrayList<>();
		
		for(TerminIspita termin : sviIspiti) {
			if(!prijavaIspitaDao.proveriPrijavuZaStudenta(termin, student)) {
				ispiti.add(termin);
			}
		}
		
		model.addAttribute("ispiti", ispiti);
		
		return "prijavaIspita";
	}

}
