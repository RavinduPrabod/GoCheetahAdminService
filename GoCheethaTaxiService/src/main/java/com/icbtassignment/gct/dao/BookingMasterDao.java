package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.entities.ActiveBookingListDto;
import com.icbtassignment.gct.entities.CancelBookingListDto;
import com.icbtassignment.gct.entities.CustomerMaster;
import com.icbtassignment.gct.entities.DRidePendingListDto;
import com.icbtassignment.gct.entities.DropBookingListDto;
import com.icbtassignment.gct.entities.PendingBookingListDto;

public class BookingMasterDao {

	public static List<DRidePendingListDto> getDrvpendingList(DataSource dataSource) {

		List<DRidePendingListDto> DrvpendingList = new ArrayList<DRidePendingListDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , B.CityName, C.StreetName, A.PickUpLocation, A.PickUpdate, A.PickUptime, A.Status from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID WHERE A.Status = 1";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				String PickUptime = rset.getString("PickUptime");
				int Status = rset.getInt("Status");

				DRidePendingListDto oMaster = new DRidePendingListDto(BookingID, CityName, StreetName, PickUpLocation,
						PickUpdate, PickUptime, Status);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}

	public static List<PendingBookingListDto> getAdpendingList(DataSource dataSource) {

		List<PendingBookingListDto> DrvpendingList = new ArrayList<PendingBookingListDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , A.CustomerID, B.CityName, C.StreetName, A.PickUpLocation, A.PickUpdate, A.PickUptime, A.VehicleType, A.Status, A.CreateDateTime from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID WHERE A.Status = 1";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CustomerID = rset.getString("CustomerID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				Time PickUptime = rset.getTime("PickUptime");
				int VehicleType = rset.getInt("VehicleType");
				int Status = rset.getInt("Status");
				Date CreateDateTime = rset.getDate("CreateDateTime");

				PendingBookingListDto oMaster = new PendingBookingListDto(BookingID, CustomerID, CityName, StreetName,
						PickUpLocation, PickUpdate, PickUptime, VehicleType, Status, CreateDateTime);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}

	public static List<ActiveBookingListDto> getAdActiveList(DataSource dataSource) {

		List<ActiveBookingListDto> DrvpendingList = new ArrayList<ActiveBookingListDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , A.CustomerID, B.CityName, C.StreetName, E.DriverName, D.VehicleNo, A.VehicleType, D.Status, A.CreateDateTime from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID INNER JOIN bookingheader D on A.BookingID = D.BookingID INNER JOIN drivermaster E on E.DriverID = D.DriverID WHERE D.Status IN(2,3,4)";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CustomerID = rset.getString("CustomerID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String DriverName = rset.getString("DriverName");
				String VehicleNo = rset.getString("VehicleNo");
				int VehicleType = rset.getInt("VehicleType");
				int Status = rset.getInt("Status");
				Date CreateDateTime = rset.getDate("CreateDateTime");

				ActiveBookingListDto oMaster = new ActiveBookingListDto(BookingID, CustomerID, CityName, StreetName,
						DriverName, VehicleNo, VehicleType, Status, CreateDateTime);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}

	public static List<ActiveBookingListDto> getCOMPLETEList(DataSource dataSource) {

		List<ActiveBookingListDto> DrvpendingList = new ArrayList<ActiveBookingListDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , A.CustomerID, B.CityName, C.StreetName, E.DriverName, D.VehicleNo, A.VehicleType, D.Status, A.CreateDateTime from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID INNER JOIN dropbookinglist D on A.BookingID = D.BookingID INNER JOIN drivermaster E on E.DriverID = D.DriverID WHERE D.Status = 5";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CustomerID = rset.getString("CustomerID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String DriverName = rset.getString("DriverName");
				String VehicleNo = rset.getString("VehicleNo");
				int VehicleType = rset.getInt("VehicleType");
				int Status = rset.getInt("Status");
				Date CreateDateTime = rset.getDate("CreateDateTime");

				ActiveBookingListDto oMaster = new ActiveBookingListDto(BookingID, CustomerID, CityName, StreetName,
						DriverName, VehicleNo, VehicleType, Status, CreateDateTime);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}
	public static List<CancelBookingListDto> getCANCELEDist(DataSource dataSource) {

		List<CancelBookingListDto> CancelList = new ArrayList<CancelBookingListDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , C.CustomerID, A.DriverID, B.DriverName, B.VehicleNo, C.VehicleType, A.CreateDateTime from rejectlist A INNER JOIN drivermaster B on A.DriverID = B.DriverID INNER JOIN bookingdetails C on A.BookingID = C.BookingID WHERE C.Status = 0";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CustomerID = rset.getString("CustomerID");
				String DriverID = rset.getString("DriverID");
				String DriverName = rset.getString("DriverName");
				String VehicleNo = rset.getString("VehicleNo");
				int VehicleType = rset.getInt("VehicleType");
				int Status = 0;
				Date CreateDateTime = rset.getDate("CreateDateTime");

				CancelBookingListDto oMaster = new CancelBookingListDto(BookingID, CustomerID, DriverID,DriverName, VehicleNo, VehicleType, Status, CreateDateTime);
				CancelList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return CancelList;
	}

