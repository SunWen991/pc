package com.heidian.reptile;

import com.heidian.backstage.domain.GlobalVariable;
import jdk.internal.org.xml.sax.SAXException;

import java.io.*;

/**
 * @date ：Created in 2019/12/19 20:05
 * @description：phantomjs工具
 * @modified By：
 * @version: 1.0.0$
 */
public class JSUtil
{

    // 如果要更换运行环境，请注意exePath最后的phantom.exe需要更改。因为这个只能在window版本上运行。前面的路径名
    // 也需要和exePath里面的保持一致。否则无法调用
    private static String projectPath = "E:\\IDEAProject\\phantomjs";
    private static String jsPath = projectPath + File.separator + "huicong.js";
    private static String exePath = projectPath + File.separator + "phantomjs" + File.separator + "bin" + File.separator
            + "phantomjs.exe";

    public static void main(String[] args) throws IOException, SAXException
    {
        // 测试调用。传入url即可
        String html = getParseredHtml2("https://weibo.com/p/1005053192137663/info?mod=pedit_more");
        System.out.println("html: " + html);
    }

    // 调用phantomjs程序，并传入js文件，并通过流拿回需要的数据。
    public static String getParseredHtml2(String url) throws IOException
    {

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(exePath + " " + jsPath + " " + url);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null)
        {
            sbf.append(tmp);
        }

        /*String[] result = sbf.toString().split("companyServiceMod");
        String result2 = "";
        if(result.length >= 2)
        {
            result2 = result[1];
            if(result2.length() > 200)
            {
                result2 = result2.substring(0, 200);
            }
        }*/

        return sbf.toString();
    }

}

