package com.cjl.myproxy.jdkproxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        IDemo demoProxy = (IDemo)Proxy.newProxyInstance(Demo.class.getClassLoader(), new Class[]{IDemo.class},
                new DemoProxy(demo));
        demoProxy.methodOne();
        demoProxy.methodTwo();
    }
}
