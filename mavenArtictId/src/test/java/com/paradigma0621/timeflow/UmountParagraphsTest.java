package com.paradigma0621.timeflow;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.paradigma0621.timeflow.model.FileDataBase;
import com.paradigma0621.timeflow.model.OrgFileReader;
import com.paradigma0621.timeflow.model.timeWorker.ClockReport;

public class UmountParagraphsTest {
	static File file = new File("src/test/resources/logbook05.org");
	private static final String fileName = file.getAbsolutePath();
	@Test
	public void findLogBookClocks() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();
		loadDb.readDataFromFile(fileContent, fileName);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();

		fileContent.unmountLogbookSectionLines();
		final long levelOfDocumentThatOneAsteriskParagraphsBelongs = -1; 
		assertEquals(levelOfDocumentThatOneAsteriskParagraphsBelongs, fileContent.getDocParagraphs().get(0).getIndexOfParentInsideDocParagraphs());
		assertEquals(levelOfDocumentThatOneAsteriskParagraphsBelongs, fileContent.getDocParagraphs().get(1).getIndexOfParentInsideDocParagraphs());
		assertEquals(levelOfDocumentThatOneAsteriskParagraphsBelongs, fileContent.getDocParagraphs().get(2).getIndexOfParentInsideDocParagraphs());
		
		assertEquals(2, fileContent.getDocParagraphs().get(3).getIndexOfParentInsideDocParagraphs());
		final long howManyMinutesInsideLOGBOOK = 406;
		long valueTesting = fileContent.getDocParagraphs().get(3).getClockReport().map(ClockReport::getTotalMinutesLocalBranch).orElse(0L);
		assertEquals(howManyMinutesInsideLOGBOOK, valueTesting); 
		//System.out.println(fileContent.getDocParagraphs().get(3).getClockReport().map(ClockReport::getTotalMinutesLocalBranchString).orElse("Sem Cursos"));


	}
}