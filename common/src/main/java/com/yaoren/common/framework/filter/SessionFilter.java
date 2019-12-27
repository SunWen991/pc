package com.yaoren.common.framework.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @ClassName: SessionFilter
 * @Description: 用户登录检查过滤器
 * @author zxh
 * @date 2014-12-16
 * 
 */
public class SessionFilter implements Filter
{

    /**
     * 要检查的session的名称
     */
    private String sessionKey;

    /**
     * 需要排除的URL的正则表达式（不拦截）
     */
    private Pattern exceptUrlPattern;

    /**
     * 忽略检查的格式类型
     */
    private String[] ignoreTypes;

    /**
     * 检查不通过时跳转至登录URL
     */
    private String loginUrl;

    public void init(FilterConfig cfg) throws ServletException
    {
        sessionKey = cfg.getInitParameter("sessionKey");

        String exceptUrlRegex = cfg.getInitParameter("exceptUrlRegex");
        if (!StringUtils.isBlank(exceptUrlRegex))
        {
            exceptUrlPattern = Pattern.compile(exceptUrlRegex);
        }

        String ignoreTypes = cfg.getInitParameter("ignoreTypes");
        if (!StringUtils.isBlank(ignoreTypes))
        {
            this.ignoreTypes = ignoreTypes.split(",");
        }

        loginUrl = cfg.getInitParameter("loginUrl");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String servletPath = request.getServletPath();
        String contextPath = request.getContextPath();

        // 如果sessionKey为空，则直接放行
        if (StringUtils.isBlank(sessionKey))
        {
            chain.doFilter(req, res);
            return;
        }

        Object sessionObj = request.getSession().getAttribute(sessionKey);
        // 如果Session不为空，直接放行
        if (sessionObj != null)
        {
            chain.doFilter(req, res);
            return;
        }

        //注册时可能需要放行
        // 如果请求的路径与loginUrl相同，则直接放行
        if (servletPath.indexOf(loginUrl) > -1)
        {
            chain.doFilter(req, res);
            return;
        }
        // 如果请求的路径是排除的URL时，则直接放行
        if (exceptUrlPattern.matcher(servletPath).matches())
        {
            chain.doFilter(req, res);
            return;
        }

        // 如果是忽略的格式类型，则直接放行
        if (ignoreTypes != null)
        {
            for (int i = 0; i < ignoreTypes.length; i++)
            {
                if (servletPath.endsWith("." + ignoreTypes[i]))
                {
                    chain.doFilter(req, res);
                    return;
                }
            }
        }

        //  重动向到登陆页面
        response.sendRedirect("http://192.168.3.177:8080/");

        /*String head = request.getHeader("x-requested-with");
        if(head!=null && head.equalsIgnoreCase("XMLHttpRequest")){ 
        	response.sendError(999); 
        } */

        // 否则跳转至登录界面()
        /*PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('" + contextPath + StringUtils.defaultIfEmpty(loginUrl, "/")
                + "','_top')");
        out.println("</script>");
        out.println("</html>");*/
    }

    public void destroy()
    {
    }

}
