package maskAppointment.pojo;

import java.sql.Timestamp;

public class SystemTime {
	private int id;
	private Timestamp opentime;
	private Timestamp closetime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getOpentime() {
		return opentime;
	}
	
	public void setOpentime(Timestamp opentime) {
		this.opentime=opentime;
	}
	
	public Timestamp getClosetime() {
		return closetime;
	}
	
	public void setClosetime(Timestamp closetime) {
		this.closetime=closetime;
	}
}
