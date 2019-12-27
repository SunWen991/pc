package com.yaoren.common.framework.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet Filter implementation class DecAndEnc
 */

public class DecAndEncFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public DecAndEncFilter() {
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
		chain.doFilter(new ParameterRequestWrapper((HttpServletRequest) request), ref_charResponse);
		PrintWriter out =response.getWriter();
		String encode_json=jsonUtil(ref_charResponse.getCharArrayWriter().toString());
		System.out.println(new Date()+":"+encode_json);
        out.write(encode_json);
		out.flush();
		out.close();
	}
	@SuppressWarnings("unchecked")
	private String jsonUtil(String json){
		/*Map<String,String> map=JSON.parseObject(json,Map.class);
		map.put("data", AES.encode(map.get("data").toString()));
		return JSON.toJSONString(map);*/
		return "";
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
