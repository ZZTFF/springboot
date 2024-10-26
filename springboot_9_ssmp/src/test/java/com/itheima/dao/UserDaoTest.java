package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//数据层测试
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    void testGetById(){
        System.out.println(userDao.selectById(1));
    }

    @Test
    void Save(){
        User user = new User();
        user.setUsername("jack");
        user.setPassword("111111");
        user.setGender("男");
        user.setAddr("重庆");
        userDao.insert(user);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(7);
        user.setUsername("jack");
        user.setPassword("111111");
        user.setGender("男");
        user.setAddr("西安");
        userDao.updateById(user);
    }

    @Test
    void testDelete(){
        userDao.deleteById(4);
    }

    @Test
    void testGetAll(){
        userDao.selectList(null);
    }

//    分页查询
    @Test
    void testGetPage(){
//        1.定义分页对象，当前第几页，每页多少个数据
//        2.定义分页拦截器，固定格式，内部是动态拼写mysql语句
//        Page两个参数分别是当前页码，和每页数据条数
        IPage page = new Page(4, 2);
        userDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("password", "3");
//        qw.ne("username", "张三");
        userDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
//            使用Lambda就可以防止属性名书写错误
        String password  = "";
//当name传递进来的是null时，使用lqw.like的sql语句为%null%
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(password != null,User::getPassword, "4");
        userDao.selectList(lqw);
    }




}
