package org.local.filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.authenticater.AuthenticaterImpl;
import org.local.service.impl.rest.AuthServiceJasonImpl;
import org.model.User;

public class ValidationFilter implements Filter {
	private static final Logger logger = Logger
			.getLogger(ValidationFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		String path = ((HttpServletRequest) request).getRequestURI();
		logger.info("the requested uri is: " + path);

		if (path.equals("/portal/api/auth/jason/getAuthenticate")) {
			chain.doFilter(request, response);
		} else {

			String token = request.getParameter("token");
			try {
				User user = AuthenticaterImpl.getInstance().verfiyToken(token);
				if (user != null) {
					logger.info("userNAme: "
							+ user.getUserName()
							+ " has been verified through the Validation filter");
					AuthServiceJasonImpl.messageFlag=true;
					chain.doFilter(request, response);
					
				} else {

					logger.info("User cannot be verified");
					AuthServiceJasonImpl.messageFlag=false;
					chain.doFilter(request, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
