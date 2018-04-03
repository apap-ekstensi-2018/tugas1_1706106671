package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.dao.FakultasMapper;
import com.apap.tugas1.model.FakultasModel;


@Service
public class FakultasServiceDatabase implements FakultasService {

	@Autowired
	private FakultasMapper fakultasMapper;
	@Autowired
	private UniversitasService universitasDAO;
	@Override
	public FakultasModel selectFakultas(int id) {
		FakultasModel res = fakultasMapper.selectFakultas(id); 
		if(res!=null) {
			res.setUniversitas(universitasDAO.selectUniversitas(res.getId_univ()));
		}
		return res;
	}

}
