package com.doris.aop.anno;

import org.springframework.stereotype.Component;

@Component
public class Target implements TargetInterface {
    public void save() {
        System.out.println("target run");
        int i= 1/0;
    }
}
