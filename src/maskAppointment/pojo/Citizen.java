
package maskAppointment.pojo;

public class Citizen {
	
	private String name;
	private String idNumber;
	private String phone;
	private int orderNum;
	private int lastRound;
	
	public Citizen() {
	}
	
	public Citizen(String idNumber,String name, String phone, int orderNum, int lastRound) {
		super();
		this.name = name;
		this.idNumber = idNumber;
		this.phone = phone;
		this.orderNum = orderNum;
		this.lastRound = lastRound;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getLastRound() {
		return lastRound;
	}
	public void setLastRound(int lastRound) {
		this.lastRound = lastRound;
	}
	
	
}

