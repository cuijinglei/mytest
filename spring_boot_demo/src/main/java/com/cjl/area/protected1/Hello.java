package com.cjl.area.protected1;

public class Hello {
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static String getLocal() {
        return local.get();
    }

    public static void setLocal(String a) {
        Hello.local.set(a);
    }
    public static void remove() {
        local.remove();
    }


}
