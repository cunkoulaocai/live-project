package maskAppointment.pojo;

import java.util.Date;

public class Systemtime {
	private int  id;
	private Date opentime;
	private Date closetime;
	
	public int getId() {
		return id;
	}
	
	public Date getOpentime() {
		return opentime;
	}
	
	public Date geClosetime() {
		return closetime;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}
	
	public void setClosetime(Date closetime) {
		this.closetime = closetime;
	}
	
}
