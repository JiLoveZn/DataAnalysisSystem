package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDao;
import service.impl.UsersDaoImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	//用户登录动作
	public String login(){
		UsersDao udao = new UsersDaoImpl();
		if(udao.usersLogin(user)){
			//在Session中保存登录成功的用户名
			session.setAttribute("loginUid", user.getUid());
			return "login_success";
			
		}
		else{
			return "login_failure";
		}
	}
	
	@SkipValidation
	//用户注销方法
	public String logout(){
		if(session.getAttribute("loginName")!=null){
			session.removeAttribute("loginName");
		}
		return "logout_success";
	}
	
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//用户名不能为空
		if("".equals(user.getUid())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码错误");
		}
	}

	public Users getModel(){
		return this.user;
	}
}
