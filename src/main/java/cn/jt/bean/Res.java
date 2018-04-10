package cn.jt.bean;

/**
 * 对json返回值的封装
 *
 * @author yangjian
 */
public class Res {
    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "成功";
    public static final String ERROR_CODE = "1";
    public static final String ERROR_MSG = "失败";

    private String code;
    private String msg;
    private Object data;

    public Res(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Res(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static Res success() {
        return new Res(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static Res error() {
        return new Res(ERROR_CODE, ERROR_MSG);
    }

    public static Res success(String msg) {
        return new Res(SUCCESS_CODE, msg);
    }

    public static Res error(String msg) {
        return new Res(ERROR_CODE, msg);
    }

    public static Res success(Object data) {
        return new Res(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static Res error(Object data) {
        return new Res(ERROR_CODE, ERROR_MSG, data);
    }

    public static Res success(String msg, Object data) {
        return new Res(SUCCESS_CODE, msg, data);
    }

    public static Res error(String msg, Object data) {
        return new Res(ERROR_CODE, msg, data);
    }

    public static Res error(String code, String msg) {
        return new Res(code, msg);
    }

    public static Res error(String code, String msg, Object data) {
        return new Res(code, msg, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
