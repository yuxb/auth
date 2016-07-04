package com.auth.exception;

/**
 * 全局异常所有自定义业务异常都继承此类
 * Created by yuxb on 16/6/20.
 */
public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}


