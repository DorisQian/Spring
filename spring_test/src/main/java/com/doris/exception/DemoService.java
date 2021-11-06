package com.doris.exception;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Component("demoService")
public class DemoService {

    public void show1(){
        Object str = "zhangsan";
        Integer num = (Integer) str;
    }

    public void show2(){
        int i = 1/0;
    }

    public void show3() throws FileNotFoundException {
        InputStream in = new FileInputStream("Usr/nam.txt");
    }

    public void show4(){
        String str = null;
        str.length();
    }

    public void show5() throws MyException {
        throw new MyException();
    }
}
