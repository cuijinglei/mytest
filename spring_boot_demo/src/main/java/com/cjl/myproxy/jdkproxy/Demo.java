package com.cjl.myproxy.jdkproxy;

import org.springframework.beans.factory.annotation.Autowired;

public class Demo implements IDemo{

    public void methodOne(){
        System.out.println("原方法1");
    }

    @Autowired
    public void methodTwo(){
        System.out.println("原方法2");
    }
}
