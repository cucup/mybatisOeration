package com.weily.mybatis.dao;

import com.weily.mybatis.po.User;
/**
 * UserDao接口
 * @author 可
 *
 */
public interface UserDao {
	//根据id查询用户信息
	public User findUserById(int id)throws Exception;
	 
	//添加用户信息
	public void insertUser(User user)throws Exception;
	
	//删除用户信息
	public void deleteUser(int id)throws Exception;
	
	//更新用户信息
	public void updateUser(User user)throws Exception;
}
