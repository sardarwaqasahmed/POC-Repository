package org.context;


import java.util.Map;

import javax.servlet.ServletContext;

import org.local.service.impl.rest.AuthService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.apache.log4j.Logger;


public class SpringUtil {

	private static final Logger logger = Logger.getLogger(AuthService.class);
	private static SpringUtil instance;


	private WebApplicationContext ctx;


	public static SpringUtil getInstance()  {
		synchronized (SpringUtil.class) {
			if (instance == null)  {
				instance = new SpringUtil();
			}
			return instance;
		}
	}

	/**
	 * Provide this class with the servlet
	 * context in which the web app is running.
	 * Must be called before getting beans.
	 * @param context
	 */
	public void setServletContext(ServletContext ctx) {
		
		logger.info("Servlet Context Sets");
		this.ctx = WebApplicationContextUtils.
				getRequiredWebApplicationContext(ctx);
	}


	/**
	 * Get a bean of the given class from spring context,
	 * in the case of multiple beans of same type returns
	 * first instance.
	 * @param <BeanClass>
	 * @param beanClass
	 * @return
	 */
	public <BeanClass> BeanClass getBean(Class<BeanClass> beanClass)  {
		BeanClass bean = null;
		for (BeanClass firstBean : getBeans(beanClass).values())  {
			bean = firstBean;
			break;
		}
		return bean;
	}


	/**
	 * Returns a map<String, BeanClass> of all the
	 * beans of a given type.
	 * @param <BeanClass>
	 * @param beanClass
	 * @return
	 */
	public <BeanClass> Map<String, BeanClass> getBeans(Class<BeanClass> beanClass)  {
		@SuppressWarnings("unchecked")		// needed because springs method is not generic
		Map<String, BeanClass> beansOfType = ctx.getBeansOfType(beanClass);
		return beansOfType;
	}


	/**
	 * Get a bean by a given name.
	 * @param beanId
	 * @return
	 */
	public Object getBeanById(String beanId)  {
		
		logger.info("Getting Bean by id: " +beanId);
		return this.ctx.containsBean(beanId)
					? this.ctx.getBean(beanId)
					: null;   
	}



	public <BeanClass extends Object> void outject(String beanId, BeanClass bean)  {
		ConfigurableApplicationContext outjectCtx = (ConfigurableApplicationContext) getCtx();
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) outjectCtx.getBeanFactory();
		beanFactory.registerSingleton(beanId, bean);
	}


	public WebApplicationContext getCtx() {
		return this.ctx;
	}


	public void setCtx(WebApplicationContext ctx) {
		this.ctx = ctx;
	}
	
	
}
