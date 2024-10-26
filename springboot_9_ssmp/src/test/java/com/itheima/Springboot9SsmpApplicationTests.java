package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot9SsmpApplicationTests {

    @Autowired
    private UserDao userdao;
    @Test
    void contextLoads() {

    }
}
