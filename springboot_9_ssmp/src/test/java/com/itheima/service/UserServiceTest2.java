package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest2 {
    @Autowired
    private IUserService userService;
    @Test
    void testGetById(){
//        业务层得输出
        System.out.println(userService.getById(3));
    }

    @Test
    void Save(){
        User user = new User();
        user.setUsername("jack");
        user.setPassword("333333");
        user.setGender("男");
        userService.save(user);
//        boolean flag = userService.save(user);
//        System.out.println(flag);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(3);
        user.setUsername("jack");
        user.setPassword("2222222");
        user.setGender("男");
        user.setAddr("西安");
        userService.updateById(user);//返回类型是boolean
    }

    @Test
    void testDelete(){
        userService.removeById(4);
    }

    @Test
    void testGetAll(){
        userService.list();
    }

    @Test
    void testGetPage(){
//        1.定义分页对象，当前第几页，每页多少个数据
//        2.定义分页拦截器，固定格式，内部是动态拼写mysql语句
//        IPage<User> page = new Page<User>(1, 2);
//        userService.page(page);
//        System.out.println(page.getPages());
//        System.out.println(page.getCurrent());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
//        System.out.println(page.getRecords());

        userService.getPage(1,2);
        IPage page = userService.getPage(1,2);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());

    }




}
