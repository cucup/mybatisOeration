package com.weily.mybatis.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

/**
 * ���ݿ�ʹ�ò��� ���ݿ�operation
 * 
 * @author ��
 *
 */
public class textSqlOperation {
	private Connection con = null;// ���ݿ�������
	private PreparedStatement stmt = null;// Ԥ�������
	private ResultSet rs = null;// �����

	public textSqlOperation() {
		try {
			// �������ݿ�������
			Class.forName("com.mysql.jdbc.Driver");
			// ������Ӷ���
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123456");
			// ���Ԥ�������
			stmt = con.prepareStatement( "select * from USER where id =?");
			stmt.setInt(1, 1);
			// ����ѯ������뵽�����
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("id= " + rs.getInt(1) + " name=" + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		textSqlOperation t1 = new textSqlOperation();

	}

}
