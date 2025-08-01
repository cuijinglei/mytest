package com.cjl.area.protected1;

import org.omg.SendingContext.RunTime;
import sun.misc.Launcher;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test {
    static {
        System.currentTimeMillis();
        System.out.println("类加载的初始化阶段");
    }
    public static int a = 1;
    public static void main(String[] args) {
//        new Object();
//        String a = "a";
//        String b = "b";
//        String c = "c";
//        String abc = a + b +c;
//        FuProtected fuProtected = new FuProtected();
//        fuProtected.a();
//        fuProtected.b();
//        Launcher.getLauncher();

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
