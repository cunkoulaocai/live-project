package maskAppointment.dao;

import maskAppointment.pojo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import maskAppointment.util.DBUtil;

public class CitizenDAO{
	
	private Connection conn=null;
	private Statement stm=null;
	private ResultSet rs=null;
	
	public List<Citizen> get(String idNumber) {
		List<Citizen> list=new ArrayList<>();
		
		try {
			conn=DBUtil.getConnection();
			stm=conn.createStatement();
			String sql="select from citizen where idNumber='"+idNumber+"'";
			rs=stm.executeQuery(sql);
			while(rs.next()) {
				list.add(new Citizen(rs.getString("idNumber"),rs.getString("name"),rs.getString("phone"),rs.getInt("orderNum"),rs.getInt("lastRound")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stm, conn);
		}
		return list;
	}
	
	public void update(Citizen c) {
		try {
			conn=DBUtil.getConnection();
			stm=conn.createStatement();
			String sql="insert into citizen value('"+c.getIdNumber()+"','"+c.getName()+"','"+c.getPhone()+"',"+String.valueOf(c.getOrderNum())+","+String.valueOf(c.getLastRound());
			stm.execute(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stm, conn);
		}
	}
}
