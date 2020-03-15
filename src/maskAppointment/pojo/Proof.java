package maskAppointment.pojo;

public class Proof {
//	orderId varchar(40) not null primary key comment "预约编号",
//    name varchar(20) not null comment "市民姓名",
//    idNumber varchar(20) not null comment "市民身份证",
//    phone varchar(15) not null comment "手机号码",
//    orderNum int(4) not null comment "预约数量",
	private String orderId;
	private String name;
	private String idNumber;
	private String phone;
	private int orderNum;
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
}
