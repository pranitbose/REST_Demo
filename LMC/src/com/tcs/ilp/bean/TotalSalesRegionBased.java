package com.tcs.ilp.bean;

public class TotalSalesRegionBased {

	private String region;
	private int quantity;
	private double revenue;
	private double growth;
	
	public TotalSalesRegionBased(String region, int quantity, double revenue, double growth) {
		super();
		this.region = region;
		this.quantity = quantity;
		this.revenue = revenue;
		this.growth = growth;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getGrowth() {
		return growth;
	}

	public void setGrowth(double growth) {
		this.growth = growth;
	}
}
