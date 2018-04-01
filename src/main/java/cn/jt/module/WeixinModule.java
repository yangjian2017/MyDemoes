package cn.jt.module;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.weixin.impl.BasicWxHandler;
import org.nutz.weixin.spi.WxHandler;
import org.nutz.weixin.util.Wxs;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yangjian
 */
@IocBean
@At("/weixin")
public class WeixinModule { // 并不要求你继承任何东西

    /**
     * wxHandler是被动请求的主要处理类, 里面写的1234567890就是"接口配置信息"里面提到的"token",
     */
    protected WxHandler wxHandler = new BasicWxHandler("1234567890");

    // 拼起来的全路径就是 /weixin/msgin
    @At
    public View msgin(HttpServletRequest req) throws IOException {

        // 最后面的default,可以不写,只是个标识符.
        return Wxs.handle(wxHandler, req, "default");
    }
}