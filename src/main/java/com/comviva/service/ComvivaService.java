package com.comviva.service;

import java.sql.SQLException;
import java.util.List;

import com.comviva.exception.ComvivaException;
import com.comviva.model.Comviva;

public interface ComvivaService {

	public List<Comviva> listAll()  throws SQLException;
	public void save(Comviva record) throws ComvivaException, SQLException;
}
