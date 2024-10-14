package com.itheima;

import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//测试类需要和引导类在同一个包下com.itheima
//否则需要在@SpringBootTest(classes = Springboot0101QuickstartApplication.class)
@SpringBootTest
class Springboot0101QuickstartApplicationTests {
//springboot整合junit
    //    1.注入测试对象

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
//        2.执行方法
        bookDao.save();
    }

}
