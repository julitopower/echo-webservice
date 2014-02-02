/*
 * Jave/Jersey based REST Echo service.
 * Copyright (C) 2013-2014, Julio Delgado <julio.delgadomangas@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
