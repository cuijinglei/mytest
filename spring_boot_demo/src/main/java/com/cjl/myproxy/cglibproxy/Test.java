package com.cjl.myproxy.cglibproxy;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    public void methodOne(){
        System.out.println("方法一");
    }

    @Autowired
    public void methodTwo(){
        System.out.println("方法二");
    }
}
