package com.itheima.dao;

import com.itheima.domain.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface BrandDao {
    @Select("select * from tb_brand where id = #{id}")
    Brand getById(Integer id);
}
