package com.paradigma0621.timeflow.model.timeWorker;

public class MomentData {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minutes;
	private String weekDay;

	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getWeekDay() {
		return weekDay;
	}
	
	public void setWeekDay(String weekDay) {
		this.weekDay = new String(weekDay);
	}
	

}
