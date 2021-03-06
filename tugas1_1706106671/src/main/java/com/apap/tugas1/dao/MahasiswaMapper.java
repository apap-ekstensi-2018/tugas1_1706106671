package com.apap.tugas1.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.apap.tugas1.model.MahasiswaModel;

@Mapper
public interface MahasiswaMapper {

    @Select("select id, npm, nama, tempat_lahir, tanggal_lahir, "
    				 + "jenis_kelamin, agama, golongan_darah, status, "
    				 + "tahun_masuk, jalur_masuk, id_prodi "
    			+ "from mahasiswa "
    				+ "where npm = #{npm}")
    MahasiswaModel selectMahasiswa (@Param("npm") String npm);

    @Insert("INSERT INTO mahasiswa (npm, nama, tempat_lahir, "
    								+ "tanggal_lahir, jenis_kelamin, agama, "
    								+ "golongan_darah, status, tahun_masuk, "
    								+ "jalur_masuk, id_prodi)\n"
    						+ "VALUES (#{npm}, #{nama}, #{tempat_lahir}, "
    								+ "#{tanggal_lahir}, #{jenis_kelamin}, #{agama}, "
    								+ "#{golongan_darah}, #{status}, #{tahun_masuk}, "
    								+ "#{jalur_masuk}, #{id_prodi})")
    boolean insertStudent(MahasiswaModel mahasiswa);
    
    @Update("UPDATE  mahasiswa SET npm=#{npm}, nama=#{nama}, tempat_lahir=#{tempat_lahir}, "
			+ "tanggal_lahir=#{tanggal_lahir}, jenis_kelamin=#{jenis_kelamin}, agama=#{agama}, "
			+ "golongan_darah=#{golongan_darah}, status=#{status}, tahun_masuk=#{tahun_masuk}, "
			+ "jalur_masuk=#{jalur_masuk}, id_prodi=#{id_prodi} "
			+ "WHERE id=#{id}")
    boolean updateMahasiswa(MahasiswaModel mahasiswa);
    
    @Select("select cast(right(npm,3) as unsigned) as npm_counter "
    			+ "from mahasiswa "
			+ "where npm like #{npm_without_counter} order by npm_counter desc limit 1")
    MahasiswaModel selectLastCounterNpm (@Param("npm_without_counter") String npm_without_counter);
}
