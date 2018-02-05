package entity;

public class EntryData {
	private String  eid;
	private String item;
	private double money;
	private int month;
	
	public EntryData(){
		
	}
	
	public EntryData(String eid, String item, double money, int month) {
		super();
		this.eid = eid;
		this.item = item;
		this.money = money;
		this.month = month;
	}

	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
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
		return "EntryData [eid=" + eid + ", item=" + item + ", money=" + money + ", month=" + month + "]";
	}
	
}
