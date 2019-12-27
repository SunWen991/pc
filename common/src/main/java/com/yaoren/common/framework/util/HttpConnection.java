package com.yaoren.common.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

;


public class HttpConnection {
    /**
     * 向指定URL发送Post方式的请求
     * @param url 发送请求的URL
     * @param params
     * @return
     */
    public static String sendPost(String url,String params) throws IOException {

            URL realUrl=new URL(url);
            HttpURLConnection conn= (HttpURLConnection) realUrl.openConnection();
            //conn.
            /* 3. 设置请求参数等 */
            // 请求方式
            conn.setRequestMethod("POST");
            // 超时时间
            conn.setConnectTimeout(3000);
            // 设置是否输出
            conn.setDoOutput(true);
            // 设置是否读入
            conn.setDoInput(true);
            // 设置是否使用缓存
            conn.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            conn.setInstanceFollowRedirects(true);
            // 设置编码
            conn.setRequestProperty("Charset","UTF-8");
            // 设置使用标准编码格式编码参数的名-值对
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            // 连接
            conn.connect();
            /* 4. 处理输入输出 */
            // 写入参数到请求中
            OutputStream out = conn.getOutputStream();
            out.write(params.getBytes("utf-8"));
            out.flush();
            out.close();
            // 从连接中读取响应信息
            //String msg = "";
            StringBuilder stringBuilder=new StringBuilder();
            int code = conn.getResponseCode();
            if (code == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                String line=null;
                while ((line = reader.readLine()) != null) {
                    //msg += line;
                    stringBuilder.append(line);
                }
                reader.close();
            }else {
                //msg=conn.getResponseMessage();
                stringBuilder.append(conn.getResponseMessage());
            }
            // 5. 断开连接
            conn.disconnect();
            // 处理结果
            return stringBuilder.toString();
    }

    public static String sendGet(String url,String param){

        return null;
    }

}
