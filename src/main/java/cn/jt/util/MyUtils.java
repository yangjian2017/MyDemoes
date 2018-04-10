package cn.jt.util;

import javax.servlet.ServletContext;

/**
 * @author yangjian
 */
public class MyUtils {

    private ServletContext sc;

    public String getPath(String path) {
        return sc.getRealPath(path);
    }
}
