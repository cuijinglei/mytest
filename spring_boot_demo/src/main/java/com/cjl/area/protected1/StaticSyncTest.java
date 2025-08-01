package com.cjl.area.protected1;

import javafx.geometry.VPos;

import java.net.SocketTimeoutException;

public class StaticSyncTest {
    public static void main(String[] args) {

    }

    public static synchronized void a(){
        System.out.println("a方法");
    }

    public void b(){
        //静态方法中不能使用this
        synchronized (this){

        }
    }
}
