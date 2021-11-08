package com.doris.aop;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("target run");
        int i= 1/0;
    }
}
