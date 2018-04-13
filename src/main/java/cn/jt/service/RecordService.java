package cn.jt.service;

import cn.jt.bean.Record;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.NameEntityService;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 处理user相关的数据逻辑
 *
 * @author yangjian
 */

@IocBean(fields = "dao")
public class RecordService extends NameEntityService<Record> {
    /**
     * 保存一条记录
     *
     * @return
     */
    public void save(String text,String images) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Record record = new Record(text, images,timestamp);
        _insert(record);
    }

    /**
     * 查询最近一条记录
     *
     * @return user对象
     */
    public Record getLastRecord() {
        Cnd cnd = Cnd.NEW();
        cnd.desc("createTime");
        return fetch(cnd);
    }


}
