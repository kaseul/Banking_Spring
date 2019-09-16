package aca.mirim.domain;

import java.util.Date;

public class RemitJoinVO {
	private String outname;
	private String outbname;
	private String outaid;
	private String inname;
	private String inbname;
	private String inaid;
	private int price;
	private Date remit_date;
	
	public String getOutname() {
		return outname;
	}
	public void setOutname(String outname) {
		this.outname = outname;
	}
	public String getOutbname() {
		return outbname;
	}
	public void setOutbname(String outbname) {
		this.outbname = outbname;
	}
	public String getOutaid() {
		return outaid;
	}
	public void setOutaid(String outaid) {
		this.outaid = outaid;
	}
	public String getInname() {
		return inname;
	}
	public void setInname(String inname) {
		this.inname = inname;
	}
	public String getInbname() {
		return inbname;
	}
	public void setInbname(String inbname) {
		this.inbname = inbname;
	}
	public String getInaid() {
		return inaid;
	}
	public void setInaid(String inaid) {
		this.inaid = inaid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRemit_date() {
		return remit_date;
	}
	public void setRemit_date(Date remit_date) {
		this.remit_date = remit_date;
	}
	
	@Override
	public String toString() {
		return "RemitJoinVO [outname=" + outname + ", outbname=" + outbname + ", outaid=" + outaid + ", inname="
				+ inname + ", inbname=" + inbname + ", inaid=" + inaid + ", price=" + price + ", remit_date="
				+ remit_date + "]";
	}

}
