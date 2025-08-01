package com.cjl.singleton;

public class LanHan {
    private static volatile LanHan lanHan;

    private LanHan() {}

    public static LanHan getInstance() {
        if (lanHan == null) {
            synchronized (LanHan.class) {
                if (lanHan == null) {
                    lanHan = new LanHan();
                }
            }
        }
        return lanHan;
    }
}
