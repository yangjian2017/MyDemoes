package cn.jt.util;

import org.nutz.dao.Cnd;

/**
 * 基类
 *
 * @author yangjian
 */
public abstract class BaseUtil {
    /**
     * 常用操作符封装
     */
    public static final String EQ = "=";
    public static final String NEQ = "!=";
    public static final String LT = "<";
    public static final String LTE = "<=";
    public static final String GT = ">";
    public static final String GTE = ">=";
    public static final String LIKE = "like";

    public static String getLike(String string) {
        return "%" + string + "%";
    }

    public static String getLike(Number number) {
        return "%" + number + "%";
    }

    public static Cnd getCnd(String key,String op,Object val) {
        return Cnd.NEW().and(key,op,val);
    }
}
