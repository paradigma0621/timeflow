package com.paradigma0621.timeflow;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.paradigma0621.timeflow.model.FileDataBase;
import com.paradigma0621.timeflow.model.OrgFileReader;

@SuppressWarnings("all")

public class TestOrgBeginningWithLogbook {
	static File file1 = new File("src/test/resources/logbookAtBeginning1.org");
	static File file2 = new File("src/test/resources/logbookAtBeginning2.org");

	private static final String fileName1 = file1.getAbsolutePath();
	private static final String fileName2 = file2.getAbsolutePath();

	
	public TestOrgBeginningWithLogbook() {

// TODO fazer o teste de umas 4 linhas de texto simples apenas no documento. com um LOGBOOK após eles
	}
	@Test
	public void parentProcess1() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();	
		loadDb.readDataFromFile(fileContent, fileName1);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		fileContent.unmountLogbookSectionLines();
		int numLinesOfFile = 7;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
	
	@Test
	public void parentProcess2() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();	
		loadDb.readDataFromFile(fileContent, fileName2);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		fileContent.unmountLogbookSectionLines();
		int numLinesOfFile = 21;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
}
