package aca.mirim.domain;

public class TransactionCountVO {
	private String month;
	private int count;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "TransactionCountVO [month=" + month + ", count=" + count + "]";
	}
	
}
