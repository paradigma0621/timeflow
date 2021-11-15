package com.paradigma0621.timeflow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.paradigma0621.timeflow.model.timeWorker.ClockRegistryLine;
import com.paradigma0621.timeflow.model.timeWorker.TimeDataExtracted;

public class ClockStringTest {
	
	@Test
	public void simpleTestFrom() {
		String timeLine = new String("CLOCK: [2021-05-22 sáb 10:21]--[2021-05-22 sáb 14:28] => 4:07");
		ClockRegistryLine clock1 = new ClockRegistryLine(timeLine);

		assertEquals(2021,clock1.getMomentFrom().getYear());
		assertEquals(05,clock1.getMomentFrom().getMonth());
		assertEquals(22,clock1.getMomentFrom().getDay());
		assertEquals("sáb",clock1.getMomentFrom().getWeekDay());
		assertEquals(10,clock1.getMomentFrom().getHour());
		assertEquals(21,clock1.getMomentFrom().getMinutes());
	}
	
	@Test
	public void simpleTestTo() {
		String timeLine = new String("CLOCK: [2021-05-22 sáb 10:21]--[2021-05-22 sáb 14:28] => 4:07");
		ClockRegistryLine clock1 = new ClockRegistryLine(timeLine);

		assertEquals(2021,clock1.getMomentTo().getYear());
		assertEquals(05,clock1.getMomentTo().getMonth());
		assertEquals(22,clock1.getMomentTo().getDay());
		assertEquals("sáb",clock1.getMomentTo().getWeekDay());
		assertEquals(14,clock1.getMomentTo().getHour());
		assertEquals(28,clock1.getMomentTo().getMinutes());
	}

	public void simpleTestTimeElapsedCalculated() {
		String timeLine = new String("CLOCK: [2021-05-22 sáb 10:21]--[2021-05-22 sáb 14:28] => 4:07");
		ClockRegistryLine clock1 = new ClockRegistryLine(timeLine);

		assertEquals(0,clock1.getElapsedDaysCalculated());
		assertEquals(4,clock1.getElapsedHoursCalculated());
		assertEquals(247,clock1.getElapsedMinutesCalculated());
	}
	
	
	@Test
	public void simpleTestTimeElapsedFromClockRegistryLine() {
		String timeLine = new String("CLOCK: [2021-05-22 sáb 10:21]--[2021-05-22 sáb 14:28] => 4:07");
		assertEquals(4,TimeDataExtracted.getElapsedHoursFromClockRegistryLine(timeLine));
		assertEquals(7,TimeDataExtracted.getElapsedMinutesFromClockRegistryLine(timeLine));
	}

}
