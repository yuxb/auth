package com.auth.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuxb on 16/6/8.
 */

public class TestDateUtil {
    static Logger  log= LoggerFactory.getLogger(TestDateUtil.class);
    public static void main(String[] args) {
        log.debug("tt55t");
        TestDateUtil t=new TestDateUtil();
        TestDateUtil b=t;
        toNUll(b);
        System.out.println(t);

    }
    public static void toNUll(TestDateUtil t){
        t=null;
    }
}
