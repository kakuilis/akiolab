package br.com.developeracademy.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.developeracademy.controller.AlunoController;
import br.com.developeracademy.modelo.Aluno;

@ManagedBean (name = "mbAluno")

public class MBAluno implements Serializable{

	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	
	public List<Aluno> getAlunos(){
		return new AlunoController().listarTodos();
	}
	
	public String actionApagar() {
		new AlunoController().deletar(aluno);
		return "index";
	}
	
	public String actionNovo() {
		this.aluno = new Aluno();
		return "formulario_aluno";
	}
	public String actionAlterar() {
		return "formulario_aluno";
	}
	
	public String actionGravar() {
		new AlunoController().gravar(this.aluno);
		return "index";
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
