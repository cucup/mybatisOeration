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
	 * �˷�����testFindUserById֮ǰִ��
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// ����ʽ����ǰ�Ĺ���
		// ����SqlSessionFactory
		String resource = "SqlMapConfig.xml";// mybatis�����ļ�
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {

		// ����UserDao�Ķ���
		UserDao userDao = new userDaoImplement(sqlSessionFactory);
		User user=userDao.findUserById(1);
		System.out.println(user);
	} 
}
