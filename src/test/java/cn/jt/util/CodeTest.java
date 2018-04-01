package cn.jt.util;

import org.junit.Test;
import org.nutz.castor.Castors;
import org.nutz.filepool.FilePool;
import org.nutz.filepool.NutFilePool;
import org.nutz.http.Http;
import org.nutz.http.Response;
import org.nutz.img.Images;
import org.nutz.lang.random.R;
import org.nutz.lang.random.StringGenerator;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class CodeTest {
    public static void main(String[] args) {

    }

    /**
     * 测试字符串
     */
    @Test
    public void StringTest() {
        StringGenerator sg = new StringGenerator(6, 6);
        System.out.println("sg = " + sg.next());

        Segment seg = new CharSegment("XXXXXXXX ${A}  XXXXXX ${B}  XXXXXX ${A} XXXXX");
        seg.set("A", "TxtA").set("B", "TxtB");
        System.out.println(seg.toString());
    }

    @Test
    public void castorTest() {
        System.out.println(Castors.me().castTo("563", int.class));
        System.out.println(Castors.me().castTo("zozohtnt@gmail.com", org.nutz.lang.meta.Email.class));
        System.out.println(Castors.me().castTo("zozohtnt@gmail.com", org.nutz.lang.meta.Email.class));
        Calendar c = Castors.me().castTo("2009-11-12 15:23:12", Calendar.class);
        Response response = Http.get("https://nutz.cn/");
        assertNotNull(response);
        assertNotNull(response.getContent());
        assertNotNull(response.getDetail());
        assertNotNull(response.getHeader());
        assertNotNull(response.getProtocal());
        assertTrue(response.getStatus() > 0);
        assertNotNull(response.getStream());
    }

    @Test
    public void filePoolTest() {
        // 创建文件池
        // 将目录 ~/tmp/myfiles 作为一个文件池的根目录，里面最多同时有2000个文件
        FilePool pool = new NutFilePool("~/tmp/myfiles", 2000);

        // 将目录 ~/tmp/myfiles 作为一个文件池的根目录，里面不限文件
        pool = new NutFilePool("~/tmp/myfiles");
        // 相当于 FilePool pool = new NutFilePool("~/tmp/myfiles", 0);
    }

    @Test
    public void imgTest() {
        BufferedImage img;
        // = Images.createText("检剔");
        String ch = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm!@#$%^&*()-_=+[]{}?/<>.,~·`~！@#￥%&*（）|检剔，杨剑是好人，车前卒，马后炮";
        for (int i = 0; i < ch.length(); i++) {
            int name = ch.charAt(i);
            img = Images.createText(String.valueOf(ch.charAt(i)));
            Images.write(img, new File("D:/img1/" + name + ".png"));
        }

    }
}
