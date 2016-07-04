package com.auth.vo;

import lombok.Data;

/**
 * Created by yuxb on 16/5/20.
 */
@Data
public class ResponseEntity<T> {
    private String code;
    private String info;
    private String error;
    private T data;


}
