package com.weily.mybatis.po;

import java.util.List;

/**
 * ���󣺵���Ҫ��ѯ�����ܶ�ܸ��ӵ�ʱ��
 * ��Ҫһ�������˺ܶ����͵�һ��pojo��װ��
 * @author ��
 *
 */
public class UserQueryVo {
	//�������װ����Ҫ��ѯ�Ĳ�ѯ����
	private UserCustom userCustom;
	private List<Integer> lds;//foreach��ѯʱ��Ҫ�ļ���
	//���԰�װ������ѯ����
	//private �������͵Ĳ�ѯ����

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
