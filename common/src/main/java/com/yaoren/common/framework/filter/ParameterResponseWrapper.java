package com.yaoren.common.framework.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ParameterResponseWrapper extends HttpServletResponseWrapper {

	private CharArrayWriter ref_charArrayWriter = new CharArrayWriter();
	public ParameterResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
		
	}
	@Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(ref_charArrayWriter);
    }
    public CharArrayWriter getCharArrayWriter() {
        return ref_charArrayWriter;
    }
}
