package com.weily.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.weily.mybatis.po.User;
/**
 * UserDao��ʵ����
 * @author ��
 *
 */
public class userDaoImplement implements UserDao{
	
	private SqlSessionFactory sqlSessionFactory;
	//ͨ�����캯����dao����ע��SqlSessionFactory
	public userDaoImplement(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * ����id��ѯ�û���Ϣ
	 */
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=sqlSession.selectOne("test.findUserById",id);
		//�ͷ���Դ
		sqlSession.close();
		return user;
	}

	/**
	 * �����û���Ϣ
	 */
	@Override
	public void insertUser(User user) throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser",user);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
		
	}

	/**
	 * ����idɾ���û���Ϣ
	 */
	@Override
	public void deleteUser(int id) throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser",id);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();	
	}

	
	/**
	 * �����û���Ϣ
	 */
	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
