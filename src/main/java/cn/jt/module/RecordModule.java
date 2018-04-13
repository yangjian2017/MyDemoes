package cn.jt.module;

import cn.jt.bean.Record;
import cn.jt.bean.base.Res;
import cn.jt.service.RecordService;
import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;

import java.sql.Timestamp;


/**
 * @author yangjian
 */
@At("/record")
@IocBean
public class RecordModule {
    Logger log = Logger.getRootLogger();

    @Inject
    RecordService recordService;

    /**
     * 保存记录
     *
     * @param text   文本
     * @param images 图片，最多九张，多个用“,"分隔
     */
    @At(value = "/save")
    @POST
    @Ok("json")
    public String save(@Param("text") String text, @Param("images") String images) {
        try {
            recordService.save(text,images);
            return Res.SUCCESS_MSG;
        }catch (Exception e){
            e.getMessage();
            return Res.ERROR_MSG;
        }
    }

    /**
     * 查询记录
     *
     * @return
     */
    @At("/getLastRecord")
    @Ok("json:full")
    public Res getLastRecord() {
        try {
            Record record = recordService.getLastRecord();
            return Res.success(record);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("获取最后一条记录发送异常：" + e.getMessage());
            return Res.error(e.getMessage());
        }
    }


    /**
     * 调整到记录查询页
     *
     * @return
     */
    @At("")
    @Ok("jsp:jsp.record")
    public Record toPage() {
        try {
            return recordService.getLastRecord();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("获取最后一条记录发送异常：" + e.getMessage());
            return null;
        }
    }
}
