package com.auth.util;

/**
 * 系统常量
 * Created by yuxb on 16/6/4.
 */
public interface Auth {
    String CURRENT_USER="CURRENT_USER";
    /**
     * 资源级别
     *
     */
    interface ResourceLevel {
        int FIRST = 1;
        int SECOND = 2;
        int THIRD =3;
    }
    /**
     * 资源类型
     */
    interface ResourceType{
        String BUTTON="按钮";
        String HERF="超链接";
        String MENU="菜单";
    }

    /**
     * 排序类型
     *
     */
    interface OrderType {
        String ASC = "asc";
        String DESC = "desc";
    }

    /**
     * 日志类型
     *
     */
    interface LogType {
        String QUERY = "查询";
        String MODIFY = "修改";
        String DELETE = "删除";
        String OTHER = "其他";
        String ADD = "新增";
    }

    /**
     * 查询类型
     *
     */
    interface QueryType {
        String LIKE = "like";
        String EQ = "eq";
        String GT = "gt";// >
        String GE = "ge";// >=
        String LT = "lt";// <
        String LE = "le";// <=
        String BETWEEN = "between";
        String IN = "in";
        String AND = "and";
        String OR = "or";
    }
    /**
     * sql操作符查询类型
     *
     */
    interface QuerySqlType {
        String LIKE = "like";
        String EQ = "=";
        String GT = ">";// >
        String GE = ">=";// >=
        String LT = "<";// <
        String LE = "<=";// <=
        String BETWEEN = "between";
        String IN = "in";
        String AND = "and";
        String OR = "or";
    }

    /**
     * 树类型
     *
     */
    interface TreeType {
        /** 同步 */
        String SYN_TREE = "syn";
        /** 异步 */
        String ASY_TREE = "asy";
    }

    /**
     * 是和否
     *
     */
    interface YesOrNo {
        /** 是 */
        String YES = "y";
        /** 否 */
        String NO = "n";

        String NULL = "null";
    }
    /**
     * 选择状态
     */
    interface SelectStatus{
        int SELECT = 1;
        int UNSELECT=0;
        int ALLSELECT=2;
    }
    /**
     * 字典类型
     */
    interface DicType{
        /**普通字典*/
        String NORMARL="normal";
        /**系统字典*/
        String SYSTEM="system";
    }
    /**
     * 数据类型
     *
     */
     interface JavaDataType {
        String STRING = "String";
        String INTEGER = "Integer";
        String LONG = "Long";
        String DOUBLE = "Double";
        String FLOAT = "Float";
    }

    interface LogLevel {
        String INFO="普通";
        String ERROR="严重";
    }
}
