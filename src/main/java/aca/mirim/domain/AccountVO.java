package aca.mirim.domain;

public class AccountVO {
	
	private String aid;
	private String id;
	private String bcode;
	private int balance;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountVO [aid=" + aid + ", id=" + id + ", bcode=" + bcode + ", balance=" + balance + "]";
	}
	
}
