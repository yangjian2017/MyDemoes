package cn.jt.util.base;

import javax.servlet.ServletContext;

/**
 * @author yangjian
 */
public class MyUtil {

    private ServletContext sc;

    public String getPath(String path) {
        return sc.getRealPath(path);
    }
}
