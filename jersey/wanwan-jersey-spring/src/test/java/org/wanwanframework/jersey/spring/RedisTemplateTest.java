package org.wanwanframework.jersey.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context-redis.xml" })
public class RedisTemplateTest {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Test
	public void testRedis() {

		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("vv", "123456789");
		String value = (String)valueOperations.get("vv");
		System.out.println("value:" + value);
	}
	
	@Test
	public void testGet() {
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		String value = (String)valueOperations.get("vv");
		System.out.println("value:" + value);	
	}
}
