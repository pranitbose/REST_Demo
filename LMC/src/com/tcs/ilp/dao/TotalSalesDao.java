package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.bean.TotalSalesAllRegion;
import com.tcs.ilp.bean.TotalSalesBranchBased;
import com.tcs.ilp.bean.TotalSalesRegionBased;
import com.tcs.ilp.util.DbUtil;
import com.tcs.ilp.util.Month;

public class TotalSalesDao {

	public ArrayList<TotalSalesAllRegion> getTotalSalesByAllRegion(String month, String year) {
		Connection con = DbUtil.createConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TotalSalesAllRegion> salesList = new ArrayList<TotalSalesAllRegion>();
		TotalSalesAllRegion tsar;
		try {
			Month mon = Month.valueOf(month);
			String sql = "SELECT productCode, productName, SUM(quantity) AS salesQuantity, SUM(quantity * price) AS revenue FROM PRODUCTS_1418060 WHERE salesDate BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') GROUP BY productName, productCode ORDER BY productCode";
			ps = con.prepareStatement(sql);
			ps.setString(1, "01/"+mon.getMonth()+"/"+year);
			ps.setString(2, mon.getDays()+"/"+mon.getMonth()+"/"+year);
			rs = ps.executeQuery();
			int slid = 1;
			while (rs.next()) {
				tsar = new TotalSalesAllRegion(slid, rs.getString("productCode"), rs.getString("productName"), rs.getInt("salesQuantity"), rs.getDouble("revenue"));
				salesList.add(tsar);
				slid++;
			}
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closeStatement(ps);
			DbUtil.closeConnection();
		}
		return salesList;
	}
	
	public ArrayList<TotalSalesBranchBased> getTotalSalesBranchBased(String prevMonth, String month, String year) {
		Connection con = DbUtil.createConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<TotalSalesBranchBased> salesList = new ArrayList<TotalSalesBranchBased>();
		TotalSalesBranchBased tsbb;
		try {
			Month prevMon = Month.valueOf(prevMonth);
			Month mon = Month.valueOf(month);
			String sql1 = "SELECT SUBSTR(branchId, 4, 6) AS branch, SUM(quantity) AS salesQuantity, SUM(quantity * price) AS revenue FROM PRODUCTS_1418060 WHERE salesDate BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') GROUP BY SUBSTR(branchId, 4, 6) ORDER BY SUBSTR(branchId, 4, 6)";
			String sql2 = "SELECT SUBSTR(branchId, 4, 6) AS branch, SUM(quantity) AS salesQuantity, SUM(quantity * price) AS revenue FROM PRODUCTS_1418060 WHERE salesDate BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') GROUP BY SUBSTR(branchId, 4, 6) ORDER BY SUBSTR(branchId, 4, 6)";
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, "01/"+prevMon.getMonth()+"/"+year);
			ps1.setString(2, prevMon.getDays()+"/"+prevMon.getMonth()+"/"+year);
			ps2 = con.prepareStatement(sql2);
			ps2.setString(1, "01/"+mon.getMonth()+"/"+year);
			ps2.setString(2, mon.getDays()+"/"+mon.getMonth()+"/"+year);
			rs1 = ps1.executeQuery();
			rs2 = ps2.executeQuery();
			while (rs1.next() && rs2.next()) {
				double prevRev = rs1.getDouble(3);
				double rev = rs2.getDouble(3);
				double growth = ((rev - prevRev) / prevRev) * 100;
				tsbb = new TotalSalesBranchBased(rs2.getString(1), rs2.getInt(2), rs2.getDouble(3), growth);
				salesList.add(tsbb);
			}
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeResultSet(rs2);
			DbUtil.closeResultSet(rs1);
			DbUtil.closeStatement(ps2);
			DbUtil.closeStatement(ps1);
			DbUtil.closeConnection();
		}
		return salesList;
	}
	
	public ArrayList<TotalSalesRegionBased> getTotalSalesRegionBased(String prevMonth, String month, String year) {
		Connection con = DbUtil.createConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<TotalSalesRegionBased> salesList = new ArrayList<TotalSalesRegionBased>();
		TotalSalesRegionBased tsrb;
		try {
			Month prevMon = Month.valueOf(prevMonth);
			Month mon = Month.valueOf(month);
			String sql1 = "SELECT SUBSTR(branchId, 0, 3) AS region, SUM(quantity) AS salesQuantity, SUM(quantity * price) AS revenue FROM PRODUCTS_1418060 WHERE salesDate BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') GROUP BY SUBSTR(branchId, 0, 3) ORDER BY SUBSTR(branchId, 0, 3)";
			String sql2 = "SELECT SUBSTR(branchId, 0, 3) AS region, SUM(quantity) AS salesQuantity, SUM(quantity * price) AS revenue FROM PRODUCTS_1418060 WHERE salesDate BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') GROUP BY SUBSTR(branchId, 0, 3) ORDER BY SUBSTR(branchId, 0, 3)";
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, "01/"+prevMon.getMonth()+"/"+year);
			ps1.setString(2, prevMon.getDays()+"/"+prevMon.getMonth()+"/"+year);
			ps2 = con.prepareStatement(sql2);
			ps2.setString(1, "01/"+mon.getMonth()+"/"+year);
			ps2.setString(2, mon.getDays()+"/"+mon.getMonth()+"/"+year);
			rs1 = ps1.executeQuery();
			rs2 = ps2.executeQuery();
			while (rs1.next() && rs2.next()) {
				double prevRev = rs1.getDouble(3);
				double rev = rs2.getDouble(3);
				double growth = ((rev - prevRev) / prevRev) * 100;
				tsrb = new TotalSalesRegionBased(rs2.getString(1), rs2.getInt(2), rs2.getDouble(3), growth);
				salesList.add(tsrb);
			}
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeResultSet(rs2);
			DbUtil.closeResultSet(rs1);
			DbUtil.closeStatement(ps2);
			DbUtil.closeStatement(ps1);
			DbUtil.closeConnection();
		}
		return salesList;
	}
}
