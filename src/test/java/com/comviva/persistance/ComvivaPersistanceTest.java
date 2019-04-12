package com.comviva.persistance;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comviva.model.Comviva;
import com.comviva.repository.ComvivaPersistance;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComvivaPersistanceTest {
	
	@Autowired
	ComvivaPersistance comvivaPersistance;
	
	@Test
	public void comvivaPersistanceIsinitalizedTest() {
		assertNotNull(comvivaPersistance);
	}
	
	@Test
	public void listAllComvivaRegisterIsOkTest() throws SQLException {
		List<Comviva> records = comvivaPersistance.listAll();
		assertTrue(records.size()>0);
	}
}
