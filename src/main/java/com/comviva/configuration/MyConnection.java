package com.comviva.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.constant.ApplicationContext;
import com.comviva.constant.PropertiesConstants;

@Component
public class MyConnection {
	
	private static Connection connection = null;
	@Autowired
	private ApplicationContext applicationContext;
	
	@SuppressWarnings("finally")
	public Connection getConnection() {
		try {
			if (connection == null) {
				synchronized (applicationContext) {
					if (connection == null) {
						Class.forName(applicationContext.getProperty(PropertiesConstants.DB_DRIVER));
						connection = (Connection) DriverManager.getConnection(applicationContext.getProperty(PropertiesConstants.DB_URL),
								applicationContext.getProperty(PropertiesConstants.DB_USERNAME), 
								applicationContext.getProperty(PropertiesConstants.DB_PASSWORD));
						if (connection != null) {
							System.out.println("Connection successful !!!");
						} else {
							System.out.println("Failed to make connection!!!");
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("MySQL Connection Failed!!!");
		} finally {
			return connection;
		}
		
	}

}
