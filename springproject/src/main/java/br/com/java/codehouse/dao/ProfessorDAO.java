package br.com.java.codehouse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.java.springproject.models.Professor;

@Repository
public class ProfessorDAO {

	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public void salvar(Professor professor){
		entityManager.persist(professor);
	}
	
	
	public List<Professor> buscaTodos(){
		return entityManager.createQuery("from Professor",Professor.class).getResultList();
		
	}
	
}
