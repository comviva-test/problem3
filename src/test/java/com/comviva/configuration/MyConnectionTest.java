package com.comviva.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyConnectionTest {

	@Autowired
	private MyConnection myConnection;
	
	@Test
	public void connectionIsNotEmptyTest() {
		assertNotNull(myConnection.getConnection());
	}
}
