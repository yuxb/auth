package com.auth.util;

import java.time.Instant;


/**
 * 系统App类提供一些全局的系统相关的方法
 * Created by yuxb on 6/25/16.
 */
public class App {
    private static long currentId;
    /**
     * 返回一个唯一标志数字，可用作主键值
     *
     * @return
     */
    public static synchronized long generateId() {
        long id = Instant.now().getEpochSecond();
        if (currentId < id) {
            currentId = id;
        } else {
            currentId++;
        }
        return currentId;
    }
}
