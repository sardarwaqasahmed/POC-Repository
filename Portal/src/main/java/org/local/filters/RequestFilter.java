package org.local.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.local.utils.RequestHolder;

public class RequestFilter implements Filter {

	private static final Logger logger = Logger.getLogger(RequestFilter.class);
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Enumeration<String> enumeration = request.getParameterNames();
		RequestHolder.setRequest(request);
		logger.info("<----------- PARAMETER LIST ------------>");
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			String value = request.getParameter(key);
			logger.info("Parameter: " + key + " Value: " + value);
		}
		long end = System.currentTimeMillis();
		arg2.doFilter(request, response);
		logger.info("Request: " + httpServletRequest.getPathInfo() + " taken "
				+ (end-startTime) + "ms");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
