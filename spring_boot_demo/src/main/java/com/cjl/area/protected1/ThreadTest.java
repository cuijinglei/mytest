package com.cjl.area.protected1;

import com.sun.org.apache.xpath.internal.SourceTree;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(()->{
//            try {
//                System.out.println("子线程休眠");
//                Thread.sleep(Long.parseLong("10000"));
//                System.out.println("子线程结束休眠");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return;
//            }
//        });
//        thread.start();
//        System.out.println("休眠");
//        Thread.sleep(Long.parseLong("5000"));
//        System.out.println("结束");
//        thread.interrupt();
        Thread t = new Thread(() -> {
            System.out.println("线程1必须先执行完");
            try {
                Thread.sleep(1000);
                System.out.println("1结束了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        new Thread(()-> {
            System.out.println("二开试了");
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("二结束了");
        }).start();

    }
}
