package com.itheima;

import com.itheima.dao.BrandDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot08MybatisPlusApplicationTests {

    @Autowired
    private BrandDao brandDao;

    @Test
    void contextLoads() {
        System.out.println(brandDao.selectById(3));
    }

}
