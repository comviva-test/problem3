package com.comviva.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comviva.exception.ComvivaException;
import com.comviva.model.Comviva;
import com.comviva.service.ComvivaService;

@Controller
@RequestMapping("comviva")
public class ComvivaResource {
	
	@Autowired
	private ComvivaService comvivaService;
	
	@SuppressWarnings("finally")
	@GetMapping("list")
	@ResponseBody
	public List<Comviva> list() throws ComvivaException {
		List<Comviva> registers = null;
		try {
			registers = comvivaService.listAll();
		} catch (SQLException e) {
			 e.printStackTrace();
			 throw new ComvivaException("Internal Server Error");
		} finally {
			return registers;
		}
	}
}
