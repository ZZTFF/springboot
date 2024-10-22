package com.itheima.domain;

import lombok.Data;

//lombok
@Data
//加上这个注解相当于就有了getter setter和tostring
public class User {
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String addr;



}
