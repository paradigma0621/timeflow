package com.paradigma0621.timeflow;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.paradigma0621.timeflow.model.FileDataBase;
import com.paradigma0621.timeflow.model.OrgFileReader;
import com.paradigma0621.timeflow.model.timeWorker.ClockReport;

public class ClockReportTest {
	static File file = new File("src/test/resources/clockRegistries.org");
	private static final String fileName = file.getAbsolutePath();

	private OrgFileReader loadDb = new OrgFileReader();
	private FileDataBase fileContent = new FileDataBase();

	public ClockReportTest() {
		loadDb.readDataFromFile(fileContent, fileName);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		fileContent.unmountLogbookSectionLines();
	}

	@Test
	public void findLogBookClocks1() {
		String totalTimeLogBook1 = fileContent.getDocParagraphs()
			.get(4)
			.getClockReport()
			.map(ClockReport::getTotalMinutesLocalBranchString)
			.orElse("Não encontrou registros");
		assertEquals("Tempo: 830", totalTimeLogBook1);
		System.out.println("Total minutes do LOGBOOK 1:");
		System.out.println(totalTimeLogBook1);
	}
	
		@Test
		public void findLogBookClocks2() {
		String totalTimeLogBook2 = 	fileContent
			.getDocParagraphs()
			.get(14)
			.getClockReport()
			.map(ClockReport::getTotalMinutesLocalBranchString)
			.orElse("Não encontrou registros");
		assertEquals("Tempo: 2796", totalTimeLogBook2);
		System.out.println("Total minutes do LOGBOOK 2:");
		System.out.println(totalTimeLogBook2);
	}
		
		@Test
		public void findLogBookClocksWithoutLOGBOOK() {
		String totalTimeLogBook3 = fileContent.getDocParagraphs()
			.get(31)
			.getClockReport()
			.map(ClockReport::getTotalMinutesLocalBranchString)
			.orElse("Não encontrou registros");
		assertEquals("Não encontrou registros", totalTimeLogBook3);
		System.out.println("Total minutes do LOGBOOK 3:");
		System.out.println(totalTimeLogBook3);
	}

		@Test
		public void findLogBookClocksWithLogbookButWithouClockRegistryLines() {
		String totalTimeLogBook4 = fileContent.getDocParagraphs()
			.get(34)
			.getClockReport()
			.map(ClockReport::getTotalMinutesLocalBranchString)
			.orElse("Não encontrou registros");
		assertEquals("Tempo: 0", totalTimeLogBook4);
		System.out.println("Total minutes do LOGBOOK 4:");
		System.out.println(totalTimeLogBook4);
		
		System.out.println("Fim do Test");
	}
}
