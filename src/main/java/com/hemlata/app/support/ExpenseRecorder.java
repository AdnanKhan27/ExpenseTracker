package com.hemlata.app.support;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Class: This is supported class which handles extra attributes 
 * 		  related to the application such as month, year selection.
 * 
 */
public class ExpenseRecorder {
	private Map<Integer, String> monthMap;
	private List<String> yearList;
	private String selectedMonth;
	private String selectedYear;	

	@SuppressWarnings("serial")
	public ExpenseRecorder() {
		monthMap = new HashMap<Integer, String>() {{
			put(1, "January");
			put(2, "February");
			put(3, "March");
			put(4, "April");
			put(5, "May");
			put(6, "June");
			put(7, "July");
			put(8, "August");
			put(9, "September");
			put(10, "October");
			put(11, "November");
			put(12, "December");
		}};
		
		yearList  = new ArrayList<>();
		for(int year = 2020; year <= 2030; year++)
				yearList.add(String.valueOf(year));
		
		Calendar now = Calendar.getInstance();
		
		selectedMonth = String.valueOf(now.get(Calendar.MONTH) + 1); 
		selectedYear = String.valueOf(now.get(Calendar.YEAR));		
	}

	public Map<Integer, String> getMonthMap() {
		return monthMap;
	}

	public void setMonthMap(Map<Integer, String> monthMap) {
		this.monthMap = monthMap;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public String getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public String getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(String selectedYear) {
		this.selectedYear = selectedYear;
	}

	/*
	 * Function: Get the key from the hash map based on the value.
	 */
	public Integer getKey(Map<Integer, String> map, String month) {
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			if(month.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "ExpenseRecorder [selectedMonth=" + selectedMonth + ", selectedYear=" + selectedYear + "]";
	}
	
	
}
