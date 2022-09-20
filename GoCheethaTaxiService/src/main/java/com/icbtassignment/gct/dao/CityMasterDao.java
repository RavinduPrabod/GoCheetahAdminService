package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.entities.CityMaster;

public class CityMasterDao {

	public static List<CityMaster> getList(DataSource dataSource){
		 
		List<CityMaster> cities = new ArrayList<CityMaster>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from citymaster";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int CityID = rset.getInt("CityID");
				String CityName = rset.getString("CityName");
				CityMaster city = new CityMaster(CityID,CityName);
				cities.add(city);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return cities;
 }

	public static void Add(DataSource dataSource, CityMaster city) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into citymaster (CityID,CityName,CreateDateTime,ModifiedDateTime) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, city.getCityID());
			pstmt.setString(2, city.getCityName());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));	
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(con,pstmt,null);
		}	
	}

	public static CityMaster get(DataSource dataSource, int cityId) {
		CityMaster cities = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "	SELECT * FROM citymaster where CityID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cityId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				int CityID = rset.getInt("CityID");
				String CityName = rset.getString("CityName");
				cities = new CityMaster(CityID,CityName);	
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return cities;
	}

	public static void Update(DataSource dataSource, CityMaster city) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "UPDATE CityMaster SET CityName=? WHERE CityID=?";
			 pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, city.getCityName());
			pstmt.setInt(2, city.getCityID());	
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}	
	}
	
	public static void Delete(DataSource dataSource, int CityID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM citymaster WHERE CityID=?";
			pstmt = con.prepareStatement(sql);	
			 
			pstmt.setInt(1, CityID);
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

