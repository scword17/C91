package com.conhj.B;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {
    @Override
    public void eat() {
        System.out.println("开始吃饭");
        System.out.println(2/0);
    }
    @Override
    public void fruit(String s){
        System.out.println("我要吃"+s);
    }

    @Override
    public String drunk(String s) {
        System.out.println(s);
        String s2=s+"OK";
        return s2;
    }
}