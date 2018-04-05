package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.dao.MahasiswaMapper;
import com.apap.tugas1.model.MahasiswaModel;
import com.apap.tugas1.service.ProgramStudiService;

import lombok.extern.slf4j.Slf4j;;
@Slf4j
@Service
public class MahasiswaServiceDatabase implements MahasiswaService {

	@Autowired
	private MahasiswaMapper mahasiswaMapper;
	@Autowired
	private ProgramStudiService programStudiDAO;
	
	public MahasiswaServiceDatabase() {
		
	}
	

	public MahasiswaServiceDatabase(MahasiswaMapper mahasiswaMapper) {
		this.mahasiswaMapper = mahasiswaMapper;
	}

	@Override
	public MahasiswaModel selectMahasiswa(String npm) {
		MahasiswaModel res  = mahasiswaMapper.selectMahasiswa(npm);
		if(res!=null) {
			res.setProgram_studi(programStudiDAO.selectProgramStudi(res.getId_prodi()));
		}
		return res;
	}


	@Override
	public int selectLastCounterNpm(String npm_without_counter) {
		MahasiswaModel res = mahasiswaMapper.selectLastCounterNpm(npm_without_counter);
		if(res!=null) {
			return res.getNpm_counter()+1;
		}
		return 1;
	}


	@Override
	public boolean insertMahasiswa(MahasiswaModel mahasiswa) {
		log.info("insert mahasiswa");
		return mahasiswaMapper.insertStudent(mahasiswa);
	}

}
