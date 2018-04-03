package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.dao.ProgramStudiMapper;
import com.apap.tugas1.model.FakultasModel;
import com.apap.tugas1.model.ProgramStudiModel;


@Service
public class ProgramStudiServiceDatabase implements ProgramStudiService {

	@Autowired
	private ProgramStudiMapper programStudiMapper;
	@Autowired
	private FakultasServiceDatabase fakultasDAO;
	
	@Override
	public ProgramStudiModel selectProgramStudi(int id) {
		ProgramStudiModel res = programStudiMapper.selectProgramStudi(id); 
		if(res!=null) {
			res.setFakultas(fakultasDAO.selectFakultas(res.getId_fakultas()));
		}
		return res;
	}

}
