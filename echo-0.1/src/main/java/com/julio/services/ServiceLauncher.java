package com.julio.services;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

/**
 * For Jetty 8 (Jetty 9 is better but it requires Java 7, which I don't have in
 * my system).
 * 
 * This class encapsulates the wiring of Jetty and Jersey. It is currently very
 * basic, but will be enhanced with SSL, limit in the number of connections,
 * setters to inject properties via Spring, etc, ...
 * 
 */
public class ServiceLauncher {

	private Server server;
	private int httpPort = 8080;

	public void init() throws Exception {
		server = new Server();

		SelectChannelConnector httpConnector = setupConnector();	

		ServletContextHandler handler = setupJerseyServlet();
		
		server.setConnectors(new Connector[] { httpConnector });
		server.setHandler(handler);

		server.start();
		server.join();
	}

	private ServletContextHandler setupJerseyServlet() {
		ServletHolder jerseyServletHolder = new ServletHolder(ServletContainer.class);
		jerseyServletHolder.setInitParameter(
				"com.sun.jersey.config.property.packages",
				"com.julio.services.handlers");		
		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(jerseyServletHolder, "/*");
		return handler;
	}

	private SelectChannelConnector setupConnector() {
		SelectChannelConnector httpConnector = new SelectChannelConnector();
		httpConnector.setPort(httpPort);
		return httpConnector;
	}

}
