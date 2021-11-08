package com.doris.proxy.jdk;

public class Target implements TargetInterface{
    public void save() {
        System.out.println("target run");
    }
}
