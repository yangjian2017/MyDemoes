package cn.jt.module;

import cn.jt.module.config.MyMessageLoader;
import cn.jt.module.config.MySetup;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.*;


/**
 * 主模块入口
 *
 * @author yangjian
 * @date 2018/3/22
 */
@Localization(value = "local/", defaultLocalizationKey = "zh_CN", type = MyMessageLoader.class)
@Modules
@IocBy(args = {"*js",
        "ioc/dao.js",
        "ioc/service.js",
        "*anno",
        "cn.jt.module",
        "cn.jt.service"})
@SetupBy(value = MySetup.class)
public class MainModule {

    /**
     * 设置一个本地字符串
     *
     * @param lang 语言——如，ch_CN代表中文简体，en_US代表英文
     */
    @At("/lang/change")
    @Ok("redirect:/")
    public void changeLocal(@Param("lang") String lang) {
        Mvcs.setLocalizationKey(lang);
    }

}

