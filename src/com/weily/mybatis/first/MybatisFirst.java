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
 * ���ų��������
 * 
 * @author ��
 *
 */
public class MybatisFirst {

	/**
	 * ����id��ѯ�û���Ϣ���õ�һ����¼
	 * @throws IOException
	 */
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSession�������ݿ�
		// statement:ӳ���ļ��е�statement��id������namespace+"."+statement��id
		// parameter:ָ����ӳ���ļ���ƥ���parameterType���͵Ĳ���
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// �ͷŻỰ��Դ
		sqlSession.close();
	}

	/**
	 * ����username��ѯ�û���Ϣ���õ�һ����¼
	 * @throws IOException
	 */
	public void findUserByNameTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		 /*
		  * ͨ��SqlSession�������ݿ�
		  * statement:ӳ���ļ��е�statement��id������namespace+"."+statement��id
		  * parameter:ָ����ӳ���ļ���ƥ���parameterType���͵Ĳ���
		  * list�е�user��ӳ���ļ���resultType��ָ��������һ��
		  */
		List<User> list = sqlSession.selectList("test.findUserByName", "�ſ�");

		System.out.println(list);

		// �ͷŻỰ��Դ
		sqlSession.close();
	}
	
	/**
	 * ��������
	 * @param args
	 * @throws IOException
	 */
	public void insertUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		 /*
		  * ͨ��SqlSession�������ݿ�
		  * ��һ��user���󣬽oparameter
		  * statement:ӳ���ļ��е�statement��id������namespace+"."+statement��id
		  * parameter:ָ����ӳ���ļ���ƥ���parameterType���͵Ĳ���
		  */
		User user=new User();
		user.setUsername("����Т");
		user.setSex("Ů");
		user.setBirthday(new Date());
		user.setAddress("�R������ۇ�����W");
		sqlSession.insert("test.insertUser", user);
		//�����ύ��,��Spring����֮��Ͳ���Ҫ���քӌ���
		sqlSession.commit();
		// �ͷŻỰ��Դ
		sqlSession.close();
	}

	
	/**
	 * ����id�h���û���Ϣ
	 * @throws IOException
	 */
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSession�������ݿ�
		// statement:ӳ���ļ��е�statement��id������namespace+"."+statement��id
		// parameter:ָ����ӳ���ļ���ƥ���parameterType���͵Ĳ���
		//����id�h���Ñ�
		User user = sqlSession.selectOne("test.deleteUser", 1);
		
		//�����ύ��
		sqlSession.commit();
		
		System.out.println(user);

		// �ͷŻỰ��Դ
		sqlSession.close();
	}
	
	/**
	 * ����id�����û���Ϣ
	 * @throws IOException
	 */
	@Test
	public void updateUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSession�������ݿ�
		// statement:ӳ���ļ��е�statement��id������namespace+"."+statement��id
		// parameter:ָ����ӳ���ļ���ƥ���parameterType���͵Ĳ���
		//����id�����Ñ�
		User user=new User();
		user.setId(3);
		user.setUsername("���п�");
		user.setSex("Ů");
		user.setBirthday(new Date());
		user.setAddress("�R������ۇ�����W");
		sqlSession.update("test.updateUser", user);
		
		//�����ύ��
		sqlSession.commit();
		
		System.out.println(user);

		// �ͷŻỰ��Դ
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
