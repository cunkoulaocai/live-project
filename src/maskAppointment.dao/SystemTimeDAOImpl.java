package maskAppointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import maskAppointment.pojo.SystemTime;
import maskAppointment.util.DBUtil;

public class SystemTimeDAOImpl implements SystemTimeDAO{

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
			String sql = "select count(*) from system_time";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public void add(SystemTime bean) {
		// TODO Auto-generated method stub
		String sql = "insert into system_time values(null ,? ,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setTimestamp(1, bean.getOpentime());
			ps.setTimestamp(2, bean.getClosetime());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				bean.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void update(SystemTime bean) {
		// TODO Auto-generated method stub
		String sql = "update system_time set opentime=? ,closetime=? where id=?";
		try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setTimestamp(1, bean.getOpentime());
			ps.setTimestamp(2, bean.getClosetime());
			ps.setInt(1, bean.getId());
			ps.execute();
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql="delete from systeem_time where id=?";
		try(Connection c = DBUtil.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, id);
			ps.execute();
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
