package FactoryDesign;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.icbtassignment.gct.utils.CustomException;

public class Driverlogin implements Login{
	@Override
	public int verify(DataSource dataSource,String UserName, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		int returnVal = 0;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from drivermaster where UserName = ? and Password=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, UserName);
			stmt.setString(2, password);
			rset= stmt.executeQuery();
			
			if(rset.next()) {
				returnVal = 1;			
			}	
			else {
				returnVal = 0;
			}
		}
		 catch (SQLException e) {
				throw new CustomException(e.getMessage());
			}
		return returnVal;
	}
	
	private static void close(Connection con,Statement stmt,ResultSet rset) {
		try {
			if(rset != null)
			{
				rset.close();
			}
			if(stmt != null)
			{
				//stmt.close();
			}
			
			if(con != null)
			{
				con.close();
			}
			
		} catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}
		
	}
}
