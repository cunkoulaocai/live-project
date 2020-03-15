package maskAppointment.dao;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sound.midi.Soundbank;

import com.sun.crypto.provider.RSACipher;

import maskAppointment.pojo.Citizen;
import maskAppointment.util.DBUtil;

public class CitizenDaoImpl implements CitizenDAO {

	/**
	 * 将市民注册到表中去
	 */
	@Override
	public void register(Citizen citizen) {
		String sql = String.format("insert into citizen values('%s','%s','%s',%d,%d)", citizen.getIdNumber(),
								citizen.getName(),citizen.getPhone(),citizen.getOrderNum(),citizen.getLastRound());
		
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			if (existInCitizen(citizen)) {
				return;
			}
			else {
				ps.execute();
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 判断一个用户是否在citizen表中
	 */
	@Override
	public boolean existInCitizen(Citizen citizen) {
		String sql = String.format("select * from citizen where idNumber='%s' or phone='%s'", 
									citizen.getIdNumber(),citizen.getPhone());
		try (Connection connection = DBUtil.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql);){
			ResultSet rSet = ps.executeQuery();
			
			if (rSet.next()) {
				rSet.close();
				ps.close();
				connection.close();
				return true;
			}
			else {
				rSet.close();
				ps.close();
				connection.close();
				return false;
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/*
	 * 判断用户是否在预约表中
	 */
	public boolean existInRecord(Citizen citizen) {
		String sql = String.format("select * in citizen where idNumber='%s'", citizen.getIdNumber());
		try (Connection connection = DBUtil.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rs.close();
				ps.close();
				connection.close();
				return true;
			}
			else {
				rs.close();
				ps.close();
				connection.close();
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/*
	 * 将一个市民添加到预约表中
	 */
	@Override
	public void appointment(Citizen citizen) {
		// 先判断市民可不可以预约
		//1.如果市民已经在预约表中
		if (existInRecord(citizen)) return;
		//2.如果市民还没中签过或者上次中签时间在2轮之前
		SystemTimeDAO systemtimeDAO = new SystemTimeDAOImpl();
		int currentRound = systemtimeDAO.getTotal();
		try {
			String sql = String.format("select * from citizen where idNumber='%s'", citizen.getIdNumber());
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			int lastRound;
			// 先看用户有没有在是市民表中,如果有先注册到市民表
			if (!existInCitizen(citizen)) {
				register(citizen);
				lastRound = citizen.getLastRound();
			}
			else {
				rs.first();
				lastRound = rs.getInt("lastRound");
			}
			// 代表可以预约
			rs.close();
			pStatement.close();
			connection.close();
			if (lastRound!=0 && currentRound-lastRound<=2) return;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String daString = sdf.format(new Date());
		String getLastIdSql = "select * from orderinformation";
		
		try (Connection connection = DBUtil.getConnection();
			 PreparedStatement pStatement = connection.prepareStatement(getLastIdSql)) {
			ResultSet rs = pStatement.executeQuery();
			String last;
			System.out.println("你好1");
			// 如果这个市民是第一个预约的
			if (rs.isBeforeFirst()) {
				rs.next();
				rs.last();
				last = rs.getString("orderId").substring(8);
			}
			else {
				last = "999";
				System.out.println("weikong");
			}
			// 获取上一个记录的id+1
			int orderId = Integer.parseInt(last) + 1;
			String currentOrderId = daString + orderId;
			// 插入预约表
			String insertSql = String.format("insert into orderInformation values('%s','%s',%d)",
					currentOrderId,citizen.getIdNumber(),currentRound);
			
			PreparedStatement insertPs = connection.prepareStatement(insertSql);
			insertPs.execute();
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
		}
	}

	@Override
	public void update(Citizen citizen) {
		// TODO Auto-generated method stub
		
	}

}
