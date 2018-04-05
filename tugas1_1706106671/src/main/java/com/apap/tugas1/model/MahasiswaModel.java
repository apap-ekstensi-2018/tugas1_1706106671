package com.apap.tugas1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	private int id;
	private int npm_counter;
	private String npm_without_counter;
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

	public void generateNpmWithoutCounter() {
		String last2thnmsk = this.tahun_masuk.substring(this.tahun_masuk.length()-2, this.tahun_masuk.length());
		String kodeUniv = this.program_studi.getFakultas().getUniversitas().getKode_univ();
		String kodeProdi = this.program_studi.getKode_prodi();
		String kodeJalurMasuk = "";
		switch(jalur_masuk) {
			case "Undangan Olimpiade":
				kodeJalurMasuk = "53";
				break;
			case "Undangan Reguler/SNMPTN":
				kodeJalurMasuk = "54";
				break;
			case "Undangan Paralel/PPKB":
				kodeJalurMasuk = "55";
				break;
			case "Ujian Tulis Bersama/SBMPTN":
				kodeJalurMasuk = "57";
				break;
			case "Ujian Tulis Mandiri":
				kodeJalurMasuk = "62";
				break;
		}
		this.npm_without_counter = last2thnmsk+kodeUniv+kodeProdi+kodeJalurMasuk;
	}
	
	public void addCounterToNpm(int counter) {
		String count = "";
		if((npm==null || npm.length()==9) && counter<1000) {
			if(counter<1000 && counter>99) {
				count = Integer.toString(counter);
			}else if(counter>9) {
				count = "0"+Integer.toString(counter);
			}else if(counter>0) {
				count = "00"+Integer.toString(counter);
			}
			this.npm = this.npm_without_counter+count;
		}
	}
	
}

