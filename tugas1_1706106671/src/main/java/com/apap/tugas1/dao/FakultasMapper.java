package com.apap.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.apap.tugas1.model.FakultasModel;

@Mapper
public interface FakultasMapper {

    @Select("select id, kode_fakultas, nama_fakultas, id_univ "
    			+ "from fakultas "
    				+ "where id = #{id}")
    FakultasModel selectFakultas (@Param("id") int id);
}
