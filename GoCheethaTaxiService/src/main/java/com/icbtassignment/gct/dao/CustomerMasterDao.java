package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import com.icbtassignment.gct.entities.CustomerMaster;

public class CustomerMasterDao {
	
	public static List<CustomerMaster> getList(DataSource dataSource){
		 
		List<CustomerMaster> olist = new ArrayList<CustomerMaster>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from customermaster";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String CustomerID  = rset.getString("CustomerID");
				String FirstName = rset.getString("FirstName") + " " + rset.getString("LastName");;
				String LastName = rset.getString("LastName");
				String City = rset.getString("City");
				String MobileNo = rset.getString("MobileNo");
				String Email = rset.getString("Email");
//				SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
//				String dates=formatter.format(CreateDateTime);
				CustomerMaster ls = new CustomerMaster(CustomerID,FirstName,LastName,City,MobileNo,Email);
				olist.add(ls);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return olist;
 }
	
	private static void close(Connection con,Statement stmt,ResultSet rset) {
		try {
			if(rset != null)
			{
				rset.close();
			}
			if(stmt != null)
			{
				stmt.close();
			}
			
			if(con != null)
			{
				con.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
