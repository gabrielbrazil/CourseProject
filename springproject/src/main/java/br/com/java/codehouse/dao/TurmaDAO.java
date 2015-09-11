package br.com.java.codehouse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.java.springproject.models.Turma;


@Repository
public class TurmaDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	
	public void salvar(Turma turma){
		entityManager.persist(turma);
	}

}
