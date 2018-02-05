package entity;


public class SalesData {
	private String  sid;
	private String item;
	private double money;
	private int month;
	
	public SalesData(){
		
	}
	
	public SalesData(String sid, String item, double money, int month) {
		super();
		this.sid = sid;
		this.item = item;
		this.money = money;
		this.month = month;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "SalesData [sid=" + sid + ", item=" + item + ", money=" + money + ", month=" + month + "]";
	}
	
}
