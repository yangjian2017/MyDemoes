package cn.jt.module;

import cn.jt.bean.base.Res;
import cn.jt.service.UploadService;
import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 上传文件
 *
 * @author yangjian
 */
@IocBean
public class UploadModule {
    Logger log = Logger.getRootLogger();

    @Inject
    UploadService uploadService;

    @At("/uploadImage")
    @Ok("json")
    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
    public Res uploadImage(@Param("file") TempFile tf, HttpServletRequest request,ServletContext servletContext) {
        try {
            String realPath = servletContext.getRealPath("/images");
            String fileName = uploadService.upload(tf,realPath);
            String fullPath = new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
                    .append(":").append(request.getServerPort()).append(request.getContextPath()).append("/images/").append(fileName).toString();
            log.debug("上传成功，文件路径：" + fullPath);
            NutMap map = new NutMap().setv("name",tf.getName()).setv("url",fullPath);
            return Res.success("上传成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            return Res.error("上传失败：" + e.getMessage());
        }
    }

    @At("/uploadImages")
    @Ok("json")
    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
    public Res uploadImages(@Param("file") TempFile[] tfs, HttpServletRequest request,ServletContext servletContext) {
        try {
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
            String realPath = servletContext.getRealPath("/images");
            StringBuilder fullPath = new StringBuilder();
            for (TempFile tf : tfs) {
                String fileName = uploadService.upload(tf,realPath);
                fullPath.append(basePath).append(fileName).append(",");
            }

            // 去掉最后一个逗号
            String filePath = fullPath.toString().substring(0, fullPath.length() - 1);
            log.debug("上传成功，文件路径：" + filePath);
            return Res.success("上传成功", filePath);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            return Res.error("上传失败：" + e.getMessage());
        }
    }
}
