package org.wanwanframework.frame.gradle;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class DataSourceTest {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	@Test
	public void testSession() throws Exception {
		System.out.println("sqlSessionFactoryBean:" + sqlSessionFactoryBean);
		SqlSessionFactory f = ((SqlSessionFactory)sqlSessionFactoryBean.getObject());
		SqlSession session = f.openSession();
		System.out.println("session:" + session);

	}

}
