package org.wanwanframework.jersey.client;

import java.util.Map;

import com.sun.jersey.api.client.ClientResponse;

public abstract class JerseyRemoteFacade {

	protected abstract JerseyService getJerseyService();
	
	public <T> T post(String uri, final Class<T> clazz) {
		return null;
	}
	
	public <T> T invoke(String uri, String method, RequestParam param, Class<T> classz) {
		param.setMethod(method);
		ClientResponse clientResponse = getJerseyService().getInstance(uri).invoke(param);
		return (T) clientResponse;
	}
	
	public <T> T invoke(String uri, String method, Map<String, String> parameter, Class<T> classz) {
		RequestParam param = new RequestParam();
		param.setMethod(method);
		param.setParameters(parameter);
		
		return this.invoke(uri, method, param, classz);
	}
}
