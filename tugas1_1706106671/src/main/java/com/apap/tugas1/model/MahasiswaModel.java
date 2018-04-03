package com.apap.tugas1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	private int id;
	private String npm;
	private String nama;
	private String tempat_lahir;
	private String tanggal_lahir;
	private int jenis_kelamin;
	private String agama;
	private String golongan_darah;
	private String status;
	private String tahun_masuk;
	private String jalur_masuk;
	private int id_prodi;
	private ProgramStudiModel program_studi;
	
}
