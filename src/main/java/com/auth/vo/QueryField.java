package com.auth.vo;

import lombok.Data;

/**
 * Created by yuxb on 16/6/5.
 * 封装前台传过来的查询条件
 */
@Data
public class QueryField {
    /**查询的key 对应javabean对象的field**/
    private String key;
    /**查询的值**/
    private String value;
    /**查询类型,= >= in 等**/
    private String Type;
    public QueryField(){

    }
    public QueryField(String key, String value, String type) {
        this.key = key;
        this.value = value;
        Type = type;
    }


}
