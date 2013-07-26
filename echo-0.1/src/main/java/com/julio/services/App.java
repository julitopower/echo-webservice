package com.julio.services;

/**
 * This Application is a very simple Restful web service.
 * Its purpose is to experiment with the different technologies
 * in an effort to build a framework that will hide all the
 * "REST" from the actual service code.
 *
 */
public class App 
{
	public static void main(String args[]) throws Exception {
		ServiceLauncher launcher = new ServiceLauncher();
		launcher.init();
	}
}
