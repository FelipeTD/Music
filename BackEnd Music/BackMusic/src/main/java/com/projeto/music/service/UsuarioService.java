package com.projeto.music.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.music.datasource.ConnectionFactory;
import com.projeto.music.datasource.TableFactory;
import com.projeto.music.model.Usuario;

public class UsuarioService {

	Connection connection = null;
	PreparedStatement preparedSQL = null;
	Statement sql = null;
	ResultSet result = null;

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			connection = new ConnectionFactory().getConnection();
			sql = connection.createStatement();
			result = sql.executeQuery("select * from usuarios");

			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				Date data = result.getDate("data_nascimento");
				usuario.setDataNascimento(new java.sql.Date(data.getTime()).toLocalDate());
				usuario.setSexo(result.getString("sexo"));
				usuario.setUsuario(result.getString("usuario"));
				usuario.setSenha(result.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}

		return usuarios;
	}

	public void createUsuario(Usuario usuario) {
		int id = new TableFactory().GetMax("usuarios");
		try {
			connection = new ConnectionFactory().getConnection();
			preparedSQL = connection
					.prepareStatement("INSERT INTO usuarios (id,nome,data_nascimento,sexo, usuario, senha) " + "VALUES "
							+ "(?,?,?,?,?,?)");
			preparedSQL.setInt(1, id);
			preparedSQL.setString(2, usuario.getNome());
			Date date = Date.valueOf(usuario.getDataNascimento());
			preparedSQL.setDate(3, date);
			preparedSQL.setString(4, usuario.getSexo());
			preparedSQL.setString(5, usuario.getUsuario());
			preparedSQL.setString(6, usuario.getSenha());

			preparedSQL.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public void updateUsuario(Usuario usuario, int id) {
		try {
			connection = new ConnectionFactory().getConnection();
			preparedSQL = connection.prepareStatement("update usuarios " + "set nome = ?, " + "data_nascimento = ?, "
					+ "sexo = ?, " + "usuario = ?, " + "senha = ? " + "where id = ?");
			preparedSQL.setString(1, usuario.getNome());
			Date date = Date.valueOf(usuario.getDataNascimento());
			preparedSQL.setDate(2, date);
			preparedSQL.setString(3, usuario.getSexo());
			preparedSQL.setString(4, usuario.getUsuario());
			preparedSQL.setString(5, usuario.getSenha());
			preparedSQL.setInt(6, id);

			preparedSQL.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public void deleteUsuario(int id) {
		try {
			connection = new ConnectionFactory().getConnection();
			sql = connection.createStatement();
			sql.executeUpdate("delete from usuarios " + "where id = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

}
