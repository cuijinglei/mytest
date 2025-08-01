package com.cjl.area.protected1;

import java.lang.reflect.Field;

public class FuProtected {
    protected void a(){
        System.out.println("这是protected方法");
    }

    void b(){
        System.out.println("这是一个default方法");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.cjl.area.protected1.Test");
        System.out.println("loadClass只完成类加载第一步");
        Field a = aClass.getDeclaredField("a");
        System.out.println("获取引用");
        Object o = a.get(null);
        System.out.println("获取值");
        System.out.println(Test.a);
        System.out.println("这会加载吗");
        Class<?> aClass1 = Class.forName("com.cjl.area.protected1.Test");
    }
}
