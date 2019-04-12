package com.comviva.configuration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comviva.dataBase.C3poDataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class C3poDataSourceTest {
	
	@Autowired
	private C3poDataSource c3poDataSource;
	
	@Test
	public void poolIsNotNullTest() throws SQLException {
		assertNotNull(c3poDataSource);
	}
	
	@Test
	public void getAConnectionFromPoolConnectionIsOK() throws SQLException {
		assertNotNull(c3poDataSource.getConnection());
	}

}
