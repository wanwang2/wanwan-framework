package org.wanwanframework.springboot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanwanframework.springboot.persistent.model.Entity;
import org.wanwanframework.springboot.service.EntityService;

/**
 * http://localhost:8080/
 * @author coco
 *
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages={"org.wanwanframework.springboot.persistent"})
public class SpringBoot {

	//@Resource
	//private EntityService entityService;
	
	@Resource
	private Entity entity;
	
	@Value("${me.path}")
	private String path;
	
    @RequestMapping("/")
    String home() {
        return path;
    }
    
    @RequestMapping("/entity")
    public String entity() {
    	return entity.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }
}