package com.paradigma0621.timeflow.model.timeWorker;

import java.util.ArrayList;
import java.util.List;

public class ClockReport {

//	private Paragraph paragraphAbove;
	
	private List<ClockRegistryLine> clockRegistryLines;

	public ClockReport() {
		clockRegistryLines = new ArrayList<>();
	}
	
	public List<ClockRegistryLine> getClockRegistryLines() {
		return clockRegistryLines;
	}

	public void setClockLinesRegistry(List<ClockRegistryLine> clockLinesRegistry) {
		this.clockRegistryLines = clockLinesRegistry;
	}

	/*public Paragraph getParagraphAbove() {
		return paragraphAbove;
	}

	public void setParagraphAbove(Paragraph paragraphAbove) {
		this.paragraphAbove = paragraphAbove;
	}*/

	public long getTotalMinutesLocalBranch() {
		long minutes=0;
		for (ClockRegistryLine clock:clockRegistryLines) {
			minutes += clock.getElapsedMinutesCalculated(); 
		}
		return minutes;
	}
	
	public String getTotalMinutesLocalBranchString() {
		long minutes=getTotalMinutesLocalBranch();
		return  "Tempo: " + minutes;
	}
	
	
	/*
	public void setParagraphWithContentsAbove(List<Paragraph> docParagraphs, int lineAbove) {
		Paragraph paragraph = null;
		for (int j = 1; j <= lineAbove; j++) {
			paragraph = docParagraphs.get(lineAbove - j);
			if (!paragraph.getText().equals("")) {
				setParagraphAbove(paragraph);
				break;
			}
		}


		/*
		 * TODO Testar o aplicativo com a linha de baixo descomentada.... fazer @Tests
		 * (deixar primeira linha em branco também if (paragraph == null) {
		 * setParagraphAbove(docParagraphs.get(0)); //if not found anybody makes the
		 * first line of the ORG file the Paragraph Above }
		 */
	//}

}
