package com.cjl.area.protected1;

import java.math.BigInteger;

public class Demo {
    static int num;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                add();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                add();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(num);
        System.out.println(1 << 16);
        int decimal = Integer.parseInt("00000000000000010000000000000000", 2);
        System.out.println(decimal);
        System.out.println(129 & 128);
        System.out.println(~2);
        System.out.println(Integer.toBinaryString(-3));

        int i = new BigInteger("11111111111111111111111111111101", 2).intValue();

        System.out.println(i);
        System.out.println(1 & 65535);
        System.out.println(Integer.toBinaryString(65535));
        System.out.println(Integer.toBinaryString(65536));

    }
    public synchronized static void add(){
        num ++;
    }
}
