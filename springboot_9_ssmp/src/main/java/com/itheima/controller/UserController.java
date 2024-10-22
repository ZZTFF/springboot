package com.itheima.controller;
//表现层开发

import com.itheima.controller.utils.R;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R save(@RequestBody User user){
        return new R(userService.save(user));
    }

//    接收大量参数用@RequestBody
    @PutMapping
    public R update(@RequestBody User user){
        return new R(userService.update(user, null));
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

    @GetMapping("{currentpage}/{pagesize}")
    public R getPage(@PathVariable int currentpage, @PathVariable int pagesize){
        return new R(true ,userService.getPage(currentpage, pagesize));
    }

}
