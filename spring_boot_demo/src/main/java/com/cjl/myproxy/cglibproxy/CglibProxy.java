package com.cjl.myproxy.cglibproxy;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CglibProxy implements MethodInterceptor {
    private Object targetObject;

    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(obj.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类(代理对象)
        Object proxyObj = enhancer.create();
        return proxyObj;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //模拟一下新增部分业务逻辑
        if(method.getAnnotation(Autowired.class) != null){
            System.out.println("这是增强方法前......");
        }
        Object obj = method.invoke(targetObject, args);

        return obj;
    }

}
