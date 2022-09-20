package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.CustomerMasterDao;
import com.icbtassignment.gct.entities.CustomerMaster;

public class CustomerMasterService {
	
	public static List<CustomerMaster> getList(DataSource dataSource){
		
		return CustomerMasterDao.getList(dataSource);
	}
}
