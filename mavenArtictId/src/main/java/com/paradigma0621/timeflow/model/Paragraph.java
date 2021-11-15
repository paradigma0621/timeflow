package com.paradigma0621.timeflow.model;

import java.util.Optional;

import com.paradigma0621.timeflow.model.timeWorker.ClockRegistryLine;
import com.paradigma0621.timeflow.model.timeWorker.ClockReport;

public class Paragraph {
	private String text = "";
	private TreeItemImp<String> treeItemImp;
	//private ClockReport clockReport;
	private Optional<ClockReport> clockReport;
	private boolean isClockReportPresent = false;
	private int beginsWithThisNumberOfAsterisks;
	private int linePositionInsideDocParagraphsList;
	
	/**
	 * The indexOfParentInsideDocParagraphs variable is the corresponding TreeView parent item position in the list docParagraphs of Paragraphs. That is: which is the index of the parent TreeItem of the current paragraph object inside the docParagraphs? If indexOfParentInsideDocParagraphs=-1 this means that the parent is the "base" of the document, and not another Paragraph inside docParagraphs.
	 */
	private int indexOfParentInsideDocParagraphsList;

	public Paragraph(String text) {
		this.text = text; 
		this.beginsWithThisNumberOfAsterisks = Tools.calculateHowManyAsterisksTextBeginsWith(text);
		ClockReport clockReportNull = null;
		clockReport = Optional.ofNullable(clockReportNull);
	}
	
	public long getTotalMinutesSkeletonSum() {
		/*long minutes=0;
		int inicialIndex = linePositionInsideDocParagraphsList;
		while (true) {
			
			
		}
		//int finalIndex =
		
				clockRegistryLines.get(0).setLinePositionInsideDocParagraphsList(u);
		for (ClockRegistryLine clock:clockRegistryLines) {
			minutes += clock.getElapsedMinutesCalculated(); 
		}
		*/
		return 1l;
		
	}

	
	public int getLinePositionInsideDocParagraphsList() {
		return linePositionInsideDocParagraphsList;
	}

	public void setLinePositionInsideDocParagraphsList(int linePositionInsideDocParagraphsList) {
		this.linePositionInsideDocParagraphsList = linePositionInsideDocParagraphsList;
	}

	public Optional<ClockReport> getClockReport() {
		return clockReport;
	}


	
	public void setClockReport(ClockReport clockReport) {
		this.clockReport = Optional.of(clockReport);
		isClockReportPresent = true;
		
	}
	/*
	public Optional<ClockReport> getClockReportOptional() {
		return clockReportOpcional;
	}*/
/*
	public void setClockReportOptional(ClockReport clockReport) {
		this.clockReportOpcional = Optional.of(clockReport);
		System.out.println("criou optional");
	}
	*/

	private ClockRegistryLine clockRegistryLine;

	public void setTreeItemImp(TreeItemImp<String> treeItemImp) {
		this.treeItemImp = treeItemImp;
	}

	public ClockRegistryLine getClockRegistryLine() {
		return clockRegistryLine;
	}

	public void setClockRegistryLine(ClockRegistryLine clockRegistryLine) {
		this.clockRegistryLine = clockRegistryLine;
	}

	public TreeItemImp<String> getTreeItemImp() {
		return treeItemImp;
	}

	public int getNumberAsterisksParagraphBegins() {
		return beginsWithThisNumberOfAsterisks;
	}

	public void setNumberAsteriksParagraphBegins(int beginsWithThisNumberOfAsterisks) {
		this.beginsWithThisNumberOfAsterisks = beginsWithThisNumberOfAsterisks;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIndexOfParentInsideDocParagraphs() {
		return indexOfParentInsideDocParagraphsList;
	}

	public void setIndexOfParentInsideDocParagraphs(int indexOfParentInsideDocParagraphs) {
		this.indexOfParentInsideDocParagraphsList = indexOfParentInsideDocParagraphs;
	}
	
	public boolean hasClockReport() {
		return isClockReportPresent;
	}
}
