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
	 *  传入参数：无
	 *  返回参数：Mask对象
	 */
	@Override
	public Mask getMask() {
		Mask mask = new Mask();
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
			String sqlString = "select * from mask";
			ResultSet rs = s.executeQuery(sqlString);
			
			if (rs.next()) {
				mask.setTotalCount(rs.getInt("total")); 
				mask.setRemainCount(rs.getInt("remainder"));
				mask.setTotalCount(rs.getInt("maxcount"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mask;
	}

	/**
	 *  根据管理员的输入设置数据库中口罩的数量
	 *  传入参数：口罩对象
	 *  返回参数：是否成功
	 */
	@Override
	public boolean setMask(Mask mask) {
		boolean result = false;
		//获取口罩数量
		int totalCnt = mask.getTotalCount();
		int remainCnt = mask.getRemainCount();
		int maxCnt = mask.getMaxCount();
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
			String sqlString = "update mask set total = '" + totalCnt + "',"
					+ "maxcount = '" + maxCnt + "'";
			int changedLine = s.executeUpdate(sqlString);
			if(changedLine == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	

}
