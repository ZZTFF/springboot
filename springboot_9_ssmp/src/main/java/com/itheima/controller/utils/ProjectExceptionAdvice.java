package com.itheima.controller.utils;


//作为springmvc异常处理器

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为controller的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
//    拦截所有的一场信息
    @ExceptionHandler
    public R doException(Exception ex){
//       记录日志
        ex.printStackTrace();
        return new R(false, "服务器故障");
    }


}
