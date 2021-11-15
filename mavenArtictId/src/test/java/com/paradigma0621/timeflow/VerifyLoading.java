package com.paradigma0621.timeflow;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.paradigma0621.timeflow.model.FileDataBase;
import com.paradigma0621.timeflow.model.OrgFileReader;

@SuppressWarnings("all")

public class VerifyLoading {
	static File fileEmpty = new File("src/test/resources/logbook.empty.org");
	static File file1 = new File("src/test/resources/logbook01.org");
	static File file2 = new File("src/test/resources/logbook02.org");
	static File file3 = new File("src/test/resources/logbook03.org");
	static File file4 = new File("src/test/resources/logbook04.org");
	private static final String fileEmptyName= fileEmpty.getAbsolutePath();
	private static final String fileName1 = file1.getAbsolutePath();
	private static final String fileName2 = file2.getAbsolutePath();
	private static final String fileName3 = file3.getAbsolutePath();
	private static final String fileName4 = file4.getAbsolutePath();
	
	
	@Test
	public void parentProcessFileEmpty() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();
		loadDb.readDataFromFile(fileContent, fileEmptyName);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		
		int numLinesOfFile = 0;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
	
	@Test
	public void parentProcess1() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();
		loadDb.readDataFromFile(fileContent, fileName1);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		
		int numLinesOfFile = 45;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
	
	@Test
	public void parentProcess2() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();
		loadDb.readDataFromFile(fileContent, fileName2);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		
		int numLinesOfFile = 7;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
	
	@Test
	public void parentProcess3() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();
		loadDb.readDataFromFile(fileContent, fileName3);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		
		int numLinesOfFile = 9;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
	
	@Test
	public void parentProcess4() {
		OrgFileReader loadDb = new OrgFileReader();
		FileDataBase fileContent = new FileDataBase();
		loadDb.readDataFromFile(fileContent, fileName4);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		
		int numLinesOfFile = 16;
		assertEquals(numLinesOfFile, fileContent.getDocParagraphs().size());
	}
}
