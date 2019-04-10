package com.comviva.file;

import java.util.List;

import com.comviva.exception.FileParseException;
import com.comviva.exception.FileProcessException;

public class FileProcess {
	
		public Double sumAllNumbers(String path) throws FileProcessException {
			FileParse fileParse = new FileParse(path);
			List<Double> numbers;
			try {
				numbers = fileParse.parseFile();
			} catch (FileParseException e) {
				throw new FileProcessException("File can't process");
			}
			return numbers.stream().mapToDouble(n -> n.doubleValue()).sum();
			
		}
}
