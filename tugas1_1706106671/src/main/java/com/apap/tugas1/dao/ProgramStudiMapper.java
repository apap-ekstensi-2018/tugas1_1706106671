package com.apap.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.apap.tugas1.model.ProgramStudiModel;

@Mapper
public interface ProgramStudiMapper {

    @Select("select id, kode_prodi, nama_prodi, id_fakultas "
    			+ "from program_studi "
    				+ "where id = #{id}")
    ProgramStudiModel selectProgramStudi (@Param("id") int id);
}
