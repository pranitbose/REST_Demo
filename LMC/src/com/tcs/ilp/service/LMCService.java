package com.tcs.ilp.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tcs.ilp.bean.TotalSalesAllRegion;
import com.tcs.ilp.bean.TotalSalesBranchBased;
import com.tcs.ilp.bean.TotalSalesRegionBased;
import com.tcs.ilp.dao.TotalSalesDao;

@Path("/sales")
public class LMCService {
	
	TotalSalesDao tsd = new TotalSalesDao();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello World";
	}
	
	@GET
	@Path("/allRegion/{year}/{month}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TotalSalesAllRegion> getTotalSalesByAllRegion(@PathParam("month") String month, @PathParam("year") String year) {
		return tsd.getTotalSalesByAllRegion(month, year);
	}
	
	@GET
	@Path("/regionBased/{year}/{prevMonth}-{month}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TotalSalesRegionBased> getTotalSalesRegionBased(@PathParam("prevMonth") String prevMonth, @PathParam("month") String month, @PathParam("year") String year) {
		return tsd.getTotalSalesRegionBased(prevMonth, month, year);
	}
	
	@GET
	@Path("/branchBased/{year}/{prevMonth}-{month}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TotalSalesBranchBased> getTotalSalesBranchBased(@PathParam("prevMonth") String prevMonth, @PathParam("month") String month, @PathParam("year") String year) {
		return tsd.getTotalSalesBranchBased(prevMonth, month, year);
	}
}
