package org.wanwanframework.jersey;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.impl.MultiPartWriter;

public class JerseyClient {

	public void init() {
		
	}
	
	/**
	 * 上传文件数据
	 * @param url
	 * @param part
	 * @return
	 */
	public String post(String url, FormDataMultiPart part) {
		String response = post(url, part);
		return response;
	}
	
	/**
	 * 上传数据
	 * @param url
	 * @param entity
	 * @return
	 */
	public String post(String url, Object entity) {
		ClientConfig config = new DefaultClientConfig();
		config.getClasses().add(MultiPartWriter.class);
		Client writeClient = Client.create(config);
		writeClient.setConnectTimeout(5000);
		writeClient.setReadTimeout(5000);
		
		WebResource resource = writeClient.resource(url);
		String response = resource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(String.class, entity);
		writeClient.destroy();
		return response;
	}
	
	public void postEntity() {
		
	}
}
