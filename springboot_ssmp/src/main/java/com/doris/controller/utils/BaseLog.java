package com.doris.controller.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseLog {
    private Class clazz;
    public static  Logger log;

    public BaseLog(){
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }

}
