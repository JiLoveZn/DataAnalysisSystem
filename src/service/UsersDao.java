package service;

import java.util.List;

import entity.Users;

//�û�ҵ���߼��ӿ�
public interface UsersDao {
	//�û���¼����
	//public boolean adminLogin(Users u);
	public boolean usersLogin(Users u);
	
	
	//��ѯ�����û�
	public List<Users> queryAllUsers();
	//���ݹ��Ų�ѯ�û�
	public Users queryUsersByUid(String uid);
	//����û�
	public boolean addUsers(Users u);
	//�޸��û�
	public boolean updateUsers(Users u);
	//ɾ���û�
	public boolean deleteUsers(String uid);
}
