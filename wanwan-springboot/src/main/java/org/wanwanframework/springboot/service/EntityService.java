package org.wanwanframework.springboot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.wanwanframework.springboot.persistent.model.Entity;

@Component
public class EntityService {

	@Resource
	private Entity entity;
	
	public String getEntity() {
		return entity.toString();
	}
}
