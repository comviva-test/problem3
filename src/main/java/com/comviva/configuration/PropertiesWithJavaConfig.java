package com.comviva.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesWithJavaConfig {
    
	@Value( "${db.host}" )
	private String jdbcHost;
	@Value( "${db.port}" )
	private String jdbcPort;
	@Value( "${db.database}" )
	private String jdbcDB;
	@Value( "${db.username}" )
	private String jdbcUserName;
	@Value( "${db.password}" )
	private String jdbcPassword;
	@Value( "${db.url}" )
	private String jdbcUrl;
	@Value( "${db.driver}" )
	private String jdbcDriver;
	@Value( "${db.maxConnection}" )
	private int jdbcMaxConnection;
	@Value( "${db.maxIdleTime}" )
	private int jdbcMaxIdleTime;
	public String getJdbcHost() {
		return jdbcHost;
	}
	public void setJdbcHost(String jdbcHost) {
		this.jdbcHost = jdbcHost;
	}
	public int getJdbcMaxIdleTime() {
		return jdbcMaxIdleTime;
	}
	public void setJdbcMaxIdleTime(int jdbcMaxIdleTime) {
		this.jdbcMaxIdleTime = jdbcMaxIdleTime;
	}
	public String getJdbcPort() {
		return jdbcPort;
	}
	public String getJdbcDB() {
		return jdbcDB;
	}
	public String getJdbcUserName() {
		return jdbcUserName;
	}
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	public int getJdbcMaxConnection() {
		return jdbcMaxConnection;
	}
	public void setJdbcPort(String jdbcPort) {
		this.jdbcPort = jdbcPort;
	}
	public void setJdbcDB(String jdbcDB) {
		this.jdbcDB = jdbcDB;
	}
	public void setJdbcUserName(String jdbcUserName) {
		this.jdbcUserName = jdbcUserName;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public void setJdbcMaxConnection(int jdbcMaxConnection) {
		this.jdbcMaxConnection = jdbcMaxConnection;
	}
	
}
