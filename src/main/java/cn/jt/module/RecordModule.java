package cn.jt.module;

import cn.jt.bean.Record;
import cn.jt.bean.Res;
import cn.jt.service.RecordService;
import cn.jt.service.UploadService;
import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

/**
 * @author yangjian
 */
@At("/record")
@IocBean
public class RecordModule {
    Logger log = Logger.getRootLogger();
    @Inject
    RecordService recordService;

    @Inject
    UploadService uploadService;

    /**
     * 保存记录
     *
     * @param text   文本
     * @param images 图片，最多九张，多个用“,"分隔
     */
    @At("/save")
    @Ok("json")
    public void save(@Param("text") String text, @Param("images") String images) {
        recordService.save(new Record(text, images));
    }

    /**
     * 查询记录
     *
     * @return
     */
    @At("/getLastRecord")
    @Ok("json")
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

    @At("/uploadImage")
    @Ok("json")
    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
    public Res uploadImage(@Param("image") TempFile tf) {
        return uploadService.uploadFile(tf);
    }

    @At("/uploadImages")
    @Ok("json")
    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
    public Res uploadImages(@Param("img") TempFile[] tfs) {
        return uploadService.uploadFile(tfs);
    }
}
