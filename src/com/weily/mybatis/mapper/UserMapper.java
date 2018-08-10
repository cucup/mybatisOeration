package com.weily.mybatis.mapper;

import java.util.List;

import com.weily.mybatis.po.*;
/**
 * UserMapper�ӿ�,�൱��dao�ӿ�
 * @author ��
 *
 */
public interface UserMapper {
	
	//�û���Ϣ���ۺϲ�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//�û��ۺ���Ϣ���ۺϲ�ѯ������Ϊʵ�ַ�ҳ
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//����id��ѯ�û���Ϣ
	public User findUserById(int id)throws Exception;
	//public User findUserById(int id)throws Exception;//userdao�еĽӿ�
	
	//����û���Ϣ
	public void insertUser(User user)throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUser(int id)throws Exception;
	
	//�����û���Ϣ
	public void updateUser(User user)throws Exception;
	
	//����id��ѯ�û���Ϣ��ʹ��resultMap���
	public User findUserByIdResultMap(int id)throws Exception;
}
