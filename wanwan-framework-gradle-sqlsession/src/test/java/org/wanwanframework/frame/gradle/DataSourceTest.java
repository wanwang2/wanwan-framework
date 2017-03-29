package org.wanwanframework.frame.gradle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class DataSourceTest {

	@Autowired
	private DruidDataSource dataSource;
	
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;

	@Test
	public void testDataSource() throws Exception {
		System.out.println("dataSource:" + dataSource);
	}

	@Test
	public void testSqlSession() throws Exception {
		System.out.println("sqlSessionFactory:" + sqlSessionFactory);
	}
}
