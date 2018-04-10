package cn.jt.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 */
public class HttpUtil {

    /**
     * 通过post方式来发送http请求
     * @param url
     * @param param
     * @return
     */
    public static String sendHttpReqByPost(String url, String param) {
        String result = "";
        try {
            URL u0 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u0.openConnection();
            conn.setRequestMethod("POST");
            byte contentbyte[] = param.getBytes();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestProperty("Content-Length", (new StringBuilder()).append(contentbyte.length).toString());
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(60000);
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bWriter.write(param);
            bWriter.flush();
            bWriter.close();
            InputStream in = conn.getInputStream();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i != -1; ) {
                i = in.read();
                if (i != -1) {
                    buffer.append((char) i);
                }
            }
            in.close();
            result = new String(buffer.toString().getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    /**
     *通过get方式来发送http请求
     * @param url
     * @param param
     * @return
     */
    public static String sendHttpReqByGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            if (StringUtils.isNotEmpty(param)) {
                url += "?" + param;
            }
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result;
    }
}
