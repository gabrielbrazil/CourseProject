package br.com.java.springproject.models;

import java.util.Calendar;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="codigo")
	private String codigo;
	@Column(name="sala")
	private String sala;
	@DateTimeFormat
	private Calendar horario;
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	
	public Turma() {}


	
	
	public String geraCodigo(){
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();
		StringBuilder codigoAleatorio = new StringBuilder();
		for (int i = 0; i < 3; i++) {
		 codigoAleatorio.append( random.nextInt(10));
		}
		Integer anoAtual = calendar.get(Calendar.YEAR);
		String codigo = codigoAleatorio.toString()+"-"+anoAtual.toString();
		return codigo;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}




	public Calendar getHorario() {
		return horario;
	}




	public void setHorario(Calendar horario) {
		this.horario = horario;
	}




	public Professor getProfessor() {
		return professor;
	}




	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	



	
	
	
	
}
