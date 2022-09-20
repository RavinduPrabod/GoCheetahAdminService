package com.icbtassignment.gct.services;

import javax.sql.DataSource;

import com.icbtassignment.gct.utils.LoginValidation;

import FactoryDesign.Login;

public class LoginService {
	public  static boolean checkAuthentication(DataSource datasource,String type, String Username,String password) {
		int checkCredinatial ;
		Login login;
		
		 if(type.equals("Driver")){
	            
				login = LoginValidation.factory(type);
				checkCredinatial = login.verify(datasource,Username, password);
				if(checkCredinatial == 1) {
					
					return true ;
				}
				else {
					return false;
				}
	            
	        }else if(type.equals("Administration")){
	            
	        	login = LoginValidation.factory(type);
	        	checkCredinatial = login.verify(datasource,Username, password);
	        	if(checkCredinatial == 1) {
	    			
	    			return true ;
	    		}
	    		else {
	    			return false;
	    		}
	            
	        }
	        else {
	        	 throw new RuntimeException("No login type found");
	        }
		
       
	}
}
