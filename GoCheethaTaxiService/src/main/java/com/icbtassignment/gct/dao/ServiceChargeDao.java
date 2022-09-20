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

import com.icbtassignment.gct.entities.ServiceCharge;

public class ServiceChargeDao {
	public static List<ServiceCharge> getList(DataSource dataSource){
		 
		List<ServiceCharge> oServiceChargeList = new ArrayList<ServiceCharge>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from servicecharges";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int VehicleType  = rset.getInt("VehicleType");
				String Amount = rset.getString("Amount");
				ServiceCharge oServiceCharge = new ServiceCharge(VehicleType,Amount);
				oServiceChargeList.add(oServiceCharge);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return oServiceChargeList;
 }

	public static void Add(DataSource dataSource, ServiceCharge charge) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into servicecharges (VehicleType ,Amount,CreateDateTime,ModifiedDateTime) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, charge.getVehicleType());
			pstmt.setString(2, charge.getAmount());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));	
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(con,pstmt,null);
		}	
	}

	public static ServiceCharge get(DataSource dataSource, int type ) {
		ServiceCharge oServiceCharge = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "	SELECT * FROM ServiceCharges where VehicleType = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, type);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				int VehicleType = rset.getInt("VehicleType");
				String Amount = rset.getString("Amount");
				oServiceCharge = new ServiceCharge(VehicleType,Amount);	
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return oServiceCharge;
	}

	public static void Update(DataSource dataSource, ServiceCharge oServiceCharge) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "UPDATE ServiceCharges SET Amount=? WHERE VehicleType=?";
			 pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, oServiceCharge.getAmount());
			pstmt.setInt(2, oServiceCharge.getVehicleType());	
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, null);
		}	
	}
	
	public static void Delete(DataSource dataSource, int type) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM ServiceCharges WHERE VehicleType=?";
			pstmt = con.prepareStatement(sql);	
			 
			pstmt.setInt(1, type);
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
