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

    public static Cnd getCndEQ(String key,Object val) {
        return Cnd.NEW().and(key,EQ,val);
    }
    public static Cnd getCndNEQ(String key,Object val) {
        return Cnd.NEW().and(key,NEQ,val);
    }
    public static Cnd getCndLT(String key,Object val) {
        return Cnd.NEW().and(key,LT,val);
    }
    public static Cnd getCndLTE(String key,Object val) {
        return Cnd.NEW().and(key,LTE,val);
    }
    public static Cnd getCndGT(String key,Object val) {
        return Cnd.NEW().and(key,GT,val);
    }
    public static Cnd getCndGTE(String key,Object val) {
        return Cnd.NEW().and(key,GTE,val);
    }
    public static Cnd getCndLIKE(String key,Object val) {
        return Cnd.NEW().and(key,LIKE,val);
    }
}
