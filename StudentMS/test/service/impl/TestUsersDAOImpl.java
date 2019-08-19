package service.impl;


import org.junit.Assert;
import org.junit.Test;

import entity.Users;
import service.UsersDAO;

// 单元测试,检查是查询admin函数是否有效
public class TestUsersDAOImpl {
	
	@Test
	public void testUserLogin(){
		Users u = new Users(1, "admin", "123456");
		UsersDAO udao = new UsersDAOImpl();
		// 断言抛出,assertEquals 如果预期值与真实值相等，则运行success，反之Failure
		Assert.assertEquals(true, udao.usersLogin(u)); 
	}
}
