package com.comviva.dataBase;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.configuration.PropertiesWithJavaConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Component
public class C3poDataSource {
	
//	private C3poDataSource instance;
	
    private ComboPooledDataSource cpds = new ComboPooledDataSource();
 
    @Autowired
	private PropertiesWithJavaConfig properties;

	private C3poDataSource() {
		
	};
	
//	public C3poDataSource getInstance() {
//		if (instance == null) {
//			synchronized (cpds) {
//				if (instance == null) {
//					instance = new C3poDataSource();
//				}
//			}
//		}
//		return instance;
//	}
	
    @PostConstruct
    public void initialized() {
        try {
        	cpds.setMaxPoolSize(properties.getJdbcMaxConnection());
        	cpds.setMaxIdleTime(properties.getJdbcMaxIdleTime());
        	cpds.setDriverClass(properties.getJdbcDriver());
        	cpds.setJdbcUrl(properties.getJdbcUrl());
        	cpds.setUser(properties.getJdbcUserName());
        	cpds.setPassword(properties.getJdbcPassword());
        } catch (PropertyVetoException e) {
            // handle the exception
        }
    }
     
    public Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }
    
}
