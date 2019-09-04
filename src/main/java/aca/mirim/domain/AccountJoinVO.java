package aca.mirim.domain;

public class AccountJoinVO {
	
	private String aid;
	private String uname;
	private String bcode;
	private String bname;
	private int balance;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountJoinVO [aid=" + aid + ", uname=" + uname + ", bcode=" + bcode + ", bname=" + bname + ", balance="
				+ balance + "]";
	}
	
}
