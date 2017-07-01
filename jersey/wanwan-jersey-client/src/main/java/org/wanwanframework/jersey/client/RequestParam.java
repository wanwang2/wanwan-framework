package org.wanwanframework.jersey.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

public class RequestParam {

	public static final String POST_FORM = "form";
	public static final String POST_JSON = "json";
	
	private String postType = POST_FORM;
	private String json;

	private Map<String, String[]> parameters = new HashMap<String, String[]>();
	private Map<String, String> headers = new HashMap<String, String>();
	private String method = "get";
	private List<Cookie> cookies = new ArrayList<Cookie>();

	public Map<String, String[]> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameter) {
		Map<String, String[]> map = new HashMap<>();
		for (String key :parameter.keySet()) {
			map.put(key, new String[]{parameter.get(key)});
		}
		this.parameters = map;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Cookie> getCookies() {
		return cookies;
	}

	public void setCookies(List<Cookie> cookies) {
		this.cookies = cookies;
	}

}
