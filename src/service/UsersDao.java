package service;

import java.util.List;

import entity.Users;

//用户业务逻辑接口
public interface UsersDao {
	//用户登录方法
	//public boolean adminLogin(Users u);
	public boolean usersLogin(Users u);
	
	
	//查询所有用户
	public List<Users> queryAllUsers();
	//根据工号查询用户
	public Users queryUsersByUid(String uid);
	//添加用户
	public boolean addUsers(Users u);
	//修改用户
	public boolean updateUsers(Users u);
	//删除用户
	public boolean deleteUsers(String uid);
}
