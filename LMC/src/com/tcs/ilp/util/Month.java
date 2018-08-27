package com.tcs.ilp.util;

public enum Month {
	jan("01", "31"), 
	feb("02", "28"), 
	mar("03", "31"), 
	apr("04", "30"), 
	may("05", "31"), 
	jun("06", "30"), 
	jul("07", "31"), 
	aug("08", "31"), 
	sep("09", "30"), 
	oct("10", "31"), 
	nov("11", "30"), 
	dec("12", "31");
	
	private String monthNum;
	private String days;
	
	Month(String monthNum, String days) {
		this.monthNum = monthNum;
		this.days = days;
	}
	
	public String getMonth() {
		return monthNum;
	}

	public String getDays() {
		return days;
	}
}
