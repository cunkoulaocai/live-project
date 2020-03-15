package maskAppointment.dao;

import java.sql.*;
import maskAppointment.util.*;
/**
 * 
 * @author 221701120_hxy
 *
 */
public class AdminDAOImpl implements AdminDAO{
	
	/*
	 * 获取管理员账号的密码
	 * 参数：管理员账号名
	 * 返回值：该账号对应的密码值，若账号不存在则值为空
	 */
	@Override
	public String getPasswd(String name) {
		String passwdString = "";
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
			String sqlString = "select password from adminuser where username ='"+name+"'";
			ResultSet rs = s.executeQuery(sqlString);
			
			if (rs.next()) {
				passwdString = rs.getString("password");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passwdString;
	}
	
}
