package com.cjl.myproxy.jdkproxy;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoProxy implements InvocationHandler {
    Object demo;
    public DemoProxy(Object demo) {
        this.demo = demo;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method declaredMethod = demo.getClass().getDeclaredMethod(method.getName());
        Autowired annotation = declaredMethod.getAnnotation(Autowired.class);
        if(annotation != null){
            System.out.println("加强方法");
        }
        Object invoke = method.invoke(demo, args);
        return invoke;
    }
}
