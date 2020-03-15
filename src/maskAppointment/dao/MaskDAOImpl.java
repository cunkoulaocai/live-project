package maskAppointment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import maskAppointment.pojo.Mask;
import maskAppointment.util.DBUtil;

/**
 * 
 * @author 221701120_hxy
 *
 * 
 */

public class MaskDAOImpl implements MaskDAO{

	/**
	 *  获取数据库中口罩的数量，返回一个Mask对象。
	 */
	@Override
	public Mask getMask() {
		int totalCnt = 0;
		Mask mask = new Mask();
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
			String sqlString = "select * from mask";
			ResultSet rs = s.executeQuery(sqlString);
			
			if (rs.next()) {
				mask.setTotalCount(rs.getInt("total")); 
				mask.setRemainCount(rs.getInt("remainder"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mask;
	}

	

}
