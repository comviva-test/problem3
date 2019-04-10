package com.comviva.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.comviva.exception.FileParseException;

public class FileParseTest {
	
	@Test
	public void fileIsEmptyTest() {
		FileParse fileParse = null;
		assertNull(fileParse);
	}
	
	@Test
	public void filetIsCreatedTest() {
		FileParse fileParse = new FileParse("/home/hernan/workspace/eclipse-workspace/comviva/files/test1.txt");
		assertNotNull(fileParse);
	}
	
	@Test(expected = FileParseException.class)
	public void filetPathIsNullTest() throws FileParseException {
		FileParse fileParse = new FileParse(null);
		List<Double> numbers = fileParse.parseFile();
	}
	
	@Test
	public void fileHasFiveNumbersTest() throws FileParseException {
		FileParse fileParse = new FileParse("/home/hernan/workspace/eclipse-workspace/comviva/files/test1.txt");
		List<Double> numbers = fileParse.parseFile();
		assertEquals(5, numbers.size());
	}
	
	@Test(expected = FileParseException.class)
	public void fileNotExitsTest() throws FileParseException {
		FileParse fileParse = new FileParse("/home/hernan/workspace/eclipse-workspace/comviva/files/test2.txt");
		List<Double> numbers = fileParse.parseFile();
	}
}
