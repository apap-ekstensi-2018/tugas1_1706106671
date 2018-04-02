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
	private int jenisKelamin;
	private String agama;
	private String golongan_darah;
	private String status;
	private String tahun_masuk;
	private String jalur_masuk;
	private int idProdi;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNpm() {
		return npm;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempatLahir() {
		return tempat_lahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempat_lahir = tempatLahir;
	}

	public String getTanggalLahir() {
		return tanggal_lahir;
	}

	public void setTanggalLahir(String tanggalLahir) {
		this.tanggal_lahir = tanggalLahir;
	}

	public int getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(int jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getGolonganDarah() {
		return golongan_darah;
	}

	public void setGolonganDarah(String golonganDarah) {
		this.golongan_darah = golonganDarah;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTahunMasuk() {
		return tahun_masuk;
	}

	public void setTahunMasuk(String tahunMasuk) {
		this.tahun_masuk = tahunMasuk;
	}

	public String getJalurMasuk() {
		return jalur_masuk;
	}

	public void setJalurMasuk(String jalurMasuk) {
		this.jalur_masuk = jalurMasuk;
	}

	public int getIdProdi() {
		return idProdi;
	}

	public void setIdProdi(int idProdi) {
		this.idProdi = idProdi;
	}
	
	
	
	
}
