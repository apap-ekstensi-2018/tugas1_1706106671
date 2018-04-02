package com.apap.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.apap.tugas1.model.MahasiswaModel;

@Mapper
public interface MahasiswaMapper {

    @Select("select id, npm, nama, tempat_lahir, tanggal_lahir, "
    				 + "jenis_kelamin, agama, golongan_darah, status, "
    				 + "tahun_masuk, jalur_masuk, id_prodi "
    			+ "from mahasiswa "
    				+ "where npm = #{npm}")
    MahasiswaModel selectMahasiswa (@Param("npm") String npm);
}
