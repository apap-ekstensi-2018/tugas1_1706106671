package com.apap.tugas1.service;

import com.apap.tugas1.model.MahasiswaModel;

public interface MahasiswaService {
	MahasiswaModel selectMahasiswa(String npm);
	boolean insertMahasiswa(MahasiswaModel mahasiswa);
	int selectLastCounterNpm(String npm_without_counter);
}
