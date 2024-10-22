package com.itheima.mapper.impl;

import com.itheima.mapper.BookDao;
import org.springframework.stereotype.Repository;

//把这个类变成一个bean
@Repository
public class BookDaoImpl implements BookDao {
    public void save(){
        System.out.println("testing.........");
    }
}
