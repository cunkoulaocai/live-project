package maskAppointment.pojo;


public class OrderInformation {
//	orderId varchar(40) not null primary key comment "预约编号",
//    idNumber varchar(20) not null comment "市民身份证号",
//    orderRound int(4) not null comment "预约轮数",
//    foreign key(idNumber) references citizen(idNumber)
    
    private String orderId;
    private String idNumber;
    private int orderRound;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getOrderRound() {
		return orderRound;
	}
	public void setOrderRound(int orderRound) {
		this.orderRound = orderRound;
	}
    
    
}
