package org.wanwanframework.jersey;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ���Ե�ʱ�����ⶨ��һ��ģ�;Ϳ���
 * @author coco
 *
 */
@XmlRootElement
public class AccountVo {

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
