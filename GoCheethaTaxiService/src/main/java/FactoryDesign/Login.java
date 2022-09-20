package FactoryDesign;

import javax.sql.DataSource;

public interface Login {
	public int verify(DataSource dataSource,String UserName , String password);
}
