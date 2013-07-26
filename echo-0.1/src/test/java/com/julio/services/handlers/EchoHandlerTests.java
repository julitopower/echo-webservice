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
