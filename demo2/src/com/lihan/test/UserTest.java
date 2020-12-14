package com.lihan.test;

import com.lihan.dao.UserDao2;

public class UserTest {
	public static void main(String[] args) {
		UserDao2 userDao2 = new UserDao2();
	 	userDao2.deleteUser(2);
	}
}
