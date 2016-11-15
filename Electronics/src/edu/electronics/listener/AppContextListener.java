package edu.electronics.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.electronics.dal.DataAccess;

public class AppContextListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		DataAccess.init();
	}

}
