package com.weily.mybatis.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

/**
 * 数据库使用测试 数据库operation
 * 
 * @author 可
 *
 */
public class textSqlOperation {
	private Connection con = null;// 数据库连接类
	private PreparedStatement stmt = null;// 预处理对象
	private ResultSet rs = null;// 结果集

	public textSqlOperation() {
		try {
			// 加载数据库驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 获得连接对象
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123456");
			// 获得预处理对象
			stmt = con.prepareStatement( "select * from USER where id =?");
			stmt.setInt(1, 1);
			// 将查询结果加入到结果集
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
