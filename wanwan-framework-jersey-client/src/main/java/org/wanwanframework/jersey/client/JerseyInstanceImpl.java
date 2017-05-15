package org.wanwanframework.jersey.client;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.representation.Form;

public class JerseyInstanceImpl {

	private String uri;
	private WebResource resource;
	
	public JerseyInstanceImpl(JerseyService jerseyService, String uri) {
		this.resource = jerseyService.getClient().resource(uri);
	}
	
	private void readCookie(Builder builder, List<Cookie> cookieList) {
		for (Cookie cookie : cookieList) {
			javax.ws.rs.core.Cookie clone = new javax.ws.rs.core.Cookie(cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getDomain());
			builder = builder.cookie(clone);
		}
	}
	
	public ClientResponse invoke() {
		return invokeGet(new RequestParam(), ClientResponse.class);
	}
	
	public ClientResponse invoke(RequestParam param) {
		if(param.getMethod().equalsIgnoreCase("get")) {
			return invokeGet(param, ClientResponse.class);
		} else {
			return invokePost(param, ClientResponse.class);
		}
	}
	
	public <T> T invokeGet(RequestParam param, Class<T> classz) {
		if("get".equalsIgnoreCase(param.getMethod())) {
			readParam(param.getParameters());
		}
		Builder builder = resource.getRequestBuilder();
		readCookie(builder, param.getCookies());
		builder.method(param.getMethod().toUpperCase(), classz);
		return null;
	}
	
	public <T> T invokePost(RequestParam param, Class<T> classz) {
		Builder builder = resource.getRequestBuilder();
		readCookie(builder, param.getCookies());
		if("post".equalsIgnoreCase(param.getMethod())) {
			if(RequestParam.POST_JSON.equals(param.getPostType())) {
				builder.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
				return builder.post(classz, param.getJson());
			} else {
				return invokeForm(param.getParameters(), classz);
			}
		}
		return null;
	}
	
	private <T> T invokeForm(Map<String, String[]> paramesters, Class<T> classz) {
		Builder builder = resource.getRequestBuilder();
		Form form = new Form();

		for (String key : paramesters.keySet()) {
			String[] values = paramesters.get(key);
			for (String value : values) {
				form.add(key, value);
			}
		}
		return builder.post(classz, form);
	}
	
	private void readParam(Map<String, String[]> parameters) {
		for (String key: parameters.keySet()) {
			String[] values = parameters.get(key);
			for (int i = 0; i < values.length; i++) {
				resource = resource.queryParam(key, values[i]);
			}
		}
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
