package com.tcs.ilp.bean;

public class TotalSalesAllRegion {

	private int slId;
	private String productCode;
	private String productName;
	private int quantity;
	private double revenue;
	
	public TotalSalesAllRegion(int slId, String productCode, String productName, int quantity, double revenue) {
		super();
		this.slId = slId;
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
		this.revenue = revenue;
	}

	public int getSlId() {
		return slId;
	}

	public void setSlId(int slId) {
		this.slId = slId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
}
