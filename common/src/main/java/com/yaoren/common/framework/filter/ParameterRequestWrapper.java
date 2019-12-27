package com.yaoren.common.framework.filter;

import com.yaoren.common.framework.util.AES;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParameterRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> params = new HashMap<String, String[]>();
	private String decodeStr = null;// 被解密的请求体数据

	public ParameterRequestWrapper(HttpServletRequest request)
			throws IOException {
		// 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
		super(request);
		jsonUtil(request);
		// 将参数表，赋予给当前的Map以便于持有request中的参数
		this.params.putAll(request.getParameterMap());
	}

	// 重载一个构造方法
	public ParameterRequestWrapper(HttpServletRequest request,
			Map<String, Object> extendParams) throws IOException {
		this(request);
		addAllParameters(extendParams);// 这里将扩展参数写入参数表
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub

		// InputStream tInputStringStream = new
		// ByteArrayInputStream(sb.toString().getBytes());
		// System.out.println("decodeStr:"+decodeStr);
		return new ServletInputStream() {
			byte byte_[] = decodeStr.getBytes("utf-8");
			int length_ = byte_.length;
			int a = 0;

			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				if (a == length_) {
					return -1;
				} else {
					return byte_[a++];
				}
			}
		};
	}

	@Override
	public String getParameter(String name) {// 重写getParameter，代表参数从当前类中的map获取
		String[] values = params.get(name);
		if (values == null || values.length == 0) {
			return null;
		}
		return values[0];
	}

	public String[] getParameterValues(String name) {// 同上
		return params.get(name);
	}

	public void addAllParameters(Map<String, Object> otherParams) {// 增加多个参数
		for (Map.Entry<String, Object> entry : otherParams.entrySet()) {
			addParameter(entry.getKey(), entry.getValue());
		}
	}

	public void addParameter(String name, Object value) {// 增加参数
		if (value != null) {
			if (value instanceof String[]) {
				params.put(name, (String[]) value);
			} else if (value instanceof String) {
				params.put(name, new String[] { (String) value });
			} else {
				params.put(name, new String[] { String.valueOf(value) });
			}
		}
	}

	private void jsonUtil(HttpServletRequest request)
			throws UnsupportedEncodingException, IOException {
		// = IOUtils.toByteArray(request.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		StringBuilder sb = new StringBuilder();// 包含请求数据
		String st = null;
		while ((st = br.readLine()) != null) {
			sb.append(st);
		}
		if (br != null) {
			br.close();
		}
		String str = sb.toString();
		System.out.println(new Date() + ":" + str);
		str = str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
		decodeStr = AES.decode(str);
		System.out.println(new Date() + ":" + decodeStr);
	}
}
