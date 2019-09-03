package aca.mirim.domain;

public class RemitVO {
	
	private int no;
	private String outaid;
	private String inaid;
	private int price;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOutaid() {
		return outaid;
	}
	public void setOutaid(String outaid) {
		this.outaid = outaid;
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
	
	@Override
	public String toString() {
		return "RemitVO [no=" + no + ", outaid=" + outaid + ", inaid=" + inaid + ", price=" + price + "]";
	}
	
}
