package org.wanwanframework.springboot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.wanwanframework.springboot.persistent.model.Entity;

@Service
public class EntityService {

	//@Resource
	private Entity entity = new Entity();
	
	public String getEntity() {
		return entity.toString();
	}
}
