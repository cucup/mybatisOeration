package com.weily.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.weily.mybatis.po.User;

/**
 * 入门程序，理解用
 * 
 * @author 可
 *
 */
public class MybatisFirst {

	/**
	 * 根据id查询用户信息，得到一条记录
	 * @throws IOException
	 */
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSession操作数据库
		// statement:映射文件中的statement的id，等于namespace+"."+statement的id
		// parameter:指定和映射文件中匹配的parameterType类型的参数
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// 释放会话资源
		sqlSession.close();
	}

	/**
	 * 根据username查询用户信息，得到一条记录
	 * @throws IOException
	 */
	public void findUserByNameTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		 /*
		  * 通过SqlSession操作数据库
		  * statement:映射文件中的statement的id，等于namespace+"."+statement的id
		  * parameter:指定和映射文件中匹配的parameterType类型的参数
		  * list中的user和映射文件中resultType所指定的类型一致
		  */
		List<User> list = sqlSession.selectList("test.findUserByName", "张可");

		System.out.println(list);

		// 释放会话资源
		sqlSession.close();
	}
	
	/**
	 * 插入数据
	 * @param args
	 * @throws IOException
	 */
	public void insertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		 /*
		  * 通过SqlSession操作数据库
		  * 造一個user對象，給parameter
		  * statement:映射文件中的statement的id，等于namespace+"."+statement的id
		  * parameter:指定和映射文件中匹配的parameterType类型的参数
		  */
		User user=new User();
		user.setUsername("儸忠孝");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("馬爾代夫帝國理工大學");
		sqlSession.insert("test.insertUser", user);
		//執行提交事務,和Spring整合之後就不需要再手動寫了
		sqlSession.commit();
		// 释放会话资源
		sqlSession.close();
	}

	
	/**
	 * 根据id刪除用户信息
	 * @throws IOException
	 */
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSession操作数据库
		// statement:映射文件中的statement的id，等于namespace+"."+statement的id
		// parameter:指定和映射文件中匹配的parameterType类型的参数
		//傳入id刪除用戶
		User user = sqlSession.selectOne("test.deleteUser", 1);
		
		//執行提交事務
		sqlSession.commit();
		
		System.out.println(user);

		// 释放会话资源
		sqlSession.close();
	}
	
	/**
	 * 根据id更新用户信息
	 * @throws IOException
	 */
	@Test
	public void updateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSession操作数据库
		// statement:映射文件中的statement的id，等于namespace+"."+statement的id
		// parameter:指定和映射文件中匹配的parameterType类型的参数
		//傳入id更新用戶
		User user=new User();
		user.setId(3);
		user.setUsername("張中俊");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("馬爾代夫帝國理工大學");
		sqlSession.update("test.updateUser", user);
		
		//執行提交事務
		sqlSession.commit();
		
		System.out.println(user);

		// 释放会话资源
		sqlSession.close();
	}
	
	public static void main(String[] args) throws IOException {
		MybatisFirst my = new MybatisFirst();
		my.findUserByIdTest();
		my.findUserByNameTest();
		//my.insertUserTest();
		//my.updateUserTest();
	}
}
