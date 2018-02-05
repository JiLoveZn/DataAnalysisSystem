package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDao;
import service.impl.UsersDaoImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	//�û���¼����
	public String login(){
		UsersDao udao = new UsersDaoImpl();
		if(udao.usersLogin(user)){
			//��Session�б����¼�ɹ����û���
			session.setAttribute("loginUid", user.getUid());
			return "login_success";
			
		}
		else{
			return "login_failure";
		}
	}
	
	@SkipValidation
	//�û�ע������
	public String logout(){
		if(session.getAttribute("loginName")!=null){
			session.removeAttribute("loginName");
		}
		return "logout_success";
	}
	
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//�û�������Ϊ��
		if("".equals(user.getUid())){
			this.addFieldError("usernameError", "�û�������Ϊ��");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "�������");
		}
	}

	public Users getModel(){
		return this.user;
	}
}
