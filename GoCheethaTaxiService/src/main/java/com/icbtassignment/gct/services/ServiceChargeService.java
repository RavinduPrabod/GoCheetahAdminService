package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.ServiceChargeDao;
import com.icbtassignment.gct.entities.ServiceCharge;

public class ServiceChargeService {
public static List<ServiceCharge> GetList(DataSource dataSource){
		
		return ServiceChargeDao.getList(dataSource);
	}

	public static void delete(DataSource dataSource, int cityId) {
		ServiceChargeDao.Delete(dataSource,cityId);
		
	}

	public static ServiceCharge get(DataSource dataSource, int cityId) {
		// TODO Auto-generated method stub
		return ServiceChargeDao.get(dataSource, cityId);
	}

	public static void add(DataSource dataSource, ServiceCharge city) {
		ServiceChargeDao.Add(dataSource,city);
		
	}

	public static void update(DataSource dataSource, ServiceCharge city) {
		ServiceChargeDao.Update(dataSource,city);
		
	}
}
