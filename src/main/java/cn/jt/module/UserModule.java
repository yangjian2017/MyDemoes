package cn.jt.module;

import cn.jt.bean.User;
import cn.jt.service.UserService;
import cn.jt.util.BaseUtil;
import org.apache.log4j.Logger;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户处理类，主要处理和user相关的业务
 *
 * @author yangjian
 */
@At("/user")
@IocBean
public class UserModule {
    Logger log = Logger.getRootLogger();
    @Inject
    UserService userService;

    @At("/hello")
    @Ok("jsp:jsp.hello")
    public User hello(HttpServletRequest request) {
        List<User> users = userService.getUsers();
        log.info("查到的用户信息——\n" + Json.toJson(users));
        return users.get(0);
    }

    /**
     * 查询用户信息
     *
     * @param userId 用户id
     *
     * @return
     */
    @At("/getUserInfo")
    @Ok("json")
    public User getUserInfo(@Param("userId") String userId) {
        User user = userService.getUser(Cnd.NEW().and("uuid",BaseUtil.EQ,userId));
        return user;
    }
}
