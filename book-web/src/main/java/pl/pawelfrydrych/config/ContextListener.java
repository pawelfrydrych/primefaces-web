package pl.pawelfrydrych.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.bridge.SLF4JBridgeHandler;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg) {
	}

}