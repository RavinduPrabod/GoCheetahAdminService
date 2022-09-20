package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.VehicleMasterDao;
import com.icbtassignment.gct.entities.VehicleMaster;
import com.icbtassignment.gct.entities.VehicleMasterGridDto;


public class VehicleMasterService {
	
	public static List<VehicleMasterGridDto> getList(DataSource dataSource){	
		return VehicleMasterDao.getList(dataSource);
	}
	
	public static void AddNew(DataSource dataSource, VehicleMaster oMaster) {
		VehicleMasterDao.AddNew(dataSource,oMaster);	
	}
	
	public static VehicleMaster get(DataSource dataSource, String ID) {
		return VehicleMasterDao.get(dataSource,ID);
	}
	
	public static void Update(DataSource dataSource, VehicleMaster oMaster) {
		VehicleMasterDao.Update(dataSource,oMaster);	
	}
	
	public static void Delete(DataSource dataSource, String ID) {
		VehicleMasterDao.Delete(dataSource,ID);	
	}
}
