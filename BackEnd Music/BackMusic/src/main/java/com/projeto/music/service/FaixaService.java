package com.projeto.music.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.music.datasource.ConnectionFactory;
import com.projeto.music.datasource.TableFactory;
import com.projeto.music.model.Faixa;

public class FaixaService {

	Connection connection = null;
	PreparedStatement preparedSQL = null;
	Statement sql = null;
	ResultSet result = null;

	public List<Faixa> getFaixas() {
		List<Faixa> faixas = new ArrayList<Faixa>();
		try {
			connection = new ConnectionFactory().getConnection();
			sql = connection.createStatement();
			result = sql.executeQuery("select * from faixas");

			while (result.next()) {
				Faixa faixa = new Faixa();
				faixa.setId(result.getInt("id"));
				faixa.setNome(result.getString("nome"));
				faixa.setDuracao(result.getInt("duracao"));
				faixa.setCodigoAlbum(result.getInt("id_album"));
				String nomeAlbum = getNomeAlbum(result.getInt("id"));
				faixa.setNomeAlbum(nomeAlbum);
				faixa.setOrdem(result.getInt("ordem"));
				faixas.add(faixa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}

		return faixas;
	}

	public void createFaixa(Faixa faixa) {
		int id = new TableFactory().GetMax("faixas");
		try {
			connection = new ConnectionFactory().getConnection();
			preparedSQL = connection.prepareStatement(
					"INSERT INTO faixas (id,nome,duracao,id_album,ordem) " + "VALUES " + "(?,?,?,?,?)");
			preparedSQL.setInt(1, id);
			preparedSQL.setString(2, faixa.getNome());
			preparedSQL.setInt(3, faixa.getDuracao());
			preparedSQL.setInt(4, faixa.getCodigoAlbum());
			preparedSQL.setInt(5, faixa.getOrdem());

			preparedSQL.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public void updateFaixa(Faixa faixa, int id) {
		try {
			connection = new ConnectionFactory().getConnection();
			preparedSQL = connection.prepareStatement("update faixas " + "set nome = ?, " + "duracao = ?, "
					+ "id_album = ?, " + "ordem = ? " + "where id = ?");
			preparedSQL.setString(1, faixa.getNome());
			preparedSQL.setInt(2, faixa.getDuracao());
			preparedSQL.setInt(3, faixa.getCodigoAlbum());
			preparedSQL.setInt(4, faixa.getOrdem());
			preparedSQL.setInt(5, id);

			preparedSQL.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public void deleteFaixa(int id) {
		try {
			connection = new ConnectionFactory().getConnection();
			sql = connection.createStatement();
			sql.executeUpdate("delete from faixas " + "where id = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public String getNomeAlbum(int id) {
		return "filipe";
	}

}
