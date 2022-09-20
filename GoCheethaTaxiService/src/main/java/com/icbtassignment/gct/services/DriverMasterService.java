package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.DriverMasterDao;
import com.icbtassignment.gct.entities.DriverMaster;
import com.icbtassignment.gct.entities.DriverMasterGridDto;

public class DriverMasterService {

	public static List<DriverMasterGridDto> getDriverList(DataSource dataSource){	
		return DriverMasterDao.getDriverList(dataSource);
	}
	
	public static void AddNewDriver(DataSource dataSource, DriverMaster oDriverMaster) {
		DriverMasterDao.addDriver(dataSource,oDriverMaster);	
	}
	
	public static DriverMasterGridDto get(DataSource dataSource, int DriverID) {
		return DriverMasterDao.get(dataSource,DriverID);
	}
	
	public static void UpdateDriver(DataSource dataSource, DriverMaster oDriverMaster) {
		DriverMasterDao.UpdateDriver(dataSource,oDriverMaster);	
	}
	
	public static void DeleteDriver(DataSource dataSource, int DriverID) {
		DriverMasterDao.DeleteDriver(dataSource,DriverID);	
	}
	
	public static DriverMaster getDriverCardentials(DataSource dataSource, String username) {
	 return DriverMasterDao.getDriverCardentils(dataSource,username);	
	}
	
	
}
