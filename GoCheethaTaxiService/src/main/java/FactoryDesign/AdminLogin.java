package FactoryDesign;

import javax.sql.DataSource;

public class AdminLogin implements Login {

	@Override
	public int verify(DataSource dataSource,String UserName, String password) {
		// TODO Auto-generated method stub
		return 1;
	}
}
