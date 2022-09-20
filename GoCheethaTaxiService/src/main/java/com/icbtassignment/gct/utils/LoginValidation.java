package com.icbtassignment.gct.utils;

import FactoryDesign.AdminLogin;
import FactoryDesign.Driverlogin;
import FactoryDesign.Login;

public class LoginValidation {
	public static Login factory(String type){
        if(type.equals("Driver")){
            
            return new Driverlogin();
            
        }else if(type.equals("Administration")){
            
            return new AdminLogin();
            
        }else{
            /**
             * It would be more appropriate to throw a custom exception here
             */
            throw new RuntimeException("No login type found");
        }
    }
}
