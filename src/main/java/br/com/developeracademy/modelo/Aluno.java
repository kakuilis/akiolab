package br.com.developeracademy.modelo;

import java.io.Serializable;

public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private int idade;
	private String genero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
