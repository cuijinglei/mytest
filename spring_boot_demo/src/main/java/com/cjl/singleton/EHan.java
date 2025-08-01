package com.cjl.singleton;

public class EHan {
    public static EHan singleton = new EHan();

    private EHan() {
    }

    public static EHan getInstance() {
        return singleton;
    }
}
