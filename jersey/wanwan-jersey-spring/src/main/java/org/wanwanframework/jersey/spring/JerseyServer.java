package org.wanwanframework.jersey.spring;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class JerseyServer {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	@Autowired
	DataSource dataSource;
	
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
				name = getDate();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		return "My name is " + name + ", Hello World!";
	}
	
	@Cacheable("getDate") 
	public String getDate() {
		return new Date().toString();
	}
}