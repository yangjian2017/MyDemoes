package cn.jt.module.config;

import cn.jt.bean.User;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.lang.random.R;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用启动或者关闭时做的个性化处理
 *
 * @author yangjian
 * @date 2018/3/22
 */
public class MySetup implements Setup {

    private Log log = Logs.getLog(MySetup.class);

    @Override
    public void init(NutConfig nutConfig) {
        log.debug("正在初始化···");
        // CustomMake.me().register("ig", ioc.get(RedisIdGenerator.class));
        // UTF8JsonView.CT = "text/plain";

        Ioc ioc = nutConfig.getIoc();
        Dao dao = ioc.get(Dao.class);

        log.debug("正在自动建表···");
        // 检查数据库，如果没有表则根据已有的实体类自动建表
        Daos.createTablesInPackage(dao, "cn.jt.bean", true);
        log.debug("自动建表完成，正在初始化user表的数据···");

        User user1 = new User("元一", "女", 18);
        User user2 = new User("李二", "男", 20);
        User user3 = new User("张三", "男", 19);
        User user4 = new User("李四", "女", 17);
        User user5 = new User("王五", "女", 20);
        User user6 = new User("马六", "男", 19);

        user1.setUsername(R.captchaChar(9, true));
        user2.setUsername(R.captchaChar(9, true));
        user3.setUsername(R.captchaChar(9, true));
        user4.setUsername(R.captchaChar(9, true));
        user5.setUsername(R.captchaChar(9, true));
        user6.setUsername(R.captchaChar(9, true));

        user1.setPhone("1"+R.random(3,9)+R.captchaNumber(9));
        user2.setPhone("1"+R.random(3,9)+R.captchaNumber(9));
        user3.setPhone("1"+R.random(3,9)+R.captchaNumber(9));
        user4.setPhone("1"+R.random(3,9)+R.captchaNumber(9));
        user5.setPhone("1"+R.random(3,9)+R.captchaNumber(9));
        user6.setPhone("1"+R.random(3,9)+R.captchaNumber(9));

        User[] users = {user1,user2,user3,user4, user5,user6};
        dao.insert(users);
        log.debug("初始化完毕。");
    }

    @Override
    public void destroy(NutConfig nutConfig) {
        System.out.println("MySetup.destroy");
    }
}
