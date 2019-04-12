package com.comviva.configuration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesWithJavaConfigTest {
	
	@Autowired
	PropertiesWithJavaConfig properties;
	
	@Test
	public void getRightUserNameParameterTest() {
		assertEquals("root", properties.getJdbcUserName());
	}
	@Test
	public void getRightPasswordParameterTest() {
		assertEquals("password", properties.getJdbcPassword());
	}
	@Test
	public void getRightMaxConnectionParameterTest() {
		assertEquals(10, properties.getJdbcMaxConnection());
	}
	@Test
	public void getRightMaxIdleTimeParameterTest() {
		assertEquals(1800, properties.getJdbcMaxIdleTime());
	}
}
