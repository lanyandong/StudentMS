package service;

import entity.Users;

// 用户逻辑接口
public interface UsersDAO {
	// 用户登录
	public boolean usersLogin(Users u);
}
