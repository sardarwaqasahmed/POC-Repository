package org.context;

import javax.servlet.ServletContextEvent;
import org.apache.log4j.Logger;
import org.local.service.impl.rest.AuthService;
import org.springframework.web.context.ContextLoaderListener;
import org.context.SpringUtil;


public class ServletContextListner extends ContextLoaderListener {
	
	private static final Logger logger = Logger.getLogger(AuthService.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event)  {
		
		super.contextInitialized(event);
		SpringUtil.getInstance().setServletContext(event.getServletContext());
		logger.info("Context Intialized");
	}

}
