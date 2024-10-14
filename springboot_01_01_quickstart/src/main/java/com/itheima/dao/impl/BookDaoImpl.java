package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

//把这个类变成一个bean
@Repository
public class BookDaoImpl implements BookDao {
    public void save(){
        System.out.println("testing.........");
    }
}
