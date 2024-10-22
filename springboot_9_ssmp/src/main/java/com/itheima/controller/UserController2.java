package com.itheima.controller;
//表现层开发

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/users")
public class UserController2 {
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody User user){
        return userService.save(user);
    }

//    接收大量参数用@RequestBody
    @PutMapping
    public Boolean update(@RequestBody User user){
        return userService.update(user, null);
    }

//  @PathVariable表明从路径中得到变量
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }


//    https://localhost/users/2
    @GetMapping("{id}")
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("{currentpage}/{pagesize}")
    public IPage<User> getPage(@PathVariable int currentpage, @PathVariable int pagesize){
        return userService.getPage(currentpage, pagesize);
    }

}
