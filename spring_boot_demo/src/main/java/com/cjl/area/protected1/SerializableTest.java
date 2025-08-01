package com.cjl.area.protected1;

import com.alibaba.fastjson.JSON;

public class SerializableTest {
    public static void main(String[] args) {
        Zi zi = new Zi();
        String s = JSON.toJSONString(zi);
        System.out.println(s);
        Zi zi1 = JSON.parseObject(s, Zi.class);
       // Zi zi2 = JSON.parseObject("{'b':'333'}", Zi.class);
        System.out.println(zi1);
    }
}
