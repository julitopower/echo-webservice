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

package com.julio.services.handlers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EchoHandlerTests {

	private EchoHandler handler;
	private String rawText;
	private static final String JSON_PATTERN = "{\"echo\":\"%s\"}";
	
	@Before
	public void setup() {
		handler = new EchoHandler();
		rawText = "";
	}
	
	@Test
	public void testGivenCleanStringThenProducesValidJson() {
		rawText = "Clean String";
		Assert.assertEquals(String.format(JSON_PATTERN, rawText), handler.escapeGet(rawText));
	}
	
	@Test
	public void testGivenEmptyStringThenProducesValidJson() {
		rawText = "";
		Assert.assertEquals(String.format(JSON_PATTERN, rawText), handler.escapeGet(rawText));
	}
	
	@Test
	public void testGivenNullStringThenProducesValidJson() {
		rawText = null;
		Assert.assertEquals(String.format(JSON_PATTERN, rawText), handler.escapeGet(rawText));
	}
	
	@Test
	public void testGivenStringWithDoubleQuotesThenProducesValidJson() {
		rawText = "Hi there \"you\"";
		Assert.assertEquals(String.format(JSON_PATTERN, "Hi there \\\"you\\\""), handler.escapeGet(rawText));
	}
}
