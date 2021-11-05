package com.doris.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//<String转前的格式, Date转换后的格式>
public class DateConverter implements Converter<String, Date> {

    public Date convert(String dateStr) {
        //字符串转换成date对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }
}
