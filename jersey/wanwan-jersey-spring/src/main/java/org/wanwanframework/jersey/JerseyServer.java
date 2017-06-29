package org.wanwanframework.jersey;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/hello")
public class JerseyServer {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@GET
	@Path("hi")
	public String getResult(@QueryParam("name") String name) {
		return result(name);
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String postResult(@QueryParam("name") String name) {
		return result(name);
	}

	private String result(String name) {
		try {
			String nameByte = request.getParameter("name");
			if(nameByte != null) {
				name = new String(nameByte.getBytes("ISO-8859-1"), "UTF-8");
			} else {
				name = "没有名字，我勒个叉叉";
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		return "My name is " + name + ", Hello World!";
	}
}