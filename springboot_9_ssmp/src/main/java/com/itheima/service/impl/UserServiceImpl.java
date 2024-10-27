package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//ServiceImpl<UserDao, User>一个参数是接口，另一个是实体类。加上这句话，
//将IUserService定义的方法全部实现
//extends ServiceImpl<UserDao, User>相当于知道了User对象，以及UserDao

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public IPage<User> getPage(int currentPage, int pagesize, User user) {
        //将传入的user对象接收
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        如果user.getUsername()不为空，将会用于like查询
        lqw.like(Strings.isNotEmpty(user.getUsername()),User::getUsername,user.getUsername());
        lqw.like(Strings.isNotEmpty(user.getPassword()),User::getPassword,user.getPassword());
        lqw.like(Strings.isNotEmpty(user.getGender()),User::getGender,user.getGender());
        lqw.like(Strings.isNotEmpty(user.getAddr()),User::getAddr,user.getAddr());
        IPage page = new Page(currentPage, pagesize);
        userDao.selectPage(page, lqw);
        return page;
    }

    @Override
    public IPage<User> getPage(int currentPage, int pagesize) {
        IPage page = new Page(currentPage, pagesize);
        userDao.selectPage(page,null);
        return page;
    }
}
