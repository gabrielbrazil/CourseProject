package br.com.java.springproject.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Aluno {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer matricula;
	
	@ManyToMany
	@JoinTable(name="professores_alunos",
	joinColumns={  @JoinColumn(name="professor_id")
	},inverseJoinColumns={ @JoinColumn(name="aluno_id")
	})
	private List<Professor> professores = new ArrayList<Professor>();
	
	public Aluno() {}

	
	
	public Integer geraMatricula(){
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();
		StringBuilder codigoAleatorio = new StringBuilder();
		for (int i = 0; i < 4; i++) {
		 codigoAleatorio.append( random.nextInt(10));
		}
		Integer anoAtual = calendar.get(Calendar.YEAR);
		String codigo = codigoAleatorio+anoAtual.toString();
		Integer matricula = new Integer(codigo);
		return matricula;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}



	public List<Professor> getProfessores() {
		return professores;
	}



	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	
	
	
	
	
}
