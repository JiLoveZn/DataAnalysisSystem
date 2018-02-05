package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Users;
import service.UsersDao;
import service.impl.UsersDaoImpl;

//管理员管理用户Action类
public class AdminAction extends SuperAction {
	private static final long serialVersionUID =1L;
	//查询用户的动作
	public String query(){
		UsersDao udao = new UsersDaoImpl();
		List<Users> list = udao.queryAllUsers();
		//放进Session中
		if(list!=null&&list.size()>0){
			session.setAttribute("users_list", list);
		}
		return "queryusers_success";
	}
	
	//删除用户动作
	public String delete(){
		UsersDao udao = new UsersDaoImpl();
		String uid = request.getParameter("uid");
		udao.deleteUsers(uid);//调用删除方法
		return "deleteusers_success";
	}
	
	//添加用户动作
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
	
	//修改该用户动作
	public String modify(){
		//获得传递过来的姓名
		String uid = request.getParameter("uid");
		UsersDao udao = new UsersDaoImpl();
		Users u = udao.queryUsersByUid(uid);
		//保存在会话中
		session.setAttribute("modify_users", u);
		return "modifyusers_success";
	}
	
	//保存修改后的用户动作
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
