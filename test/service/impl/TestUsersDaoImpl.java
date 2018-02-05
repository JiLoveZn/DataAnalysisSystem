package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Users;
import junit.framework.Assert;
import service.UsersDao;
import service.impl.UsersDaoImpl;;

public class TestUsersDaoImpl {
	@Test
	public void testUsersLogin(){
		Users u = new Users("2014352","³Â¼ª","cjzz","ÄÐ",new Date(),"18980357809",1);
		UsersDao udao = new UsersDaoImpl();
		Assert.assertEquals(true, udao.usersLogin(u));
	}
	
	/*@Test
	public void testQueryAllUsers(){
		UsersDao udao = new UsersDaoImpl();
		List<Users> list = udao.queryAllUsers();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testGetNewUid(){
		UsersDaoImpl udao = new UsersDaoImpl();
		System.out.println(udao.getNewUid());
	}
	
	@Test
	public void testAddUsers(){
		Users u = new Users();
		u.setName("Öìéª");
		u.setPassword("buct");
		u.setGender("Å®");
		u.setBirthday(new Date());
		u.setPhonenumber("13198388821");
		u.setAuthority(2);
		UsersDao udao = new UsersDaoImpl();
		Assert.assertEquals(true, udao.addUsers(u));
	}*/
}
