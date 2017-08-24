package org.wanwanframework.jersey.client;

import java.util.Collections;
import java.util.Map;

import com.sun.jersey.api.client.ClientResponse;

public abstract class RemoteFacade {

	protected abstract JerseyService getJerseyService();
	
	protected <T> T post(String uri, final Class<T> clazz) {
		return invoke(uri, "post", Collections.<String, String>emptyMap(), clazz);
	}
	
	protected <T> T get(String uri, Map<String, String> parameter, final Class<T> clazz) {
		return invoke(uri, "get", parameter, clazz);
	}
	
	protected <T> T get(String uri, final Class<T> clazz) {
		return invoke(uri, "get", Collections.<String, String>emptyMap(), clazz);
	}

	@SuppressWarnings("unchecked")
	protected <T> T invoke(String uri, String method, RequestParam param, Class<T> classz) {
		param.setMethod(method);
		ClientResponse clientResponse = getJerseyService().getInstance(uri).invoke(param);
		if(String.class.equals(classz)) {
			return clientResponse.getEntity(classz);
		}
		return (T) clientResponse;
	}
	
	protected <T> T invoke(String uri, String method, Map<String, String> parameter, Class<T> classz) {
		RequestParam param = new RequestParam();
		param.setMethod(method);
		param.setParameters(parameter);
		
		return this.invoke(uri, method, param, classz);
	}
}
