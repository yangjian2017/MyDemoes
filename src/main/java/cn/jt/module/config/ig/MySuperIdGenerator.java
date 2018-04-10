package cn.jt.module.config.ig;

import org.nutz.el.opt.RunMethod;

import java.util.List;

/**
 * @author yangjian
 */
public class MySuperIdGenerator implements RunMethod {
    @Override
    public Object run(List<Object> list) {
        return null;
    }

    @Override
    public String fetchSelf() {
        return "ig";
    }
}
