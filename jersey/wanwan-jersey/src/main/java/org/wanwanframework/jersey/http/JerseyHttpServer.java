package org.wanwanframework.jersey.http;

import java.io.IOException;
import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.resource.Singleton;

/**
 * http«Î«Û
 * 
 * @author coco
 *
 */
@Singleton
@Path("orangle")
public class JerseyHttpServer {

	@Path("{sub_path:[a-zA-Z0-9]}")
	@GET
	@Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public String getResource(@Context HttpServletRequest httpServletRequest, @Context HttpServletResponse httpServletResponse) {
		return "success";
	}
	
	public static void main(String[] args) {
		URI uri = UriBuilder.fromUri("http://127.0.0.1").port(8081).build();
		ResourceConfig rc = new PackagesResourceConfig("org.wanwanframework.jersey");
		HttpServer server;
		try {
			server = GrizzlyServerFactory.createHttpServer(uri, rc);
			server.start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
