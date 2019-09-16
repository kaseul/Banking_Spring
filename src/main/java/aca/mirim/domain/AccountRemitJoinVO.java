package aca.mirim.domain;

import java.util.Date;

public class AccountRemitJoinVO {
	
	private String inaid;
	private String bcode;
	private String bname;
	private int commission;
	private Date remit_date;
	
	public String getInaid() {
		return inaid;
	}
	public void setInaid(String inaid) {
		this.inaid = inaid;
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
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public Date getRemit_date() {
		return remit_date;
	}
	public void setRemit_date(Date remit_date) {
		this.remit_date = remit_date;
	}
	
	@Override
	public String toString() {
		return "AccountRemitJoinVO [inaid=" + inaid + ", bcode=" + bcode + ", bname=" + bname + ", commission="
				+ commission + ", remit_date=" + remit_date + "]";
	}
	
}
