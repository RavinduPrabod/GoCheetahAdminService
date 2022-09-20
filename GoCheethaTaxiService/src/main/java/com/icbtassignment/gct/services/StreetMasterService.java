package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.StreetMasterDao;
import com.icbtassignment.gct.entities.StreetMaster;
import com.icbtassignment.gct.entities.StreetMasterDto;


public class StreetMasterService {
	
	public static List<StreetMasterDto> getList(DataSource dataSource){	
		return StreetMasterDao.getList(dataSource);
	}

	public static StreetMaster getData(DataSource dataSource, int cityId) {
		return StreetMasterDao.getData(dataSource, cityId);
	}

	public static void AddNew(DataSource dataSource, StreetMaster oStreetMaster) {
		StreetMasterDao.Add(dataSource,oStreetMaster);
		
	}

	public static void update(DataSource dataSource, StreetMaster oStreetMaster) {
		StreetMasterDao.Update(dataSource,oStreetMaster);		
	}
	
	public static void delete(DataSource dataSource, int cityId) {
		StreetMasterDao.Delete(dataSource,cityId);	
	}

}
