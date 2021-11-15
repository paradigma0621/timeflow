package com.paradigma0621.timeflow.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.paradigma0621.timeflow.model.timeWorker.ClockRegistryLine;
import com.paradigma0621.timeflow.model.timeWorker.ClockReport;

public class Tools {

	/**
     * Calculate the beginsWithThisNumberOfAsterisks parameter of the Paragraph object based in the number of  asterisks ("*") at the beginning of the line. 
     * @return 0 simple text level (not assigned with "*").
     * @return 1,2,3,.. levels started with the corresponding "*" numbers at the  beginning of the line.
	 */
	public static int calculateHowManyAsterisksTextBeginsWith(String text) { 
		if (!text.startsWith("*"))
			return 0; // 0: simple text (not categorized by "*" levels)
		for (int k = 0; k <= text.length(); k++) {
			if ((text.startsWith("*", k)) && (k == (text.length() - 1)))
				return (k + 1); // there is only asterisks in the line (not followed by text)
			if (text.startsWith("*", k))
				continue;
			if (text.startsWith(" ", k)) // found some asterisks before, now found the space between the asterisks and the beginning of the text
				return k; 
			return 0; // 0: simple text (not categorized by "*" levels)
		}
		return 0; // 0: simple text (not categorized by "*" levels)
	}

	public static void setTheClockReportParent(ClockReport clockReport, int i, List<Paragraph> docParagraphs) {
		int parentOfI = docParagraphs.get(i).getIndexOfParentInsideDocParagraphs();
		if (parentOfI==-1)  //The LOGBOOK comes at the beginning of the document after only simples text (none title paragraph) lines?
			docParagraphs.get(i).setClockReport(clockReport);
		else docParagraphs.get(parentOfI).setClockReport(clockReport);	
	}
	
	public static void setTheRegistryLinesClockReport(ClockReport clockReport, int i, List<Paragraph> docParagraphs) {
		for (int j = i + 1; j < docParagraphs.size(); j++) {
			//Implementar lógica no FOR de cima: se começar linha na sequência
			//com novo título ele fecha o processo no último CLOCK
			if (docParagraphs.get(j).getText().startsWith("CLOCK: ")) {
				ClockRegistryLine clockLine = new ClockRegistryLine(docParagraphs.get(j).getText());
				//docParagraphs.get(j).getClockReport().setClockLine(clockLine);
				clockReport.getClockRegistryLines().add(clockLine);
				docParagraphs.get(j).setClockReport(clockReport);
				docParagraphs.get(j).setClockRegistryLine(clockLine);
			}

			if (docParagraphs.get(j).getText().startsWith(":END:")) {
				docParagraphs.get(j).setClockReport(clockReport);
				break;
			}
		}		
	}
	
	public static List<Optional<ClockReport>> getClockReportDescendetsListOfTreeItem(TreeItemImp<String> ti, List<Paragraph> docParagraphs) {
		int selectedLinePosition = ti.getParagraph().getLinePositionInsideDocParagraphsList();
		Paragraph paragraph = docParagraphs.get(selectedLinePosition);
		int numAsteriksSelectedParagraph = paragraph.getNumberAsterisksParagraphBegins();
		List<Optional<ClockReport>> listOfClockReport = new ArrayList<>();
		if (paragraph.hasClockReport()) listOfClockReport.add(paragraph.getClockReport());
		
		for (selectedLinePosition++;selectedLinePosition < docParagraphs.size(); selectedLinePosition++) {
			paragraph = docParagraphs.get(selectedLinePosition);
			int numAsteriksCurrentParagraph = paragraph.getNumberAsterisksParagraphBegins();
			if ((numAsteriksCurrentParagraph <= numAsteriksSelectedParagraph)
				&&(numAsteriksCurrentParagraph != 0)) 
					break;
				System.out.println(paragraph.getText());
				if ((numAsteriksCurrentParagraph != 0)&&(paragraph.hasClockReport())) { 
					listOfClockReport.add(paragraph.getClockReport());
					System.out.println("Adicionado clockReport: " + paragraph.getText());
				}
		}
	return listOfClockReport;
	}
	
	public static void sumTotalClocksReport(List<Optional<ClockReport>> list) {
		long totalMinutesInBranch=0L;
		for(Optional<ClockReport> clockReport:list) {
		String totalTimeLogBook =
				clockReport.map(ClockReport::getTotalMinutesLocalBranchString)
				.orElse("Não encontrou registros");
		
		totalMinutesInBranch += clockReport.map(ClockReport::getTotalMinutesLocalBranch)
				.orElse(0L);
		
		System.out.println("totalTimeLogBook: " + totalTimeLogBook);
		
		
		}
		System.out.println("SumTotalTimeLogBook: " + totalMinutesInBranch + " minutes");
		System.out.println("SumTotalTimeLogBook: Hours: " + 
		(int)(totalMinutesInBranch/60) + 
		" - Minutes: " + (totalMinutesInBranch%60));
		
	}
}
