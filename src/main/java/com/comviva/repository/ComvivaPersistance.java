package com.comviva.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.dataBase.C3poDataSource;
import com.comviva.model.Comviva;

@Component
public class ComvivaPersistance {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private C3poDataSource poolConnection;
	
	public ComvivaPersistance() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Comviva> listAll() throws SQLException {
		List<Comviva> records = new ArrayList<>();
		Connection c = poolConnection.getConnection();
		Statement st = null;
		try {
			String query = "SELECT * FROM comviva";
			st = c.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(query);
			
			while (rs.next())
			{
			    String path = rs.getString("FILENAME");
				Double value = rs.getDouble("FILEVALUE");
				String dateString = rs.getString("PROCESSDATE");
				Date date;
				try {
					date = dateFormat.parse(dateString);
				} catch (ParseException e) {
					date = null;
				}
				Comviva record = new Comviva(path, value,date);
				System.out.println(record.toString());
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			 } catch (SQLException e) { /* ignored */}
			try {
				if (c != null)
					c.close();
	        } catch (SQLException e) { /* ignored */}
		}
		return records;
	}
	
	public void save(Comviva record) throws SQLException {
			Connection c = poolConnection.getConnection();
			String sqlInsertRegister = "INSERT INTO comviva (FILENAME, FILEVALUE, PROCESSDATE)\n" + 
					"VALUES (?, ?, ?);";
			PreparedStatement ps = null;
			try {
				ps = c.prepareStatement(sqlInsertRegister);
				ps.setString(1, record.getPath());
				ps.setDouble(2, record.getValue());
				ps.setString(3, dateFormat.format(record.getDateTime()));
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null)
						ps.close();
				 } catch (SQLException e) { /* ignored */}
				try {
		            if (c != null)
		            	c.close();
		        } catch (SQLException e) { /* ignored */}
			}
			
	}
}
