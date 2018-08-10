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

	// 根据id查询用户信息
	@Test
	public void testFindUserById() throws Exception {

		// 创建UserMapper对象，Dao中在UserDaoImplement中实现了各接口的方法，这里没有
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 创建UserMapper的对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用userMapper的方法
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

	// 根据复合条件查询用户信息
	@Test
	public void testFindUserList() throws Exception {

		// 创建UserMapper对象，Dao中在UserDaoImplement中实现了各接口的方法，这里没有
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建UserMapper的对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("女");
		userCustom.setUsername("罗忠孝");
		userQueryVo.setUserCustom(userCustom);
		// 调用userMapper的方法
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}

	// 根据复合条件查询用户信息
	@Test
	public void testFindUserCount() throws Exception {

		// 创建UserMapper对象，Dao中在UserDaoImplement中实现了各接口的方法，这里没有
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建UserMapper的对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("女");
		userCustom.setUsername("罗忠孝");
		userQueryVo.setUserCustom(userCustom);
		// 调用userMapper的方法
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}

	// 添加用户信息
	@Test
	public void insertUser(User user) throws Exception {

		// 创建UserMapper对象，Dao中在UserDaoImplement中实现了各接口的方法，这里没有
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper的对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用userMapper的方法
		userMapper.insertUser(user);
		sqlSession.commit();
		System.out.println(user);
	}
}
