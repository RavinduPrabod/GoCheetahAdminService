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

import com.icbtassignment.gct.entities.VehicleMaster;
import com.icbtassignment.gct.entities.VehicleMasterGridDto;

public class VehicleMasterDao {

	public static List<VehicleMasterGridDto> getList(DataSource dataSource) {

		List<VehicleMasterGridDto> VehicleList = new ArrayList<VehicleMasterGridDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.VehicleNo, A.VehicleType, A.VehicleOwnerName, A.BranchID, B.BranchLocation, A.AmountperKM, A.Status from vehiclemaster A inner join branchmaster B ON A.BranchID = B.BranchID";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				String VehicleNo = rset.getString("VehicleNo");
				Integer VehicleType = rset.getInt("VehicleType");
				String VehicleOwnerName = rset.getString("VehicleOwnerName");
				Integer BranchID = rset.getInt("BranchID");
				String BranchLocation = rset.getString("BranchLocation");
				Float AmountperKM = rset.getFloat("AmountperKM");
				Integer Status = rset.getInt("Status");
				DateTime CreateDatetime = null;
				DateTime ModifiedDateTime = null;
				VehicleMasterGridDto olit = new VehicleMasterGridDto(VehicleNo, VehicleType, VehicleOwnerName, BranchID, BranchLocation, AmountperKM, Status, CreateDatetime, ModifiedDateTime);
				VehicleList.add(olit);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return VehicleList;
	}

	public static void AddNew(DataSource dataSource, VehicleMaster oMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "insert into vehiclemaster (VehicleNo,VehicleType,VehicleOwnerName,BranchID,AmountperKM,Status,CreateDatetime,ModifiedDateTime) values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, oMaster.getVehicleNo());
			pstmt.setInt(2, oMaster.getVehicleType());
			pstmt.setString(3, oMaster.getVehicleOwnerName());
			pstmt.setInt(4, oMaster.getBranchID());
			pstmt.setFloat(5, oMaster.getAmountperKM());
			pstmt.setInt(6, oMaster.getStatus());
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}

	public static VehicleMaster get(DataSource dataSource, String id) {
		VehicleMaster oMaster = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select * from vehiclemaster where VehicleNo = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rset = stmt.executeQuery();

			while (rset.next()) {
				String VehicleNo = rset.getString("VehicleNo");
				Integer VehicleType = rset.getInt("VehicleType");
				String VehicleOwnerName = rset.getString("VehicleOwnerName");
				Integer BranchID = rset.getInt("BranchID");
				Float AmountperKM = rset.getFloat("AmountperKM");
				Integer Status = rset.getInt("Status");
				DateTime CreateDatetime = null;
				DateTime ModifiedDateTime = null;
				oMaster = new VehicleMaster(VehicleNo, VehicleType, VehicleOwnerName, BranchID,AmountperKM, Status, CreateDatetime,
						ModifiedDateTime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return oMaster;
	}

	public static void Update(DataSource dataSource, VehicleMaster oMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "UPDATE vehiclemaster SET VehicleType=?, VehicleOwnerName=?, BranchID=?, AmountperKM=?, Status=?, ModifiedDateTime=? WHERE VehicleNo=?";
			pstmt = con.prepareStatement(sql);
	
			pstmt.setInt(1, oMaster.getVehicleType());
			pstmt.setString(2, oMaster.getVehicleOwnerName());
			pstmt.setInt(3, oMaster.getBranchID());
			pstmt.setFloat(4, oMaster.getAmountperKM());
			pstmt.setInt(5, oMaster.getStatus());
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(7, oMaster.getVehicleNo());
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}

	public static void Delete(DataSource dataSource, String ID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM vehiclemaster WHERE VehicleNo=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, ID);

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
