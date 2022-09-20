package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DashboardDao {

	public static Integer PendingCount(DataSource dataSource) {

		Integer PendingCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As PendingCount FROM bookingdetails WHERE Status = 1";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				PendingCount = rset.getInt("PendingCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return PendingCount;
	}

	public static Integer ActiveCount(DataSource dataSource) {

		Integer ActiveCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As ActiveCount FROM bookingheader WHERE Status IN(2,3,4)";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				ActiveCount = rset.getInt("ActiveCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return ActiveCount;
	}

	public static Integer CompleteCount(DataSource dataSource) {

		Integer CompleteCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As CompleteCount FROM dropbookinglist WHERE Status = 5";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				CompleteCount = rset.getInt("CompleteCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return CompleteCount;
	}

	public static Float Revenue(DataSource dataSource) {

		Float Revenue = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT SUM(NetAmount) As Revenue FROM dropbookinglist";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Revenue = rset.getFloat("Revenue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return Revenue;
	}

	public static Integer CustomerCount(DataSource dataSource) {

		Integer CustomerCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(CustomerID) As CustomerCount FROM customermaster ";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				CustomerCount = rset.getInt("CustomerCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return CustomerCount;
	}

	public static Integer DriverCount(DataSource dataSource) {

		Integer DriverCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(DriverID) As DriverCount FROM drivermaster";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				DriverCount = rset.getInt("DriverCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return DriverCount;
	}

	public static Integer VehicleCount(DataSource dataSource) {

		Integer VehicleCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(VehicleNo) As VehicleCount FROM vehiclemaster";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				VehicleCount = rset.getInt("VehicleCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return VehicleCount;
	}

	public static Integer BranchCount(DataSource dataSource) {

		Integer BranchCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BranchID) As BranchCount FROM branchmaster";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				BranchCount = rset.getInt("BranchCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return BranchCount;
	}

	public static Integer CancelCount(DataSource dataSource) {

		Integer CancelCount = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As CancelCount FROM rejectlist";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				CancelCount = rset.getInt("CancelCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return CancelCount;
	}

	public static Integer PendingCountD(DataSource dataSource , int DriverID) {

		Integer PendingCount = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As PendingCount FROM bookingdetails WHERE Status = 1 AND DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				PendingCount = rset.getInt("PendingCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return PendingCount;
	}

	public static Integer ActiveCountD(DataSource dataSource, int DriverID) {

		Integer ActiveCount = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As ActiveCount FROM bookingheader WHERE DriverID = ? AND Status IN(2,3,4)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				ActiveCount = rset.getInt("ActiveCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return ActiveCount;
	}

	public static Integer CompleteCountD(DataSource dataSource, int DriverID) {

		Integer CompleteCount = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As CompleteCount FROM dropbookinglist WHERE Status = 5 AND DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				CompleteCount = rset.getInt("CompleteCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return CompleteCount;
	}
	public static Integer CancelCountD(DataSource dataSource, int DriverID) {

		Integer CancelCount = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(BookingID) As CancelCount FROM rejectlist WHERE DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				CancelCount = rset.getInt("CancelCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return CancelCount;
	}
	public static Float RevenueD(DataSource dataSource, int DriverID) {

		Float Revenue = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT SUM(NetAmount) As Revenue FROM dropbookinglist WHERE DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();
			while (rset.next()) {
				Revenue = rset.getFloat("Revenue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return Revenue;
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
