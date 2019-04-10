package com.comviva.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.configuration.MyConnection;
import com.comviva.exception.SQLInsertException;

@Component
public final class Database {
	
	@Autowired
	private MyConnection myConnection;
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public Database() {
	}
	
	/*
	 * Creates tables if not exists
	 */
	public void initializedTables() {
		try {
			Connection connection = myConnection.getConnection();
			Statement statement;
			statement = connection.createStatement();
			String sqlCreateTableComviva = "CREATE TABLE IF NOT EXISTS comviva (\n" + 
					" FILENAME VARCHAR(256) NOT NULL,\n" + 
					" FILEVALUE FLOAT,\n" + 
					" PROCESSDATE DATETIME NOT NULL,\n" + 
					" PRIMARY KEY(FILENAME, PROCESSDATE)\n" + 
					");";
			statement.execute(sqlCreateTableComviva);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(String path, Double sum, Date date) throws SQLInsertException {
		try {
			Connection connection = myConnection.getConnection();
			String sqlInsertRegister = "INSERT INTO comviva (FILENAME, FILEVALUE, PROCESSDATE)\n" + 
					"VALUES (?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sqlInsertRegister);
			ps.setString(1, path);
			ps.setDouble(2, sum);
			ps.setString(3, dateFormat.format(date));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLInsertException("Error saving register");
		}
	}
	
}
