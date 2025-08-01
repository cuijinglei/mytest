package com.cjl.area.protected1;

public class A {
    public void say(){
        System.out.println(Thread.currentThread().getName()+"======="+Hello.getLocal());
    }

}
