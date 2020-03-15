package maskAppointment.pojo;
/**
 * 
 * @author 221701120_hxy
 *
 * 口罩POJO
 */
public class Mask {
	private int totalCount; //口罩总数量
	private int remainCount; //口罩剩余数量
	private int maxCount; //单次预约最大数量
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getRemainCount() {
		return remainCount;
	}
	public void setRemainCount(int remainCount) {
		this.remainCount = remainCount;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
}