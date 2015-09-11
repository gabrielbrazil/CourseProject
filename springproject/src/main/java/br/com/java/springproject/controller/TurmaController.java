package br.com.java.springproject.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.codehouse.dao.ProfessorDAO;
import br.com.java.codehouse.dao.TurmaDAO;
import br.com.java.springproject.models.Professor;
import br.com.java.springproject.models.Turma;

@Controller
@Transactional
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaDAO dao;
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@RequestMapping("/salvar")
	public ModelAndView salvar(Turma turma,RedirectAttributes redirectAttribute){
		System.out.println(turma.getCodigo());
		dao.salvar(turma);
		redirectAttribute.addFlashAttribute("sucesso","sucesso");
		return new ModelAndView("redirect:new");
	}
	
	@RequestMapping("/new")
	public ModelAndView novo(ModelMap model,Turma turma){
		List<Professor> professores = professorDAO.buscaTodos();
		turma.setCodigo(turma.geraCodigo());
		
		model.addAttribute("turma",turma);
		model.addAttribute("professores",professores);
		return new ModelAndView("turma/new");
	}
	
}
