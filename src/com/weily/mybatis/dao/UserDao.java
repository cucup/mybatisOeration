package com.weily.mybatis.dao;

import com.weily.mybatis.po.User;
/**
 * UserDao�ӿ�
 * @author ��
 *
 */
public interface UserDao {
	//����id��ѯ�û���Ϣ
	public User findUserById(int id)throws Exception;
	 
	//����û���Ϣ
	public void insertUser(User user)throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUser(int id)throws Exception;
	
	//�����û���Ϣ
	public void updateUser(User user)throws Exception;
}