	public static List<DRidePendingListDto> getActiveList(DataSource dataSource, int DriverID) {

		List<DRidePendingListDto> DrvpendingList = new ArrayList<DRidePendingListDto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , B.CityName, C.StreetName, E.AmountperKM, F.Amount, A.PickUpLocation, A.PickUpdate, A.PickUptime, D.Status from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID INNER JOIN bookingheader D on A.BookingID = d.BookingID INNER join vehiclemaster E on A.VehicleType = E.VehicleType INNER join servicecharges f on A.VehicleType = F.VehicleType WHERE D.Status IN(2,3,4) AND D.DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String AmountperKM = rset.getString("AmountperKM");
				String Amount = rset.getString("Amount");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				String PickUptime = rset.getString("PickUptime");
				int Status = rset.getInt("Status");

				DRidePendingListDto oMaster = new DRidePendingListDto(BookingID, CityName, StreetName, AmountperKM, Amount, PickUpLocation,
						PickUpdate, PickUptime, Status);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}

	public static List<DRidePendingListDto> getComplteList(DataSource dataSource) {

		List<DRidePendingListDto> DrvpendingList = new ArrayList<DRidePendingListDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , B.CityName, C.StreetName, A.PickUpLocation, A.PickUpdate, A.PickUptime, D.Status from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID INNER JOIN dropbookinglist D on A.BookingID = D.BookingID WHERE D.Status =5";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				String PickUptime = rset.getString("PickUptime");
				int Status = rset.getInt("Status");

				DRidePendingListDto oMaster = new DRidePendingListDto(BookingID, CityName, StreetName, PickUpLocation,
						PickUpdate, PickUptime, Status);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}
	public static List<DRidePendingListDto> getDriverComplteList(DataSource dataSource, int DriverID) {

		List<DRidePendingListDto> DrvpendingList = new ArrayList<DRidePendingListDto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select A.BookingID , B.CityName, C.StreetName, A.PickUpLocation, A.PickUpdate, A.PickUptime, D.Status from bookingdetails A inner join citymaster B ON A.CityID = B.CityID inner join streetmaster C on A.StreetID = C.StreetID INNER JOIN dropbookinglist D on A.BookingID = D.BookingID WHERE D.Status =5 AND D.DriverID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, DriverID);
			rset = stmt.executeQuery();
			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String CityName = rset.getString("CityName");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				String PickUptime = rset.getString("PickUptime");
				int Status = rset.getInt("Status");

