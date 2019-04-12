package com.comviva.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.exception.ComvivaException;
import com.comviva.model.Comviva;
import com.comviva.repository.ComvivaPersistance;

@Service
public class ComvivaServiceImpl implements ComvivaService{
	
	@Autowired
	ComvivaPersistance repository;
	
	@Override
	public List<Comviva> listAll() throws SQLException {
		return repository.listAll();
	}

	@Override
	public void save(Comviva record) throws ComvivaException, SQLException {
		repository.save(record);
	}
	
}
