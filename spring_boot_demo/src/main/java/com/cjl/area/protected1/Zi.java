package com.cjl.area.protected1;

public class Zi extends FuProtected {
    private int a=1;
    private String b="2";
    private Integer v=1;

    public int getA() {
        return a;
    }
    public static void main(String[] args) {
        String aaa = new String("aaa");
        String intern = aaa.intern();
        System.out.println(aaa);
        System.out.println(intern);
        System.out.println(aaa==intern);

        String s1 = new String("he") + new String("llo");
        String intern1 = s1.intern();

        System.out.println(s1);
        System.out.println(intern1);
        System.out.println(s1==intern1);
    }
}
