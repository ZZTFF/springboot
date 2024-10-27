package com.itheima.controller;
//表现层开发

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
//    userService.list()返回一个列表
    public R getAll(){
        return new R(true ,userService.list());
    }

    @PostMapping
    public R save(@RequestBody User user) throws IOException {
        if(user.getUsername().equals("111") ) throw new IOException();
//        userService.save(user)返回true
        boolean flag = userService.save(user);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

//    接收大量参数用@RequestBody
    @PutMapping
//   userService.updateById(user)返回boolean'
    public R update(@RequestBody User user){
        return new R(userService.updateById(user));
    }

//  @PathVariable表明从路径中得到变量
    @DeleteMapping("{id}")
    //   userService.removeById(user)返回boolean
    public R delete(@PathVariable Integer id){
        return new R(userService.removeById(id));
    }


//    https://localhost/users/2
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, userService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
//    由于要执行条件查询，需要接收user对象中相应参数
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, User user){
        System.out.println("接收到的参数为");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        IPage<User> page = userService.getPage(currentPage, pageSize, user);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = userService.getPage((int)page.getPages(), pageSize, user);
        }
        return new R(true ,page);


    }
}
