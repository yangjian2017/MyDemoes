package cn.jt.service;

import cn.jt.bean.base.Res;
import cn.jt.util.DateUtil;
import cn.jt.util.base.MyUtil;
import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.R;
import org.nutz.mvc.upload.TempFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * @author yangjian
 */
@IocBean
public class UploadService {
    public String upload(TempFile tf,String realPath) throws IOException {
        File temp = new File(realPath);
        if (!temp.exists()) {
            temp.mkdirs();
        }

        // 获取文件名和扩展名
        String[] sfn = tf.getSubmittedFileName().split("\\.");
        String fileName = new StringBuilder(DateUtil.getFormatTime(System.currentTimeMillis(),"yyyyMMdd_HHmmss")).append("_").append(R.captchaNumber(6)).append("_").append(sfn[sfn.length-2]).append(".").append(sfn[sfn.length-1])
                .toString();
        // 文件路径
        String filePath = new StringBuilder(temp.getPath()).append("/").append(fileName).toString();

        // 将文件写入到指定路径
        tf.write(filePath);

        return fileName;
    }
}
