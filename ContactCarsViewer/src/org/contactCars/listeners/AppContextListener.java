package org.contactCars.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.contactCars.dal.DataAccess;

public class AppContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Cars start");
		DataAccess.init();
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		DataAccess.close();
		System.out.println("Cars end");
	}
}
