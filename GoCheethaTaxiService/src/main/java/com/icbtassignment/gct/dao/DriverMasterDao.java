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
import com.icbtassignment.gct.entities.DriverMaster;
import com.icbtassignment.gct.entities.DriverMasterGridDto;

public class DriverMasterDao {
	
	public static List<DriverMasterGridDto> getDriverList(DataSource dataSource){
		 
		List<DriverMasterGridDto> DriversList = new ArrayList<DriverMasterGridDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select A.DriverID, A.DriverName, A.ContactNo, A.NIC, A.LicenseNo, B.BranchLocation, A.BranchID, A.VehicleNo, A.Status from drivermaster A inner join branchmaster B ON A.BranchID = B.BranchID";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Integer DriverID = rset.getInt("DriverID");
				String DriverName = rset.getString("DriverName");
				String ContactNo = rset.getString("ContactNo");
				String NIC = rset.getString("NIC");
				String LicenseNo = rset.getString("LicenseNo");
				Integer Status = rset.getInt("Status");
				Integer BranchID = rset.getInt("BranchID");
				String VehicleNo = rset.getString("VehicleNo");
				String BranchLocation = rset.getString("BranchLocation");
				DateTime CreateDatetime = null;
				DateTime ModifiedDateTime = null;
				DriverMasterGridDto oDriverMasterGridDto = new DriverMasterGridDto(DriverID, DriverName, ContactNo, NIC, LicenseNo, VehicleNo, Status, BranchID, BranchLocation,CreateDatetime,ModifiedDateTime);
				DriversList.add(oDriverMasterGridDto);
				
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return DriversList;
 }
	public static void addDriver(DataSource dataSource, DriverMaster oDriverMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into drivermaster (DriverName,ContactNo,NIC,LicenseNo,BranchID,VehicleNo,UserName,Password,Status,CreateDatetime,ModifiedDateTime) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, oDriverMaster.getDriverName());
			pstmt.setString(2, oDriverMaster.getContactNo());
			pstmt.setString(3, oDriverMaster.getNIC());
			pstmt.setString(4, oDriverMaster.getLicenseNo());
			pstmt.setInt(5, oDriverMaster.getBranchID());
			pstmt.setString(6, oDriverMaster.getVehicleNo());
			pstmt.setString(7, oDriverMaster.getUserName());
			pstmt.setString(8, oDriverMaster.getPassword());
			pstmt.setInt(9, oDriverMaster.getStatus());
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(con,pstmt,null);
		}	
	}
	
	public static DriverMasterGridDto get(DataSource dataSource, int id) {
		DriverMasterGridDto oDriverMaster = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select A.DriverID, A.DriverName, A.ContactNo, A.NIC, A.LicenseNo, B.BranchLocation, A.BranchID, A.VehicleNo, A.UserName, A.Password, A.Status from drivermaster A inner join branchmaster B ON A.BranchID = B.BranchID where A.DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Integer DriverID = rset.getInt("DriverID");
				String DriverName = rset.getString("DriverName");
				String ContactNo = rset.getString("ContactNo");
				String NIC = rset.getString("NIC");
				String LicenseNo = rset.getString("LicenseNo");
				Integer Status = rset.getInt("Status");
				Integer BranchID = rset.getInt("BranchID");
				String VehicleNo = rset.getString("VehicleNo");
				String UserName = rset.getString("UserName");
				String Password = rset.getString("Password");
				String BranchLocation = rset.getString("BranchLocation");
				DateTime CreateDatetime = null;
				DateTime ModifiedDateTime = null;
				oDriverMaster = new DriverMasterGridDto(DriverID, DriverName, ContactNo, NIC, LicenseNo, VehicleNo, Status, BranchID, BranchLocation,UserName,Password,CreateDatetime,ModifiedDateTime);	
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}	
		return oDriverMaster;
	}
	public static DriverMaster getDriverCardentils(DataSource dataSource, String Username) {
		DriverMaster oDriverMaster = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select A.DriverID, A.DriverName, A.VehicleNo from drivermaster A where A.UserName = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Username);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Integer DriverID = rset.getInt("DriverID");
				String DriverName = rset.getString("DriverName");
				String VehicleNo = rset.getString("VehicleNo");
				oDriverMaster = new DriverMaster(DriverID, DriverName, VehicleNo);	
			}	

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}	
		return oDriverMaster;
	}
	
	public static void UpdateDriver(DataSource dataSource, DriverMaster oDriverMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "UPDATE drivermaster SET DriverName=?,ContactNo=?, NIC=?, LicenseNo=?, Status=?, BranchID=?,VehicleNo=?,UserName=?,Password=?, ModifiedDateTime=? WHERE DriverID=?";
			 pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, oDriverMaster.getDriverName());
			pstmt.setString(2, oDriverMaster.getContactNo());
			pstmt.setString(3, oDriverMaster.getNIC());
			pstmt.setString(4, oDriverMaster.getLicenseNo());
			pstmt.setInt(5, oDriverMaster.getStatus());
			pstmt.setInt(6, oDriverMaster.getBranchID());
			pstmt.setString(7, oDriverMaster.getVehicleNo());
			pstmt.setString(8, oDriverMaster.getUserName());
			pstmt.setString(9, oDriverMaster.getPassword());
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(11, oDriverMaster.getDriverID());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}		
	}
	
	public static void DeleteDriver(DataSource dataSource, int DriverID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "DELETE FROM drivermaster WHERE DriverID=?";
			 pstmt = con.prepareStatement(sql);
					
			pstmt.setInt(1, DriverID);
		
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
			e.printStackTrace();
		}
	}
}
