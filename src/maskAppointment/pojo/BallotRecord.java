package maskAppointment.pojo;

public class BallotRecord {
//	recordid varchar(30) not null primary key comment "中签记录id",
//    idNumber varchar(20) not null comment "市民身份证",
//    ballotRound int(4) not null comment "中签轮数",
	
	private String recordId;
	private String idNumber;
	private int ballotRound;
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getBallotRound() {
		return ballotRound;
	}
	public void setBallotRound(int ballotRound) {
		this.ballotRound = ballotRound;
	}
	
	
}
