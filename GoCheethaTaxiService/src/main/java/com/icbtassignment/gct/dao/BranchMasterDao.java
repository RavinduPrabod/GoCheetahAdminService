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

import org.joda.time.DateTime;

import com.icbtassignment.gct.entities.BranchMaster;
import com.icbtassignment.gct.entities.BranchMasterGridDto;

public class BranchMasterDao {
	public static List<BranchMasterGridDto> getList(DataSource dataSource) {

		List<BranchMasterGridDto> BranchList = new ArrayList<BranchMasterGridDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.CityID, A.BranchID, A.BranchLocation, B.CityName  from branchmaster A INNER JOIN citymaster B ON A.CityID = B.CityID";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Integer CityID = rset.getInt("CityID");
				Integer BranchID = rset.getInt("BranchID");
				String BranchLocation = rset.getString("BranchLocation");
				String CityName = rset.getString("CityName");

				BranchMasterGridDto oMaster = new BranchMasterGridDto(CityID, BranchID, BranchLocation,CityName);
				BranchList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return BranchList;
	}
	
	public static void AddNew(DataSource dataSource, BranchMaster oMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into branchmaster (BranchID,CityID,BranchLocation,CreateDatetime,ModifiedDateTime) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oMaster.getBranchID());
			pstmt.setInt(2, oMaster.getCityID());
			pstmt.setString(3, oMaster.getBranchLocation());
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(con,pstmt,null);
		}	
	}
	
	public static BranchMaster get(DataSource dataSource, int id) {
		BranchMaster oMaster = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from branchmaster where BranchID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Integer CityID = rset.getInt("CityID");
				Integer BranchID = rset.getInt("BranchID");
				String BranchLocation = rset.getString("BranchLocation");
				DateTime CreateDatetime = null;
				DateTime ModifiedDateTime = null;
				oMaster = new BranchMaster(CityID,BranchID,BranchLocation,CreateDatetime,ModifiedDateTime);	
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}	
		return oMaster;
	}
	
	public static void Update(DataSource dataSource, BranchMaster oMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "UPDATE branchmaster SET CityID=?, BranchLocation=?, ModifiedDateTime=? WHERE BranchID=?";
			 pstmt = con.prepareStatement(sql);
			
				
			pstmt.setInt(1, oMaster.getCityID());
			pstmt.setString(2, oMaster.getBranchLocation());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, oMaster.getBranchID());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}		
	}
	
	public static void Delete(DataSource dataSource, int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "DELETE FROM branchmaster WHERE BranchID=?";
			 pstmt = con.prepareStatement(sql);
					
			pstmt.setInt(1, id);
		
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}	
	}
	
	private static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}

			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
