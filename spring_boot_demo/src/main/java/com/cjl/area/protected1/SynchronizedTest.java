package com.cjl.area.protected1;

public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        new Thread(()-> {
            try {
                synchronizedTest.aa();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(500);

        new Thread(()->synchronizedTest.bbb()).start();;
    }

    public void aa() throws InterruptedException {
        System.out.println("aaa");
        synchronized (this){
            Thread.sleep(10000);
            System.out.println("a结束");
        }

    }

    public void bbb(){
        System.out.println("bbb");
        synchronized (this){
            System.out.println("进来了");
        }
    }
}
