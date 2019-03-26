package br.com.developeracademy.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.developeracademy.util.ConnectionFactory;

public class AlunoDAO extends ConnectionFactory {

	public void delete(Aluno aluno) {
		Connection conexao = null;
		PreparedStatement psDelete = null;
		String sql = "DELETE FROM aluno WHERE id = ?";
		
		try {
			conexao = open();
			psDelete = conexao.prepareStatement(sql);
			psDelete.setLong(1, aluno.getId());
			psDelete.executeUpdate();
		}catch(Exception e) {
			System.err.println("-------------------------------------");
			System.err.println("Erro no delete: " + e.getMessage());
			e.printStackTrace();
		}finally {
			close(null, psDelete, conexao);
		}
	}
	
	public List<Aluno> selectAll(){
		Connection conexao = null;
		PreparedStatement psSelect = null;
		ResultSet rsSelect = null;
		String sql = "SELECT id, nome, idade, genero FROM aluno ORDER BY nome";
		List<Aluno> lsAlunos = null;
		try {
			conexao = open();
			psSelect = conexao.prepareStatement(sql);
			rsSelect = psSelect.executeQuery();
			lsAlunos = new ArrayList<Aluno>();
			while (rsSelect.next()) {
				Aluno a = new Aluno();
				a.setId(rsSelect.getLong("id"));
				a.setNome(rsSelect.getString("nome"));
				a.setIdade(rsSelect.getInt("idade"));
				a.setGenero(rsSelect.getString("genero"));
				lsAlunos.add(a);
			}
		}catch(Exception e) {
			System.err.println("-------------------------------------");
			System.err.println("Erro no insert: " + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rsSelect, psSelect, conexao);
		}
		return lsAlunos;
	}
	
	public void update(Aluno aluno) {
		Connection conexao = null;
		PreparedStatement psUpdate = null;
		String sql = "UPDATE aluno SET nome = ? WHERE id = ?";
		
		try {
			conexao = open();
			psUpdate = conexao.prepareStatement(sql);
			psUpdate.setString(1, aluno.getNome());
			psUpdate.setLong(2, aluno.getId());
			psUpdate.executeUpdate();
		}catch(Exception e) {
			System.err.println("-------------------------------------");
			System.err.println("Erro no insert: " + e.getMessage());
			e.printStackTrace();
		}finally {
			close(null, psUpdate, conexao);
		}
	}
	
	public void insert(Aluno aluno) {
		Connection conexao = null;
		PreparedStatement psInsert = null;
		String sql = "INSERT INTO aluno (nome, idade, genero) VALUES (?, ?, ?) ";
		
		try {
			conexao = open();
			psInsert = conexao.prepareStatement(sql);
			psInsert.setString(1, aluno.getNome());
			psInsert.setInt(2, aluno.getIdade());
			psInsert.setString(3, aluno.getGenero());
			psInsert.executeUpdate();
		}catch(Exception e) {
			System.err.println("-------------------------------------");
			System.err.println("Erro no insert: " + e.getMessage());
			e.printStackTrace();
		}finally {
			close(null, psInsert, conexao);
		}
	}
}
