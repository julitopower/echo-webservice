package com.julio.services.handlers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A very simple echo handler, that "tries" to produce
 * valid json, by scaping double quotes. This is just a little
 * test to start getting familiar with the concepts of Jersey.
 *
 */
@Path("/echo/{text:[^/]*}")
public class EchoHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String escapeGet(@PathParam("text") String text){
		if (text != null) {
			text = text.replace("\"", "\\\"");
		}
		return String.format("{\"echo\":\"%s\"}", text);
	}

}
