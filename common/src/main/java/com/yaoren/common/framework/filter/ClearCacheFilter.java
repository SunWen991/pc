package com.yaoren.common.framework.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ClearCacheFilter
 * @Description: 不启用缓存过滤器
 * @author zxh
 * @date 2014-12-16
 * 
 */
public class ClearCacheFilter implements Filter
{

    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Cache-Control", "no-cache");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", -1);
        filterChain.doFilter(request, response);
    }

    public void destroy()
    {
    }

}
