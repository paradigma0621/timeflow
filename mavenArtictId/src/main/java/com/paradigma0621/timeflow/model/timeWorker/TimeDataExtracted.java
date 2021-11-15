package com.paradigma0621.timeflow.model.timeWorker;

import java.time.LocalDateTime;

public class TimeDataExtracted {
	
	public static LocalDateTime getTimeDataFrom(String registryLine, MomentData momentFrom) {
		
		momentFrom.setYear(Integer.valueOf(registryLine.substring(8, 12)));
		momentFrom.setMonth(Integer.valueOf(registryLine.substring(13, 15)));
		momentFrom.setDay(Integer.valueOf(registryLine.substring(16, 18)));
		momentFrom.setWeekDay(registryLine.substring(19, 22));
		momentFrom.setHour(Integer.valueOf(registryLine.substring(23, 25)));
		momentFrom.setMinutes(Integer.valueOf(registryLine.substring(26, 28)));
		LocalDateTime localDateTime = LocalDateTime.of(
				momentFrom.getYear(), momentFrom.getMonth(), 
				momentFrom.getDay(), momentFrom.getHour(), 
				momentFrom.getMinutes());
		
		return localDateTime;
	}
	
	public static LocalDateTime getTimeDataTo(String registryLine, MomentData momentTo) {
		momentTo.setYear(Integer.valueOf(registryLine.substring(32, 36)));
		momentTo.setMonth(Integer.valueOf(registryLine.substring(37, 39)));
		momentTo.setDay(Integer.valueOf(registryLine.substring(40, 42)));
		momentTo.setWeekDay(registryLine.substring(43, 46));
		momentTo.setHour(Integer.valueOf(registryLine.substring(47, 49)));
		momentTo.setMinutes(Integer.valueOf(registryLine.substring(50, 52)));
		LocalDateTime localDateTime = LocalDateTime.of(
				momentTo.getYear(), momentTo.getMonth(), 
				momentTo.getDay(), momentTo.getHour(), 
				momentTo.getMinutes());
		
		return localDateTime;
	}
		
	public static long getElapsedHoursFromClockRegistryLine(String registryLine) {
		// Clock registry example:
		// CLOCK: [2021-05-22 sáb 10:21]--[2021-05-22 sáb 12:28] => 2:07

		int lastIndexOfSpace = registryLine.lastIndexOf(" ");
		int indexBefore2Points = registryLine.lastIndexOf(":");
		String hours = registryLine.substring(lastIndexOfSpace + 1, indexBefore2Points);
		long hoursElapsedReaded = Integer.valueOf(hours);
		return hoursElapsedReaded;
	}
	
	public static int getElapsedMinutesFromClockRegistryLine(String registryLine) {
		// Clock registry example:
		// CLOCK: [2021-05-22 sáb 10:21]--[2021-05-22 sáb 12:28] => 2:07

		int indexBeforeMinutes = registryLine.lastIndexOf(":");
		String minutes = registryLine.substring(indexBeforeMinutes + 1, registryLine.length());
		int minutesElapsedReaded = Integer.valueOf(minutes);
		return minutesElapsedReaded;
	}
	
}

