package com.comviva.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.comviva.exception.ComvivaException;
import com.comviva.exception.FileProcessException;
import com.comviva.service.ComvivaService;
import com.comviva.service.FileProcessService;

@ManagedBean(name = "comvivaCtrl")
@ViewScoped
public class ComvivaController {
	@Autowired
	private ComvivaService comvivaService;
	@Autowired
	private FileProcessService fileProcessService;
	
	private String path;
	
	public void processFile() {
		System.out.println("ComvivaController : processFile");
		try {
			fileProcessService.addAllNumbers(path);
		} catch (FileProcessException | ComvivaException e) {
			System.out.println("Error to file process");
		}
	}
	
	public ComvivaService getComvivaService() {
		return comvivaService;
	}

	public void setComvivaService(ComvivaService comvivaService) {
		this.comvivaService = comvivaService;
	}

	public FileProcessService getFileProcessService() {
		return fileProcessService;
	}

	public void setFileProcessService(FileProcessService fileProcessService) {
		this.fileProcessService = fileProcessService;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
