package com.weily.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.weily.mybatis.po.User;
/**
 * UserDao的实现类
 * @author 可
 *
 */
public class userDaoImplement implements UserDao{
	
	private SqlSessionFactory sqlSessionFactory;
	//通过构造函数向dao类中注入SqlSessionFactory
	public userDaoImplement(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * 根据id查询用户信息
	 */
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=sqlSession.selectOne("test.findUserById",id);
		//释放资源
		sqlSession.close();
		return user;
	}

	/**
	 * 插入用户信息
	 */
	@Override
	public void insertUser(User user) throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser",user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		
	}

	/**
	 * 根据id删除用户信息
	 */
	@Override
	public void deleteUser(int id) throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser",id);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();	
	}

	
	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
