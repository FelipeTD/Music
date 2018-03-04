package com.projeto.music.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.music.datasource.ConnectionFactory;
import com.projeto.music.datasource.TableFactory;
import com.projeto.music.model.Album;

public class AlbumService {

	Connection connection = null;
	PreparedStatement preparedSQL = null;
	Statement sql = null;
	ResultSet result = null;

	public List<Album> getAlbuns() {
		List<Album> albuns = new ArrayList<Album>();
		try {
			connection = new ConnectionFactory().getConnection();
			sql = connection.createStatement();
			result = sql.executeQuery("select * from albuns");

			while (result.next()) {
				Album album = new Album();
				album.setId(result.getInt("id"));
				album.setNome(result.getString("nome"));
				album.setAnoLancamento(result.getInt("ano_lancamento"));
				album.setArtista(result.getString("artista"));
				albuns.add(album);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}

		return albuns;
	}

	public void createAlbum(Album album) {
		int id = new TableFactory().GetMax("albuns");
		try {
			connection = new ConnectionFactory().getConnection();
			preparedSQL = connection
					.prepareStatement("INSERT INTO albuns (id,nome,ano_lancamento,artista) " + "VALUES " + "(?,?,?,?)");
			preparedSQL.setInt(1, id);
			preparedSQL.setString(2, album.getNome());
			preparedSQL.setInt(3, album.getAnoLancamento());
			preparedSQL.setString(4, album.getArtista());

			preparedSQL.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public void updateAlbum(Album album, int id) {
		try {
			connection = new ConnectionFactory().getConnection();
			preparedSQL = connection.prepareStatement(
					"update albuns " + "set nome = ?, " + "ano_lancamento = ?, " + "artista = ? " + "where id = ?");
			preparedSQL.setString(1, album.getNome());
			preparedSQL.setInt(2, album.getAnoLancamento());
			preparedSQL.setString(3, album.getArtista());
			preparedSQL.setInt(4, id);

			preparedSQL.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

	public void deleteAlbum(int id) {
		try {
			connection = new ConnectionFactory().getConnection();
			sql = connection.createStatement();
			sql.executeUpdate("delete from albuns " + "where id = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}
	}

}
