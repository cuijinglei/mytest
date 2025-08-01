package com.cjl.area.protected1;

public class C2Bug {
    public void test(){
        int a = 8;
        while((a -= 3) > 0);
        System.out.println("i = " + a);

    }

    public static void main(String[] args) {
        C2Bug c2Bug = new C2Bug();
        for (int i = 0; i < 50000; i ++){
            c2Bug.test();
        }
    }
}
