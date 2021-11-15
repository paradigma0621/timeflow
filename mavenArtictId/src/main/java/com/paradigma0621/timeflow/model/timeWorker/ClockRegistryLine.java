package com.paradigma0621.timeflow.model.timeWorker;

import java.time.Duration;
import java.time.LocalDateTime;

import com.paradigma0621.timeflow.view.TextAreaWriter;

public class ClockRegistryLine {
	
	private String registryLine;
	private MomentData momentFrom, momentTo;
	private long elapsedMinutesCalculated, elapsedHoursCalculated, elapsedDaysCalculated;
	private LocalDateTime dateFrom, dateTo;
	private String elapsedTimeRegistry;
	private int hoursElapsedReaded, minutesElapsedReaded;

	public ClockRegistryLine(String line) {
	
		if (line.startsWith("CLOCK: ")) {
			this.registryLine = line;
			System.out.println("refLog:" + this.registryLine);
		}
		processTimePeriods(registryLine);
		//processElapsedTime(registryLine);
	}
/*
	public ClockRegistryLine(Paragraph p) {
		if (p.getText().startsWith("CLOCK: ")) {
			this.registryLine = p.getText();
			System.out.println("refLogP:" + this.registryLine);
		}
		processTimePeriods(registryLine);
		//processElapsedTime(registryLine);
	}
*/
	public void processTimePeriods(String registryLine) {

		 momentFrom  = new MomentData(); 
		 momentTo  = new MomentData();
		 
		dateFrom = TimeDataExtracted.getTimeDataFrom(registryLine, momentFrom);
		dateTo = TimeDataExtracted.getTimeDataTo(registryLine, momentTo);
				

		//dateFrom = momentFrom.getLocalDateTime();
		//dateTo = momentTo.getLocalDateTime();

		elapsedMinutesCalculated = Duration.between(dateFrom, dateTo).toMinutes();
		elapsedHoursCalculated = Duration.between(dateFrom, dateTo).toHours();
		elapsedDaysCalculated = Duration.between(dateFrom, dateTo).toDays();
		
		/*		
		System.out.println("ano: " + registryLine.substring(8, 12));
		System.out.println("mes: " + registryLine.substring(13, 15));
		System.out.println("dia: " + registryLine.substring(16, 18));
		System.out.println("diaSemana: " + registryLine.substring(19, 22));
		System.out.println("hora: " + registryLine.substring(23, 25));
		System.out.println("minuto: " + registryLine.substring(26, 28));

		System.out.println("ano: " + registryLine.substring(32, 36));
		System.out.println("mes: " + registryLine.substring(37, 39));
		System.out.println("dia: " + registryLine.substring(40, 42));
		System.out.println("diaSemana: " + registryLine.substring(43, 46));
		System.out.println("hora: " + registryLine.substring(47, 49));
		System.out.println("minuto: " + registryLine.substring(50, 52));
		*/
		System.out.println("dif time local date in minutes: " + elapsedMinutesCalculated);	
		System.out.println("dif time local date in hours: " + elapsedHoursCalculated);
		System.out.println("dif time local date in days: " + elapsedDaysCalculated);
		System.out.println(toString());
	}

	public String toString() {
		long days = elapsedDaysCalculated;
		int hours = (int) (elapsedHoursCalculated % 24);
		int minutes = (int) (elapsedMinutesCalculated % 60);
		
		String durationString = "Tempo transcorrido: " + days 
				+ " dia(s), " + hours + " hora(s), " + minutes + " minuto(s)";
		
		//System.out.println(hours + ":" + minutes + ":" + seconds);
		return durationString;
	}



	public void showInTextArea() {
		TextAreaWriter.writeTextArea("dif time local date in minutes: " + elapsedMinutesCalculated + "\n");
		TextAreaWriter.writeTextArea("dif time local date in hours: " + elapsedHoursCalculated + "\n");
		TextAreaWriter.writeTextArea("dif time local date in days: " + elapsedDaysCalculated + "\n");
		TextAreaWriter.writeTextArea("elapsed final substring: " + elapsedTimeRegistry + "\n\n\n");
		TextAreaWriter.writeTextArea(toString());
	}
	
	public void setRegistryLine(String registryLine) {
		this.registryLine = registryLine;
	}

	public long getElapsedMinutesCalculated() {
		return elapsedMinutesCalculated;
	}

	public long getElapsedHoursCalculated() {
		return elapsedHoursCalculated;
	}

	public long getElapsedDaysCalculated() {
		return elapsedDaysCalculated;
	}


	public MomentData getMomentFrom() {
		return momentFrom;
	}

	public void setMomentFrom(MomentData momentFrom) {
		this.momentFrom = momentFrom;
	}

	public MomentData getMomentTo() {
		return momentTo;
	}

	public void setMomentTo(MomentData momentTo) {
		this.momentTo = momentTo;
	}

	public String getRegistryLine() {
		return registryLine;
	}

}
