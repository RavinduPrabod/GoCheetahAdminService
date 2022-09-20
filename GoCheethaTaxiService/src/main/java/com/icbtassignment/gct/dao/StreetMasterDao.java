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

import com.icbtassignment.gct.entities.StreetMaster;
import com.icbtassignment.gct.entities.StreetMasterDto;

public class StreetMasterDao {
	
	public static List<StreetMasterDto> getList(DataSource dataSource){
		 
		List<StreetMasterDto> olist = new ArrayList<StreetMasterDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql = "select A.StreetID, A.StreetName, A.CityID, B.CityName from streetmaster A INNER JOIN citymaster B ON A.CityID = B.CityID";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int StreetID = rset.getInt("StreetID");
				String StreetName = rset.getString("StreetName");
				int CityID = rset.getInt("CityID");
				String CityName = rset.getString("CityName");
				StreetMasterDto slist = new StreetMasterDto(StreetID,StreetName,CityID,CityName);
				olist.add(slist);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return olist;
 }

	public static void Add(DataSource dataSource, StreetMaster oStreetMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into streetmaster (StreetID,StreetName,CityID,CreateDateTime,ModifiedDateTime) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oStreetMaster.getStreetID());
			pstmt.setString(2, oStreetMaster.getStreetName());
			pstmt.setInt(3, oStreetMaster.getCityID());
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));	
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(con,pstmt,null);
		}	
	}

	public static StreetMaster getData(DataSource dataSource, int id) {
		StreetMaster cities = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "	SELECT * FROM streetmaster where StreetID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				int StreetID = rset.getInt("StreetID");
				String StreetName = rset.getString("StreetName");
				int CityID = rset.getInt("CityID");
				cities = new StreetMaster(StreetID,StreetName,CityID);	
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return cities;
	}

	public static void Update(DataSource dataSource, StreetMaster oStreetMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "UPDATE streetmaster SET StreetName=?, CityID=? WHERE StreetID=?";
			 pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, oStreetMaster.getStreetName());
			pstmt.setInt(2, oStreetMaster.getCityID());	
			pstmt.setInt(3, oStreetMaster.getStreetID());	
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
			sql = "DELETE FROM streetmaster WHERE StreetID=?";
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
