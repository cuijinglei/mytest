package com.cjl.myproxy.cglibproxy;

public class TestMain {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Test proxyObject = (Test)cglibProxy.createProxyObject(new Test());
        proxyObject.methodOne();
        proxyObject.methodTwo();

        int ints[] = null;
        ints = new int[]{1};

    }
}
