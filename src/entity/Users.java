package entity;

import java.util.Date;

public class Users {
	private String uid;
	private String name;
	private String password;
	private String gender;
	private Date birthday;
	private String phonenumber;
	private int authority;
	
	public Users(){
		
	}

	public Users(String uid, String name, String password, String gender, Date birthday, String phonenumber,
			int authority) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.phonenumber = phonenumber;
		this.authority = authority;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", name=" + name + ", password=" + password + ", gender=" + gender + ", birthday="
				+ birthday + ", phonenumber=" + phonenumber + ", authority=" + authority + "]";
	}
	
}
