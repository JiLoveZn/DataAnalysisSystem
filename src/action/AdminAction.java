package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Users;
import service.UsersDao;
import service.impl.UsersDaoImpl;

//����Ա�����û�Action��
public class AdminAction extends SuperAction {
	private static final long serialVersionUID =1L;
	//��ѯ�û��Ķ���
	public String query(){
		UsersDao udao = new UsersDaoImpl();
		List<Users> list = udao.queryAllUsers();
		//�Ž�Session��
		if(list!=null&&list.size()>0){
			session.setAttribute("users_list", list);
		}
		return "queryusers_success";
	}
	
	//ɾ���û�����
	public String delete(){
		UsersDao udao = new UsersDaoImpl();
		String uid = request.getParameter("uid");
		udao.deleteUsers(uid);//����ɾ������
		return "deleteusers_success";
	}
	
	//����û�����
	public String add() throws Exception{
		Users u = new Users();
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		u.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		u.setBirthday(sdf.parse(request.getParameter("birthday")));
		u.setPhonenumber(request.getParameter("phonenumber"));
		u.setAuthority(Integer.parseInt(request.getParameter("authority")));
		UsersDao udao = new UsersDaoImpl();
		udao.addUsers(u);
		return "addusers_success";
	}
	
	//�޸ĸ��û�����
	public String modify(){
		//��ô��ݹ���������
		String uid = request.getParameter("uid");
		UsersDao udao = new UsersDaoImpl();
		Users u = udao.queryUsersByUid(uid);
		//�����ڻỰ��
		session.setAttribute("modify_users", u);
		return "modifyusers_success";
	}
	
	//�����޸ĺ���û�����
	public String save() throws Exception {
		Users u = new Users();
		u.setUid(request.getParameter("uid"));
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		u.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		u.setBirthday(sdf.parse(request.getParameter("birthday")));
		u.setPhonenumber(request.getParameter("phonenumber"));
		u.setAuthority(Integer.parseInt(request.getParameter("authority")));
		UsersDao udao = new UsersDaoImpl();
		udao.updateUsers(u);
		return "saveusers_success";
	}
	
}
