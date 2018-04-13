package cn.jt.module.config;

import cn.jt.bean.User;
import cn.jt.module.config.ig.MySuperIdGenerator;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.el.opt.custom.CustomMake;
import org.nutz.ioc.Ioc;
import org.nutz.lang.random.R;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.mvc.view.UTF8JsonView;

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

        Ioc ioc = nutConfig.getIoc();
        Dao dao = ioc.get(Dao.class);

        log.debug("正在自动建表···");
        // 检查数据库，如果没有表则根据已有的实体类自动建表
        Daos.createTablesInPackage(dao, "cn.jt.bean", false);

        log.debug("初始化完毕。");
    }

    @Override
    public void destroy(NutConfig nutConfig) {
        System.out.println("MySetup.destroy");
    }
}
