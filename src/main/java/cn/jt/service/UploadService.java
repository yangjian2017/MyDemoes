package cn.jt.service;

import cn.jt.bean.Res;
import org.nutz.mvc.upload.TempFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangjian
 */
public class UploadService {

    /**
     * 上传文件
     *
     * @param tf
     *
     * @return
     */
    public Res uploadFile(TempFile tf) {
        try {
            String filePath = upload(tf);
            return Res.success("上传成功", filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return Res.error("上传失败：" + e.getMessage());
        }


    }

    /**
     * 上传多个文件
     *
     * @param tfs
     *
     * @return
     */
    public Res uploadFile(TempFile[] tfs) {
        try {
            String filePath = "";
            for (TempFile tf : tfs) {
                filePath += upload(tf) + ",";
            }

            // 去掉最后一个逗号
            filePath = filePath.substring(0, filePath.length() - 1);
            return Res.success("上传成功", filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return Res.error("上传失败：" + e.getMessage());
        }
    }

    private String upload(TempFile tf) throws IOException {
        String dir = "D:/images";
        File temp = new File(dir);
        if (!temp.exists()) {
            temp.mkdirs();
        }

        String[] postfix = tf.getSubmittedFileName().split("\\.");
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 将文件写入到指定路径
        String fullPath = temp.getPath() + "\\" + postfix[postfix.length - 2] + date + "." + postfix[postfix.length - 1];
        tf.write(fullPath);

        return fullPath;
    }
}
