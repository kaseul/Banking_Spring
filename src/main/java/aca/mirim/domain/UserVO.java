package aca.mirim.domain;

import java.util.Date;

public class UserVO {
	
	private String id;
	private String password;
	private String uname;
	private Date birth;
	private String tel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", uname=" + uname + ", birth=" + birth + ", tel=" + tel
				+ "]";
	}
	
}
