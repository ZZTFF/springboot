package com.itheima.controller;

import com.itheima.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

//    读取yml配置文件中单一数据
    @Value("${country}")
    private String country11;

    @Value("${user.name}")
    private String name;

//    读取数组元素
    @Value("${likes[0]}")
    private String likes0;

    @Value("${likes[1]}")
    private String likes1;

    @Value("${users[0].name}")
    private String users0Name;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir1}")
    private String tempDir1;

//    使用自动装载将配置文件中所有数据封装到对象Environment中
    @Autowired
    private Environment env;

    @Autowired
    private Person person;


    @GetMapping
    public String getById(){
        System.out.println("springboot is running");
        System.out.println(country11);
        System.out.println(name);
        System.out.println(likes0);
        System.out.println(likes1);
        System.out.println(users0Name);
        System.out.println(tempDir);
        System.out.println(tempDir1);
        System.out.println("--------");

        System.out.println(env.getProperty("server.port"));
        System.out.println("---------");
        System.out.println(person);

        return "springboot is running";
    }
}
