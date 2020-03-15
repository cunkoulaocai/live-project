package maskAppointment.dao;

import maskAppointment.pojo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import maskAppointment.util.DBUtil;

public interface CitizenDAO {
	
	/**
	 * 将市民注册进表
	 * @param citizen
	 */
	public void register(Citizen citizen);
	/*
	 * 更新市民表里面的信息
	 */
	public void update(Citizen citizen);
	/**
	 * 判断市民是否存在于表中
	 * @param citizen
	 */
	public boolean existInRecord(Citizen citizen);
	/*
	 * 判断市民是否在预约表中
	 */
	public boolean existInCitizen(Citizen citizen);
	public void appointment(Citizen citizen);
	
}
