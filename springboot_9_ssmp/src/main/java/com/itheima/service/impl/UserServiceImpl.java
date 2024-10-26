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
//（即User关联的sql查询语句）
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public IPage<User> getPage(int currentPage, int pagesize, User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.like(Strings.isNotEmpty(user.getUsername()),User::getUsername,user.getUsername());
        lqw.like(Strings.isNotEmpty(user.getPassword()),User::getPassword,user.getPassword());
        lqw.like(Strings.isNotEmpty(user.getGender()),User::getAddr,user.getGender());
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
