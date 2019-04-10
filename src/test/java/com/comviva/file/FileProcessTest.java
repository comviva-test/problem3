package com.comviva.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;

import com.comviva.exception.FileProcessException;

public class FileProcessTest {
	@Test
	public void fileProcessIsNull() {
		FileProcess fp = null;
		assertNull(fp);
	}

	@Test
	public void fileProcessIsNotNull() {
		FileProcess fp = new FileProcess();
		assertNotNull(fp);;
	}
	
	@Test()
	public void fileProcessSumAllNumberOfFile() throws FileProcessException {
		FileProcess fp = new FileProcess();
		Double sum = fp.sumAllNumbers("/home/hernan/workspace/eclipse-workspace/comviva/files/test1.txt");
		assertEquals(new Double(124.20), new Double(new BigDecimal(sum).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
	}
	
	@Test(expected=FileProcessException.class)
	public void fileProcessReturnException() throws FileProcessException {
		FileProcess fp = new FileProcess();
		Double sum = fp.sumAllNumbers("/home/hernan/workspace/eclipse-workspace/comviva/files/test2.txt");
		assertEquals(new Double(124.20), new Double(new BigDecimal(sum).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
	}
}
