package br.com.java.springproject.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.codehouse.dao.PersonDAO;
import br.com.java.springproject.models.Pessoa;

@Controller
@Transactional
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonDAO personDAO;
	
	
	@RequestMapping("/new")
	public String novo(Pessoa person){
		return "person/new";
	}
	
	
	@RequestMapping("/save")
	public String salvar(@Valid Pessoa person,BindingResult result,RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return novo(person);
		}
	   personDAO.salvar(person);
	   redirectAttributes.addFlashAttribute("sucesso","sucesso");
		return "redirect:new";
	}
	
}
