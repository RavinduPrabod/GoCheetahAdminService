package com.icbtassignment.gct.services;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.DashboardDao;

public class DashboardService {
	
	public static Integer PendingCount(DataSource dataSource) {
		return DashboardDao.PendingCount(dataSource);
	}
	
	public static Integer ActiveCount(DataSource dataSource) {
		return DashboardDao.ActiveCount(dataSource);
	}
	
	public static Integer CompleteCount(DataSource dataSource) {
		return DashboardDao.CompleteCount(dataSource);
	}
	
	public static Float Revenue(DataSource dataSource) {
		return DashboardDao.Revenue(dataSource);
	}
	
	public static Integer CustomerCount(DataSource dataSource) {
		return DashboardDao.CustomerCount(dataSource);
	}
	
	public static Integer DriverCount(DataSource dataSource) {
		return DashboardDao.DriverCount(dataSource);
	}
	
	public static Integer VehicleCount(DataSource dataSource) {
		return DashboardDao.VehicleCount(dataSource);
	}
	
	public static Integer BranchCount(DataSource dataSource) {
		return DashboardDao.BranchCount(dataSource);
	}
	
	public static Integer CancelCount(DataSource dataSource) {
		return DashboardDao.CancelCount(dataSource);
	}
	
	public static Integer PendingCountD(DataSource dataSource, int DriverID) {
		return DashboardDao.PendingCountD(dataSource,DriverID);
	}
	
	public static Integer ActiveCountD(DataSource dataSource, int DriverID) {
		return DashboardDao.ActiveCountD(dataSource,DriverID);
	}
	
	public static Integer CompleteCountD(DataSource dataSource, int DriverID) {
		return DashboardDao.CompleteCountD(dataSource,DriverID);
	}
	
	public static Float RevenueD(DataSource dataSource, int DriverID) {
		return DashboardDao.RevenueD(dataSource,DriverID);
	}
	public static Integer CancelCountD(DataSource dataSource, int DriverID) {
		return DashboardDao.CancelCountD(dataSource,DriverID);
	}

}
