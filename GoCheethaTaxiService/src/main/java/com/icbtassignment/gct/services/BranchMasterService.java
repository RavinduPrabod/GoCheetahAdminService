package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.BranchMasterDao;
import com.icbtassignment.gct.entities.BranchMaster;
import com.icbtassignment.gct.entities.BranchMasterGridDto;

public class BranchMasterService {

	public static List<BranchMasterGridDto> getList(DataSource dataSource){	
		return BranchMasterDao.getList(dataSource);
	}
	
	public static void AddNew(DataSource dataSource, BranchMaster oMaster) {
		BranchMasterDao.AddNew(dataSource,oMaster);	
	}
	
	public static BranchMaster get(DataSource dataSource, int ID) {
		return BranchMasterDao.get(dataSource,ID);
	}
	
	public static void Update(DataSource dataSource, BranchMaster oMaster) {
		BranchMasterDao.Update(dataSource,oMaster);	
	}
	
	public static void Delete(DataSource dataSource, int ID) {
		BranchMasterDao.Delete(dataSource,ID);	
	}
}
