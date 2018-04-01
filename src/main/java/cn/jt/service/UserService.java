package cn.jt.service;

import cn.jt.bean.User;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.NameEntityService;

import java.util.List;

/**
 * 处理user相关的数据逻辑
 *
 * @author yangjian
 */

@IocBean(fields = "dao")
public class UserService extends NameEntityService<User> {
    /**
     * 通过用户id获取用户
     *
     * @param userId uuid或者是用户名，手机号都行
     *
     * @return user对象
     */
    public User getUser(String userId) {
        User user = fetch(userId);
        return user;
    }

    /**
     * 通过指定获取用户
     *
     * @param cnd 查询条件
     *
     * @return user对象
     */
    public User getUser(Cnd cnd) {
        User user = fetch(cnd);
        return user;
    }

    /**
     * 根据条件查询符合条件的记录，有返回true，没有返回false
     *
     * @param cnd 查询条件
     *
     * @return t/f
     */
    public boolean isExist(Cnd cnd) {
        return count(cnd) > 0;
    }

    /**
     * 获取全部用户
     *
     * @return
     */
    public List<User> getUsers() {
        return query();
    }
}
