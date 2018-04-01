var ioc = {
    conf:{
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["db.properties"]
            //paths : ["custom/"]
        }
    },
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        args : [{refer:"druidDataSource"}],
        fields:{
            interceptors : [
                "log", // 默认的日志还需要的
                "time" // 加个时间又如何呢?
                // "net.demo.MyDaoInterceptor", // 加入自己的,才合适
                // {refer:"superI"} // 引用另外一个bean作为拦截器
            ]
        }
    },
    druidDataSource : {
        factory:"$conf#make",
        type : "com.alibaba.druid.pool.DruidDataSource",
        args : ["com.alibaba.druid.pool.DruidDataSource", "db."],
        events : {
            create : "init",
            depose : 'close'
        }
    }
};