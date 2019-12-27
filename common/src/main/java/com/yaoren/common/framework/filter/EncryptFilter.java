package com.yaoren.common.framework.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.yaoren.common.framework.util.AES;

/**
 * Servlet Filter implementation class Encrypt
 */

public class EncryptFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public EncryptFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		ParameterResponseWrapper ref_charResponse=new ParameterResponseWrapper((HttpServletResponse)response);
		// pass the request along the filter chain
		chain.doFilter(request, ref_charResponse);
		PrintWriter out =response.getWriter();
        out.write(AES.encode(ref_charResponse.getCharArrayWriter().toString()));
		out.flush();
		out.close();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
