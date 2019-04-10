package com.comviva.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationPropertiesTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void applicationPropetiesIsNotNullTest( ) {
		assertNotNull(applicationContext);
	}
	@Test
	public void getRightParameterTest() {
		assertEquals("root", applicationContext.getProperty(PropertiesConstants.DB_USERNAME));
	}
}
