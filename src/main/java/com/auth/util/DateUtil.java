package com.auth.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by yuxb on 16/6/7.
 */
public class DateUtil {
    private DateUtil(){
        throw new RuntimeException("DateUtil 不可实例化!");
    }
    public final static String FORMAT_DATE="yyyy:mm:dd";
    public final static String FORMAT_DATE_TIME="yyyy:mm:dd hh:mm:ss";

    public static LocalDateTime getCurrentDateTime(){
        return LocalDateTime.now();
    }

    public static String getCurrentDateTimeStr(){
        return getCurrentDateTimeStr(FORMAT_DATE_TIME);
    }
    public static String getCurrentDateTimeStr(String format){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }
    public static LocalDate getCurrentDate(){
        return LocalDate.now();
    }
    public static String getCurrentDateStr(){
        return getCurrentDateStr(FORMAT_DATE);
    }
    public static String getCurrentDateStr(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }



}
