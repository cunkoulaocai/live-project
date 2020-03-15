package maskAppointment.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import maskAppointment.pojo.Systemtime;
import maskAppointment.util.DBUtil;

public class SystemtimeDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//设置某轮次的开始和结束时间
	public void set(Systemtime systemtime) {
		String sql = "insert into system_time values(? ,? ,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String opendateStr = format.format(systemtime.getOpentime());
	        String closedateStr = format.format(systemtime.geClosetime());
			ps.setInt(1, systemtime.getId());
			ps.setString(2, opendateStr);
			ps.setString(3, closedateStr);
			ps.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	//修改更新时间
	public void update(Systemtime systemtime) {
		String sql = "update system_time set opentime=?,closetime=? where id=?";
		try {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String opendateStr = format.format(systemtime.getOpentime());
	        String closedateStr = format.format(systemtime.geClosetime());
			connection = DBUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,opendateStr);
			pstmt.setString(2,closedateStr);
			pstmt.setInt(3, systemtime.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, connection);
		}

	}
	
	
	
	public static void main(String[] args) {
		/*Systemtime sys=new Systemtime();
		sys.setId(1);
		Date utilDate = new Date(0);
		sys.setClosetime(utilDate);
		sys.setOpentime(utilDate);
		// TODO Auto-generated method stub
		SystemtimeDAO sysDAO=new SystemtimeDAO();
		sysDAO.set(sys);*/
	}
	
	
}
