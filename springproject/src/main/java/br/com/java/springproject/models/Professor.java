package br.com.java.springproject.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nome")
	private String nome;
	@Column(name="titulo")
	private String titulo;
	@ManyToMany
	@JoinTable(name="professores_alunos",
	joinColumns={  @JoinColumn(name="professor_id")
	},inverseJoinColumns={ @JoinColumn(name="aluno_id")
	})
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
	private List<Turma> turma;
	
	
	public Professor() {}


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


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}


	public List<Turma> getTurma() {
		return turma;
	}


	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}


	

	
	
}
