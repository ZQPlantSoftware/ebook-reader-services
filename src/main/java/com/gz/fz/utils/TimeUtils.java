package com.gz.fz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String format() {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        return dateFormater.format(date);
    }
}
