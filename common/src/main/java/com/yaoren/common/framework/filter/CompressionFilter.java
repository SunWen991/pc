package com.yaoren.common.framework.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @ClassName: CompressionFilter
 * @Description: 数据压缩过滤器
 * @author zxh
 * @date 2014-12-16
 * 
 */
public class CompressionFilter implements Filter
{

    public void init(FilterConfig config) throws ServletException
    {
    }

    /**
     * 如果浏览器不支持 gzip 压缩，则不做直接放行（不做压缩处理）<br>
     * 反之，将HTTP响应头的编码设置为 <code>gzip</code>，然后将响应数据使用 gzip 进行压缩处理。
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (!isGzipSupported(req))
        {
            chain.doFilter(req, res);
            return;
        }

        // 将响应头信息中的内容编码设置为 gzip
        res.setHeader("Content-Encoding", "gzip");

        // 调用资源，使用 CharArrayWrapper 包装输出
        CharArrayWrapper responseWrapper = new CharArrayWrapper(res);
        chain.doFilter(req, responseWrapper);
        // 取得存放输出数据的 char 型数组
        char[] responseChars = responseWrapper.toCharArray();

        // 将响应数据压缩后存入一个 byte 型的数组，然后输出到
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        GZIPOutputStream zipOut = new GZIPOutputStream(byteStream);
        OutputStreamWriter tempOut = new OutputStreamWriter(zipOut);
        // 将原来的响应数据压缩后写入二字节输出流
        tempOut.write(responseChars);
        // 关闭输出流
        tempOut.close();

        // 更新响应头信息中 Content-Length 的值。
        res.setContentLength(byteStream.size());
        // 将压缩后的数据发送至客户端
        OutputStream realOut = res.getOutputStream();
        byteStream.writeTo(realOut);
    }

    public void destroy()
    {
    }

    /**
     * 检测浏览器是否支持 Gzip 压缩
     * 
     * @param req HTTP 请求对象
     * @return 如果浏览器支持 Gzip 压缩，则返回 true，反之，则返回 false
     */
    private boolean isGzipSupported(HttpServletRequest req)
    {
        String browserEncodings = req.getHeader("Accept-Encoding");
        return ((browserEncodings != null) && (browserEncodings.indexOf("gzip") != -1));
    }

    /**
     * 
     * @ClassName: CharArrayWrapper
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author zxh
     * @date 2014-12-16
     * 
     */
    class CharArrayWrapper extends HttpServletResponseWrapper
    {
        private CharArrayWriter charWriter;

        public CharArrayWrapper(HttpServletResponse response)
        {
            super(response);
            charWriter = new CharArrayWriter();
        }

        @Override
        public PrintWriter getWriter()
        {
            return new PrintWriter(charWriter);
        }

        @Override
        public String toString()
        {
            return charWriter.toString();
        }

        /** Get the underlying character array. */
        public char[] toCharArray()
        {
            return charWriter.toCharArray();
        }
    }
}
