package br.com.java.codehouse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.com.java.springproject.models.Pessoa;


@Repository
public class PersonDAO {

	
	@PersistenceContext
	EntityManager entityManager;
	
	public void salvar(Pessoa pessoa){
		pessoa.getEndereco().setPessoa(pessoa);
		entityManager.persist(pessoa);
	}
	
}
