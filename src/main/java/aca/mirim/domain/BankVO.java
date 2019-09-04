package aca.mirim.domain;

public class BankVO {
	
	private String bcode;
	private String bname;
	private int commission;

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
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	
	@Override
	public String toString() {
		return "BankVO [bcode=" + bcode + ", bname=" + bname + ", commission=" + commission + "]";
	}
	
}
