
package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.User;

import java.util.List;

//业务层接口
//下面的方法名是自定义
public interface UserService {
    Boolean save(User user);
    Boolean update(User user);

    Boolean delete(Integer id);

    User getById(Integer id);

    List<User> getAll();

    IPage<User> getPage(int currentPage, int pagesize);

}
