package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
//业务层接口
//如果是业务方法，就根据业务名称设定，增删改查就直接写增删改查

//使用注解将这个类定义为业务对应的bean
@Service
public class UserServiceImpl2 implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean save(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean update(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public User getById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.selectList(null);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pagesize) {
        IPage page = new Page(currentPage, pagesize);
        return userDao.selectPage(page, null);
    }
}
