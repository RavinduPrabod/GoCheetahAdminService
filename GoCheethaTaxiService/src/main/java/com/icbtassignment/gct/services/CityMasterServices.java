package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.CityMasterDao;
import com.icbtassignment.gct.entities.CityMaster;

public class CityMasterServices {
	
	public static List<CityMaster> getCity(DataSource dataSource){
		
		return CityMasterDao.getList(dataSource);
	}

	public static void deleteCity(DataSource dataSource, int cityId) {
		 CityMasterDao.Delete(dataSource,cityId);
		
	}

	public static CityMaster get(DataSource dataSource, int cityId) {
		// TODO Auto-generated method stub
		return CityMasterDao.get(dataSource, cityId);
	}

	public static void addcity(DataSource dataSource, CityMaster city) {
		CityMasterDao.Add(dataSource,city);
		
	}

	public static void updatecity(DataSource dataSource, CityMaster city) {
		CityMasterDao.Update(dataSource,city);
		
	}
}
