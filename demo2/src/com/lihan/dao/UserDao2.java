package com.lihan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import com.lihan.domain.User;

public class UserDao2 {
	public void deleteUser(Integer id) {
		Statement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�����ɹ�");
			conn = DriverManager.getConnection("jdbc:mysql:///db2?serverTimezone=UTC","root","root");
			stmt = conn.createStatement();
			String sql = "delete from users where id="+id;
			int i = stmt.executeUpdate(sql);
			System.out.println("�ɹ�ɾ��"+ i +"������");
		} catch (ClassNotFoundException e) {
			System.out.println("������û�ҵ�");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ӻ�ȡʧ��");
		} finally {
			if(stmt != null) {
				try {
				stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
