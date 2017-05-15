package org.wanwanframework.jersey.client;

public class JerseyHost {

	private String hostURI;

	public String getHostURI() {
		return hostURI;
	}

	public void setHostURI(String hostURI) {
		this.hostURI = hostURI;
	}
	
	public boolean isMatch(String url) {
		return url.contains(hostURI);
	}
}
