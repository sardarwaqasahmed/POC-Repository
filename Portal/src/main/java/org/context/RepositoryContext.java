package org.context;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.test.context.ContextLoader;

public class RepositoryContext implements ContextLoader {

	/** The logger. */
	private static Logger logger = Logger.getLogger(RepositoryContext.class);

	/** The context. */
	private static GenericApplicationContext context = init();

	/**
	 * Initialize the Application Context.
	 * 
	 * @return {@link ApplicationContext}
	 */

	private static GenericApplicationContext init() {

		RepositoryContext context = new RepositoryContext();
		String configLocations[] = new String[] { "classpath:repositoryContext.xml" };
		try {
			context.loadContext(configLocations);
		} catch (Exception ex) {
			logger.info(ex.getMessage());
			logger.error(ex.getStackTrace());
		} catch (Throwable ex) {
			logger.info(ex.getMessage());
			logger.error(ex.getStackTrace());
		}
		return getContext();
	}

	/**
	 * Return object from the ApplicationContext with the provided name or Null
	 * would be returned if no object with this name is registered in the
	 * context.
	 * 
	 * @param name
	 *            the name
	 * @return the bean
	 */
	public static Object getBean(String name) {
		return context.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		logger.debug("Getting bean... " + clazz);
		return context.getBean(clazz);
	}

	/**
	 * Gets the context.
	 * 
	 * @return the context
	 */
	public static GenericApplicationContext getContext() {
		return context;
	}

	/**
	 * Sets the context.
	 * 
	 * @param contexts
	 *            the contexts
	 * @return the generic application context
	 */
	public static GenericApplicationContext setContext(
			GenericApplicationContext contexts) {
		return context = contexts;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.context.ContextLoader#loadContext(java.lang.
	 * String[])
	 */
	@Override
	public ApplicationContext loadContext(String... locations) throws Exception {
		if (getContext() == null) {
			final GenericApplicationContext context = new GenericApplicationContext();
			createBeanDefinitionReader(context).loadBeanDefinitions(locations);
			AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
			context.refresh();
			context.registerShutdownHook();
			String[] beanNames = context.getBeanDefinitionNames();
			logger.info("Spring Context Loaded " + beanNames.length + " Beans");
			for (String beanName : beanNames) {
				logger.info("====> " + beanName);
			}
			setContext(context);
		}
		return getContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.context.ContextLoader#processLocations(java.
	 * lang.Class, java.lang.String[])
	 */
	@Override
	public String[] processLocations(Class<?> clazz, String... locations) {
		// TODO Auto-generated method stub
		return locations;
	}

	/**
	 * Creates the bean definition reader.
	 * 
	 * @param context
	 *            the context
	 * @return the bean definition reader
	 */
	protected static BeanDefinitionReader createBeanDefinitionReader(
			final GenericApplicationContext context) {
		AbstractBeanDefinitionReader reader = new XmlBeanDefinitionReader(
				context);
		reader.setResourceLoader(new FileSystemResourceLoader());
		return reader;
	}

}
