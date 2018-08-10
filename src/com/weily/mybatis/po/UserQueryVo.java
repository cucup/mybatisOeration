package com.weily.mybatis.po;

import java.util.List;

/**
 * 需求：当需要查询条件很多很复杂的时候
 * 需要一个包括了很多类型的一个pojo包装类
 * @author 可
 *
 */
public class UserQueryVo {
	//在这里包装所需要查询的查询条件
	private UserCustom userCustom;
	private List<Integer> lds;//foreach查询时需要的集合
	//可以包装其他查询条件
	//private 其他类型的查询条件

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public List<Integer> getLds() {
		return lds;
	}


	public void setLds(List<Integer> lds) {
		this.lds = lds;
	}


	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
}
