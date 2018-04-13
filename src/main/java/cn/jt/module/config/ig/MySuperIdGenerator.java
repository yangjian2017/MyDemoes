package cn.jt.module.config.ig;

import org.nutz.el.opt.RunMethod;
import org.nutz.ioc.loader.annotation.IocBean;

import java.util.List;

/**
 * @author yangjian
 */
@IocBean
public class MySuperIdGenerator implements RunMethod {
    @Override
    public Object run(List<Object> list) {
        // 如果需要自定义生成策略，需要在MySetup中加入代码：CustomMake.me().register("ig", ioc.get(MySuperIdGenerator.class));
        return null;
    }

    @Override
    public String fetchSelf() {
        return "ig";
    }
}
