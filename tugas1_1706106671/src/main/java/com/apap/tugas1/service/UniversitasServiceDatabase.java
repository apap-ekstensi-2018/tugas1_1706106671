package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apap.tugas1.dao.UniversitasMapper;
import com.apap.tugas1.model.UniversitasModel;


@Service
public class UniversitasServiceDatabase implements UniversitasService {

	@Autowired
	private UniversitasMapper universitasMapper;
	
	@Override
	public UniversitasModel selectUniversitas(int id) {
		UniversitasModel res = universitasMapper.selectUniversitas(id); 
		return res;
	}

}
