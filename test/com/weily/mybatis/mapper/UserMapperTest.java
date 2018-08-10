package com.weily.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.weily.mybatis.po.*;

public class UserMapperTest {

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

	// ����id��ѯ�û���Ϣ
	@Test
	public void testFindUserById() throws Exception {

		// ����UserMapper����Dao����UserDaoImplement��ʵ���˸��ӿڵķ���������û��
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// ����UserMapper�Ķ���mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ����userMapper�ķ���
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

	// ���ݸ���������ѯ�û���Ϣ
	@Test
	public void testFindUserList() throws Exception {

		// ����UserMapper����Dao����UserDaoImplement��ʵ���˸��ӿڵķ���������û��
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����UserMapper�Ķ���mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ������װ�������ò�ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("Ů");
		userCustom.setUsername("����Т");
		userQueryVo.setUserCustom(userCustom);
		// ����userMapper�ķ���
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}

	// ���ݸ���������ѯ�û���Ϣ
	@Test
	public void testFindUserCount() throws Exception {

		// ����UserMapper����Dao����UserDaoImplement��ʵ���˸��ӿڵķ���������û��
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����UserMapper�Ķ���mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// ������װ�������ò�ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("Ů");
		userCustom.setUsername("����Т");
		userQueryVo.setUserCustom(userCustom);
		// ����userMapper�ķ���
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}

	// ����û���Ϣ
	@Test
	public void insertUser(User user) throws Exception {

		// ����UserMapper����Dao����UserDaoImplement��ʵ���˸��ӿڵķ���������û��
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper�Ķ���mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ����userMapper�ķ���
		userMapper.insertUser(user);
		sqlSession.commit();
		System.out.println(user);
	}
}
