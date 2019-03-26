package br.com.developeracademy.controller;

import java.util.List;

import br.com.developeracademy.modelo.Aluno;
import br.com.developeracademy.modelo.AlunoDAO;

public class AlunoController {
	
	public void deletar(Aluno aluno) {
		new AlunoDAO().delete(aluno);
	}

	public List<Aluno> listarTodos(){
		return new AlunoDAO().selectAll();
	}
	
	public void gravar(Aluno aluno) {
		if (aluno.getId() == null)
			new AlunoDAO().insert(aluno);
		else
			new AlunoDAO().update(aluno);
	}
}
