package cn.jt.module.config;

import org.nutz.lang.Files;
import org.nutz.lang.Xmls;
import org.nutz.mvc.MessageLoader;
import org.nutz.mvc.impl.NutMessageLoader;
import org.w3c.dom.Document;

import java.util.Map;

/**
 * @author yangjian
 */
public class MyMessageLoader extends NutMessageLoader implements MessageLoader {
    @Override
    public Map<String, Map<String, Object>> load(String refer) {
        System.out.println("loading source from " + refer);
        Map map = super.load(refer);
        return map;
    }
}
