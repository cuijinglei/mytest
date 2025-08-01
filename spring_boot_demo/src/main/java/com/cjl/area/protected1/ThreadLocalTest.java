package com.cjl.area.protected1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 100, 10, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.submit(()->{

        });
        threadPoolExecutor.shutdown();
        threadPoolExecutor.shutdownNow();
    }
}
