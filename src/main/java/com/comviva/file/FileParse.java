package com.comviva.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.comviva.exception.FileParseException;
import com.comviva.validator.NumberValidator;

public class FileParse {
	
	File file = null;
	
	public FileParse(String path) {
		if (path != null)
			file = new File(path);
	}
	
	@SuppressWarnings({ "finally" })
	public List<Double> parseFile() throws FileParseException{
		List<Double> numbers = new ArrayList<Double>();
		try {
			if (file.exists()) {
				Scanner scanner;
				scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] words = line.split(" ");
					for(String word: words) {
						if (NumberValidator.validate(word)) {
							numbers.add(Double.parseDouble(word));
						}
					}
				}
				scanner.close();
			} else {
				throw new FileParseException("File not exist");
			}
		} catch (Exception e) {
			throw new FileParseException("File not be null");
		}
		return numbers;
	}
}
