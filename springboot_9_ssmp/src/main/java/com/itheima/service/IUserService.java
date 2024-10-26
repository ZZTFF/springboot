package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.User;
//业务层快速开发
//继承IService<User>相当于有了很多的接口定义
public interface IUserService extends IService<User> {
//    下面可以自己新加方法

    IPage<User> getPage(int currentPage, int pagesize, User user);
    IPage<User> getPage(int currentPage, int pagesize);
}
