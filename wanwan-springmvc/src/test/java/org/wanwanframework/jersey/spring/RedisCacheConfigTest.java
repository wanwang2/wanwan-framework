package org.wanwanframework.jersey.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context-datasource.xml" })
public class RedisCacheConfigTest {

	@Autowired
	private JedisConnectionFactory jedis;
	
	@Test
	public void testRedis() {
		System.out.println(jedis);
		System.out.println(jedis.getConnection().ping());
	}
}
