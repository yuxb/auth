package com.auth.exception;

/**
 * Created by yuxb on 16/6/16.
 */
public class InvalidAttributeValueException extends AuthException {
    public InvalidAttributeValueException(String message) {
        super(message);
    }

    public InvalidAttributeValueException(String message, Throwable cause) {
        super(message, cause);

    }
}