				DRidePendingListDto oMaster = new DRidePendingListDto(BookingID, CityName, StreetName, PickUpLocation,
						PickUpdate, PickUptime, Status);
				DrvpendingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return DrvpendingList;
	}

	public static CustomerMaster getCustInfo(DataSource dataSource, int id) {
		CustomerMaster custinfo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT A.CustomerID, A.FirstName, A.LastName, A.City, A.MobileNo, A.Email FROM customermaster A INNER JOIN bookingdetails B on A.CustomerID = B.CustomerID WHERE B.BookingID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rset = stmt.executeQuery();

			while (rset.next()) {
				String CustomerID = rset.getString("CustomerID");
				String FirstName = rset.getString("FirstName") + " " + rset.getString("LastName");
				String LastName = Integer.toString(id);
				String City = rset.getString("City");
				String MobileNo = rset.getString("MobileNo");
				String Email = rset.getString("Email");
				custinfo = new CustomerMaster(CustomerID, FirstName, LastName, City, MobileNo, Email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return custinfo;
	}

	/*
	 * public static void UpdateApprove(DataSource dataSource, int id) { Connection
	 * con = null; PreparedStatement pstmt = null; String sql = null;
	 * 
	 * try { con = dataSource.getConnection(); sql =
	 * "UPDATE bookingdetails SET Status=2, ModifiedDateTime=? WHERE BookingID=?";
	 * pstmt = con.prepareStatement(sql);
	 * 
	 * pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	 * pstmt.setInt(2, id); pstmt.execute();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { close(con, pstmt,
	 * null); } }
	 * 
	 * public static void UpdateONWAY(DataSource dataSource, int id) { Connection
	 * con = null; PreparedStatement pstmt = null; String sql = null;
	 * 
	 * try { con = dataSource.getConnection(); sql =
	 * "UPDATE bookingheader SET Status=3, ModifiedDateTime=? WHERE BookingID=?";
	 * pstmt = con.prepareStatement(sql);
	 * 
	 * pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	 * pstmt.setInt(2, id); pstmt.execute();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { close(con, pstmt,
	 * null); } }
	 * 
	 * public static void UpdatePICK(DataSource dataSource, int id) { Connection con
	 * = null; PreparedStatement pstmt = null; String sql = null;
	 * 
	 * try { con = dataSource.getConnection(); sql =
	 * "UPDATE bookingheader SET Status=4, ModifiedDateTime=? WHERE BookingID=?";
	 * pstmt = con.prepareStatement(sql);
	 * 
	 * pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	 * pstmt.setInt(2, id); pstmt.execute();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { close(con, pstmt,
	 * null); } }
	 * 
	 * public static void UpdateDROP(DataSource dataSource, int id) { Connection con
	 * = null; PreparedStatement pstmt = null; String sql = null;
	 * 
	 * try { con = dataSource.getConnection(); sql =
	 * "UPDATE bookingheader SET Status=5, ModifiedDateTime=? WHERE BookingID=?";
	 * pstmt = con.prepareStatement(sql);
	 * 
	 * pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	 * pstmt.setInt(2, id); pstmt.execute();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { close(con, pstmt,
	 * null); } }
	 */

	public static void UpdateStatusHeader(DataSource dataSource, int id, int status) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "UPDATE bookingheader SET Status=?, ModifiedDateTime=? WHERE BookingID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, status);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(3, id);
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}

	public static void UpdateStatusDetails(DataSource dataSource, int id, int status) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "UPDATE bookingdetails SET Status=?, ModifiedDateTime=? WHERE BookingID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, status);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(3, id);
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}


	public static void InsertBookingHeader(DataSource dataSource, int BookID, int DriverID, String VehicleNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "insert into bookingheader (BookingID,DriverID,VehicleNo,Status,CreateDateTime,ModifiedDateTime) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,BookID);
			pstmt.setInt(2, DriverID);
			pstmt.setString(3, VehicleNo);
			pstmt.setInt(4, 2);
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}
	
	public static void InsertBookingRejectList(DataSource dataSource, int BookID, int DriverID, String VehicleNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "insert into rejectlist (BookingID,DriverID,Status,CreateDateTime,ModifiedDateTime) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, BookID);
			pstmt.setInt(2, DriverID);
			pstmt.setInt(3, 0);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}
	
	public static void InsertBookingDropList(DataSource dataSource, DropBookingListDto droplist, String ServiceCharge, int KMCovered , String total ) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "insert into dropbookinglist (BookingID,DriverID,VehicleNo,AmountperKM,ServiceCharge,TotalKM,NetAmount,Status,CreateDateTime,ModifiedDateTime) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, droplist.getBookingID());
			pstmt.setInt(2, droplist.getDriverID());
			pstmt.setString(3, droplist.getVehicleNo());
			pstmt.setFloat(4, droplist.getAmountperKM());
			pstmt.setString(5, ServiceCharge);
			pstmt.setInt(6, KMCovered);
			pstmt.setString(7, total);
			pstmt.setFloat(8, 5);
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}
	public static DropBookingListDto getBookingDetails(DataSource dataSource, int BID) {
		DropBookingListDto oDriverMaster = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select A.BookingID , A.DriverID, A.VehicleNo, B.AmountperKM from bookingheader A INNER JOIN vehiclemaster B on A.VehicleNo = B.VehicleNo where A.BookingID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, BID);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				Integer DriverID = rset.getInt("DriverID");
				String VehicleNo = rset.getString("VehicleNo");
				float AmountperKM = rset.getFloat("AmountperKM");
				oDriverMaster = new DropBookingListDto(BookingID, DriverID, VehicleNo, AmountperKM);	
			}	

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}	
		return oDriverMaster;
	}

	/*
	 * public static DropBookingListDto getConfirmBookingDetails(DataSource
	 * dataSource, int BID) { DropBookingListDto oDriverMaster = null; Connection
	 * con = null; PreparedStatement stmt = null; ResultSet rset = null; String sql
	 * = null;
	 * 
	 * try { con = dataSource.getConnection(); sql=
	 * "select A.BookingID, A.VehicleNo from bookingdetails A INNER JOIN vehiclemaster B on A.VehicleNo = B.VehicleNo where A.BookingID = ?"
	 * ; stmt = con.prepareStatement(sql); stmt.setInt(1, BID); rset=
	 * stmt.executeQuery();
	 * 
	 * while(rset.next()) { Integer BookingID = rset.getInt("BookingID"); Integer
	 * DriverID = rset.getInt("DriverID"); String VehicleNo =
	 * rset.getString("VehicleNo"); oDriverMaster = new
	 * DropBookingListDto(BookingID, DriverID, VehicleNo); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }finally {
	 * 
	 * close(con,stmt,null); } return oDriverMaster; }
	 */
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
