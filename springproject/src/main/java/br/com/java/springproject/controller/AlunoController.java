package br.com.java.springproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.java.codehouse.dao.AlunoDAO;
import br.com.java.codehouse.dao.ProfessorDAO;
import br.com.java.springproject.models.Aluno;
import br.com.java.springproject.models.Professor;


@Controller
@Transactional
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	

	
	
	@RequestMapping("/novo")
	public String novo(Aluno aluno,Model model){
		List<Professor>professores = professorDAO.buscaTodos();
		aluno.setMatricula(aluno.geraMatricula());
		model.addAttribute("aluno",aluno);
		model.addAttribute("professores",professores);
		return "aluno/new";
	}
	
	
	@RequestMapping("/salvar")
	public String salvar(Aluno aluno){
		alunoDAO.salvar(aluno);
		System.out.println(aluno.getProfessores().get(0).getIdAsString());
		return "aluno/new";
	}
	
}
