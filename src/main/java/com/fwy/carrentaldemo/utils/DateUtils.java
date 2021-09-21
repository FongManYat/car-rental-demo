package com.fwy.carrentaldemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");

    public static Date currDate() throws ParseException {
         return sdf.parse(sdf.format(new Date()));
    }

    public static Date strToDate(String str) throws ParseException {
        return sdf.parse(str);
    }

    public static String dateToStr(Date date) throws ParseException {
        return ymd.format(date);
    }
}
