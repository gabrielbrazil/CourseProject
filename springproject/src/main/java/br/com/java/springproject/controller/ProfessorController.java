package br.com.java.springproject.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.codehouse.dao.ProfessorDAO;
import br.com.java.springproject.models.Professor;

@Controller
@Transactional
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorDAO professorDAO;
	
	
	@RequestMapping("/novo")
	public String novo(Professor professor){
	return "professor/new";	
	}
	
	@RequestMapping("/salvar")
	public String salvar(Professor professor,RedirectAttributes redirectAttributes){
		professorDAO.salvar(professor);
		redirectAttributes.addFlashAttribute("sucesso","sucesso");
		return "redirect:novo";
	}
	
}
