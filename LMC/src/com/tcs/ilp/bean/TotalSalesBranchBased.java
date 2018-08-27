package com.tcs.ilp.bean;

public class TotalSalesBranchBased {

	private String branch;
	private int quantity;
	private double revenue;
	private double growth;
	
	public TotalSalesBranchBased(String branch, int quantity, double revenue, double growth) {
		super();
		this.branch = branch;
		this.quantity = quantity;
		this.revenue = revenue;
		this.growth = growth;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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
