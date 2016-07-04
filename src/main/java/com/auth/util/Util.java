package com.auth.util;

/**
 * Created by yuxb on 16/6/17.
 */
public class Util {
    public static boolean isNull(Object obj){
        return null==obj||"".equals(obj);
    }

    public static boolean notNull(Object obj){
        return !isNull(obj);
    }
}
