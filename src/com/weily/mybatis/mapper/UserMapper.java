package com.weily.mybatis.mapper;

import java.util.List;

import com.weily.mybatis.po.*;
/**
 * UserMapper接口,相当于dao接口
 * @author 可
 *
 */
public interface UserMapper {
	
	//用户信息的综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//用户综合信息的综合查询总数，为实现分页
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息
	public User findUserById(int id)throws Exception;
	//public User findUserById(int id)throws Exception;//userdao中的接口
	
	//添加用户信息
	public void insertUser(User user)throws Exception;
	
	//删除用户信息
	public void deleteUser(int id)throws Exception;
	
	//更新用户信息
	public void updateUser(User user)throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id)throws Exception;
}
