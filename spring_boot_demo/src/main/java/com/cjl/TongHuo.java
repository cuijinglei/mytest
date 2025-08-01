package com.cjl;

public class TongHuo {
    public static void main(String[] args) {
        int a = 136;
        int b = 128;
        int i = a ^ b;
        int x = (a&b)|(~a&~b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(x));
    }
}
