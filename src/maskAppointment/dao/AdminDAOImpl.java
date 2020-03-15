package maskAppointment.dao;

import java.sql.*;
import maskAppointment.util.*;

public class AdminDAOImpl implements AdminDAO{
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
