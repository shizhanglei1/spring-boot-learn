package com.springbootlearn.learn.controller;

import com.springbootlearn.learn.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Value(value = "${roncoo.secret}")
    private int id;

    @Value(value = "${roncoo.desc}")
    private String name;


    @RequestMapping
    public String index(){
        return "Hello world" ;
    }

    //@RequestParam 简单类型的绑定，可以出来get和post
    @RequestMapping(value = "/get")
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("title","hello eva");
        map.put("name",name);
        return  map;
    }

    //@PathVariable 获取请求url 中的动态参数
    @RequestMapping( value = "/get/ind")
    public User getUser(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return  user;
    }
}
