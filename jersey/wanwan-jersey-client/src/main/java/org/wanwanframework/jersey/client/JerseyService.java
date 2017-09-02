package org.wanwanframework.jersey.client;

import com.sun.jersey.api.client.Client;

public class JerseyService {

	private String readTime;
	private String connectTime;
	private String connectionRequestTimeout;
	private String maxConnTotal;
	private String maxConnPerRoute;
	private boolean isReusedConnection = true;
	private int monitorExecuteCycleSeconds = 5;

	private JerseyHost host;
	private String uri;
	private Client client;
	
	synchronized public Client getClient() {
		if(client == null) {
			init();
		}
		return client;
	}
	
	private void init() {
		client = new Client(new apacheh)
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public String getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(String connectTime) {
		this.connectTime = connectTime;
	}

	public String getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public void setConnectionRequestTimeout(String connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
	}

	public String getMaxConnTotal() {
		return maxConnTotal;
	}

	public void setMaxConnTotal(String maxConnTotal) {
		this.maxConnTotal = maxConnTotal;
	}

	public String getMaxConnPerRoute() {
		return maxConnPerRoute;
	}

	public void setMaxConnPerRoute(String maxConnPerRoute) {
		this.maxConnPerRoute = maxConnPerRoute;
	}

	public boolean isReusedConnection() {
		return isReusedConnection;
	}

	public void setReusedConnection(boolean isReusedConnection) {
		this.isReusedConnection = isReusedConnection;
	}

	public int getMonitorExecuteCycleSeconds() {
		return monitorExecuteCycleSeconds;
	}

	public void setMonitorExecuteCycleSeconds(int monitorExecuteCycleSeconds) {
		this.monitorExecuteCycleSeconds = monitorExecuteCycleSeconds;
	}

	public JerseyHost getHost() {
		return host;
	}

	public void setHost(JerseyHost host) {
		this.host = host;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public JerseyInstanceImpl getInstance(String uri) {
		return new JerseyInstanceImpl(this, uri);
	}
}
