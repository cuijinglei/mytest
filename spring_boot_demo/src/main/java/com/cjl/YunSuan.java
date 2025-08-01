package com.cjl;

import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.Random;

public class YunSuan {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(random.nextInt(10000) + "");
        }

        int group = 4;
        LinkedMultiValueMap<String, String> hash = new LinkedMultiValueMap<>();
        LinkedMultiValueMap<String, String> yu = new LinkedMultiValueMap<>();

        long hashStart = System.currentTimeMillis();
        strings.forEach(item->{
            hash.add((item.hashCode()%group)+"",item);
        });
        long hashEnd = System.currentTimeMillis();

        long yuStart = System.currentTimeMillis();
        int i = group - 1;
        strings.forEach(item->{
            yu.add((item.hashCode()&i)+"",item);
        });
        long yuEnd = System.currentTimeMillis();

        System.out.println("hash组数："+hash.size());
        System.out.println("yu组数："+hash.size());

        System.out.println("hash用时："+(hashEnd-hashStart));
        System.out.println("yu用时："+(yuEnd-yuStart));
    }
}
