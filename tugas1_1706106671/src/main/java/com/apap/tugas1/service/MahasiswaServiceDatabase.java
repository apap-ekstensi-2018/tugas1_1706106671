package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.dao.MahasiswaMapper;
import com.apap.tugas1.model.MahasiswaModel;

@Service
public class MahasiswaServiceDatabase implements MahasiswaService {

	@Autowired
	private MahasiswaMapper mahasiswaMapper;
	
	public MahasiswaServiceDatabase() {
		
	}
	

	public MahasiswaServiceDatabase(MahasiswaMapper mahasiswaMapper) {
		this.mahasiswaMapper = mahasiswaMapper;
	}



	@Override
	public MahasiswaModel selectMahasiswa(String npm) {
		return mahasiswaMapper.selectMahasiswa(npm);
	}

}
