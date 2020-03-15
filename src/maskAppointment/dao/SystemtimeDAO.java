package maskAppointment.dao;

import java.sql.*;

import maskAppointment.pojo.Systemtime;
import maskAppointment.util.DBUtil;

public class SystemtimeDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//设置某轮次的开始和结束时间
	public void set(Systemtime systemtime) {
		String sql = "insert into system_time values(null ,? ,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, systemtime.getId());
			ps.setString(2, systemtime.getOpentime());
			ps.setString(3, systemtime.geClosetime());
			ps.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	//修改更新时间
	public void update(Systemtime systemtime) {
		String sql = "update system_time set opentime=? ,closetime=? where id=?";
		try {
			connection = DBUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, systemtime.getOpentime());
			pstmt.setString(2, systemtime.geClosetime());
			pstmt.setInt(3, systemtime.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, connection);
		}

	}
	
}
