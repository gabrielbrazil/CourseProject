package br.com.java.springproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Endereco {

	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator",strategy="foreign",
	      parameters=@Parameter(name="property",value="pessoa"))
	private Integer id;
	@NotBlank
	@Column(name="street")
	private String street;
	@NotBlank
	@Column(name="cep")
	private String cep;
	@Valid
	@OneToOne
	@PrimaryKeyJoinColumn(name="id")
	private Pessoa pessoa;
	
	public Endereco() {}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
}
