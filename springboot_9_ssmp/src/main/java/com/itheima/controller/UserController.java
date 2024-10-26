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
    public R getAll(){
        return new R(true ,userService.list());
    }

    @PostMapping
    public R save(@RequestBody User user) throws IOException {
        if(user.getUsername().equals("111") ) throw new IOException();
        boolean flag = userService.save(user);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

//    接收大量参数用@RequestBody
    @PutMapping
    public R update(@RequestBody User user){
        return new R(userService.updateById(user));
    }

//  @PathVariable表明从路径中得到变量
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(userService.removeById(id));
    }


//    https://localhost/users/2
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, userService.getById(id));
    }

    @GetMapping("{currentpage}/{pageSize}")
    public R getPage(@PathVariable int currentpage, @PathVariable int pageSize, User user){
        IPage<User> page = userService.getPage(currentpage, pageSize, user);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentpage > page.getPages()){
            page = userService.getPage((int)page.getPages(), pageSize, user);
        }
        return new R(true ,page);
    }
}
