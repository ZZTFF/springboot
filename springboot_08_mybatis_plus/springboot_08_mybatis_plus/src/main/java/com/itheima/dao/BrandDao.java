package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Brand;
import org.apache.ibatis.annotations.Mapper;


//public interface BrandDao {
//    @Select("select * from tb_brand where id = #{id}")
//    Brand getById(Integer id);
//}

//1.添加springboot整合mybatisplus的坐标
//2.定义数据层接口与映射配置，继承BaseMapper
@Mapper
public interface BrandDao extends BaseMapper<Brand> {

}