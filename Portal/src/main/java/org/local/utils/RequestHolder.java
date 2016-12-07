package org.local.utils;

import javax.servlet.ServletRequest;

public class RequestHolder {

	private static ThreadLocal<ServletRequest> threadLocal = new ThreadLocal<ServletRequest>();

	public static void setRequest(ServletRequest request) {
		threadLocal.set(request);
	}

	public static ServletRequest getRequest() {
		return threadLocal.get();
	}

}
