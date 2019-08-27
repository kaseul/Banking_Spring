package aca.mirim.domain;

public class BankVO {

	private String bcode;
	private String bname;
	
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
	
	@Override
	public String toString() {
		return "BankVO [bcode=" + bcode + ", bname=" + bname + "]";
	}
	
}
