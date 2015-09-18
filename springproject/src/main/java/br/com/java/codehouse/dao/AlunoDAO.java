package br.com.java.codehouse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.java.springproject.models.Aluno;


@Repository
public class AlunoDAO {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public void salvar(Aluno aluno){
		aluno.getProfessores().get(0).getAlunos().add(aluno);
		aluno.getProfessores().get(1).getAlunos().add(aluno);
		entityManager.persist(aluno);
	}
	
}
