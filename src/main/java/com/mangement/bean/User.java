package com.mangement.bean;

public class User {

	public Integer id;
	public String nome;
	public Integer idade;
	public String matricula;
	
	public User() {
		
	}
	
	public User(String nome, Integer idade, String matricula) {
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
	}
	
	public User(Integer id, String nome, Integer idade, String matricula) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
	}
	
	
	public int getId() {
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
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
	
}
