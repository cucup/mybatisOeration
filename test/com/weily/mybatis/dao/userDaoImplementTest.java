package com.weily.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.weily.mybatis.po.User;

public class userDaoImplementTest {
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 此方法在testFindUserById之前执行
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// 在正式测试前的工作
		// 创建SqlSessionFactory
		String resource = "SqlMapConfig.xml";// mybatis配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {

		// 创建UserDao的对象
		UserDao userDao = new userDaoImplement(sqlSessionFactory);
		User user=userDao.findUserById(1);
		System.out.println(user);
	} 
}
