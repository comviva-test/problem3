package com.comviva.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comviva.dto.FileProcessDTO;
import com.comviva.exception.ComvivaException;
import com.comviva.exception.FileProcessException;
import com.comviva.service.FileProcessService;

@Controller
@RequestMapping("file-process")
public class FileProcessResource{
	
	@Autowired 
	private FileProcessService fileProcessService;
	
	@PostMapping("process")
	public ResponseEntity<String> processFile(@RequestBody FileProcessDTO fileProcessDTO) {
		try {
			fileProcessService.addAllNumbers(fileProcessDTO.getPath());
			return ResponseEntity
		            .status(HttpStatus.OK)
		            .body("File Processing Right");
		} catch (FileProcessException | ComvivaException e) {
			 e.printStackTrace();
	        return ResponseEntity
	            .status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("Internal Server Error");
		}
	}
	
}
