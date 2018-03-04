package com.projeto.music.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableFactory {

	public int GetMax(String tabela) {

		Connection connection = null;
		Statement sql = null;
		ResultSet result = null;
		int count = 1;

		connection = new ConnectionFactory().getConnection();
		try {
			sql = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = sql.executeQuery("select * from " + tabela);
			while(result.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new ConnectionFactory().close(connection, sql, result);
		}

		return count;

	}

}
