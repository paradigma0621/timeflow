package com.paradigma0621.timeflow.model;

import com.paradigma0621.timeflow.view.TextAreaWriter;

import javafx.scene.control.TreeView;

public class AcessAllDescendenceOfOneSelectedTreeItem {

	public static void readCurrentLevel(FileDataBase fileContent, TreeView<String> treeView) {
		try { // Um possível erro do software que esse try captura é o pedir 
			  // relatório de itens não tendo selecionado nenhum TreeItem na
			  // TreeView
			TreeItemImp<String> treeItem = (TreeItemImp<String>) treeView.getSelectionModel().getSelectedItem();
	
			int itemIndex = treeItem.getParagraph().getLinePositionInsideDocParagraphsList(); // = index inside docParagraphs list that the treeItem is
	
			Paragraph myParagraph = fileContent.getDocParagraphs().get(itemIndex);
			int mainItemLevel = myParagraph.getNumberAsterisksParagraphBegins();
			System.out.println("Selected: " + myParagraph.getText());
			if (myParagraph.getTreeItemImp().hasChildren()) {
				System.out.println("has children!");
				TextAreaWriter.writeTextArea("Selected: " + myParagraph.getText());
				TextAreaWriter.writeTextArea("has children!");
				int totalTreeViewNumRowsSize = fileContent.getDocParagraphs().size();
				int nextItemIndex = itemIndex + 1; // get the Paragraphs bellow (inside docParagraphs), because they are the
													// candidates to be children of the current level
				int subParagraphLevel = getSubParagraphLevel(nextItemIndex, fileContent);
				// If the Paragraph bellow has level inferior of the selected Paragraph, it
				// isn't a children, the level ended
				while (((mainItemLevel < subParagraphLevel) || (subParagraphLevel == 0))
						&& (nextItemIndex <= totalTreeViewNumRowsSize - 1)) {
					writeSubParagraphContentInTextArea(nextItemIndex, fileContent);
					nextItemIndex++;
					if (nextItemIndex <= totalTreeViewNumRowsSize - 1)
						subParagraphLevel = getSubParagraphLevel(nextItemIndex, fileContent);
				}
			} else {
				System.out.println("children null");
				TextAreaWriter.writeTextArea("children null\n");
				TextAreaWriter.writeTextArea("Parent: " + myParagraph.getIndexOfParentInsideDocParagraphs());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static int getSubParagraphLevel(int nextItemIndex, FileDataBase fileContent) {
		// int totalTreeViewNumRowsSize = fileContent.getDocParagraphs().size();
		Paragraph subParagraph = fileContent.getDocParagraphs().get(nextItemIndex);
		int subParagraphLevel = subParagraph.getNumberAsterisksParagraphBegins();
		return subParagraphLevel;
	}

	public static void writeSubParagraphContentInTextArea(int nextItemIndex, FileDataBase fileContent) {
		Paragraph subParagraph = fileContent.getDocParagraphs().get(nextItemIndex);
		TextAreaWriter.writeTextArea(subParagraph.getText());
	}


	public static void readAllSubBranchesTimeLogs(FileDataBase fileContent, TreeView<String> treeView) {
		try { // Um possível erro do software que esse try captura é o pedir 
			  // relatório de itens não tendo selecionado nenhum TreeItem na
			  // TreeView
			TreeItemImp<String> treeItem = (TreeItemImp<String>) treeView.getSelectionModel().getSelectedItem();
	
			int itemIndex = treeItem.getParagraph().getLinePositionInsideDocParagraphsList(); // = index inside docParagraphs list that the treeItem is
	
			Paragraph myParagraph = fileContent.getDocParagraphs().get(itemIndex);
			int mainItemLevel = myParagraph.getNumberAsterisksParagraphBegins();
			System.out.println("Selected: " + myParagraph.getText());
			if (myParagraph.getTreeItemImp().hasChildren()) {
				System.out.println("has children!");
				TextAreaWriter.writeTextArea("Selected: " + myParagraph.getText());
				TextAreaWriter.writeTextArea("has children!");
				int totalTreeViewNumRowsSize = fileContent.getDocParagraphs().size();
				int nextItemIndex = itemIndex + 1; // get the Paragraphs bellow (inside docParagraphs), because they are the
													// candidates to be children of the current level
				int subParagraphLevel = getSubParagraphLevel(nextItemIndex, fileContent);
				// If the Paragraph bellow has level inferior of the selected Paragraph, it
				// isn't a children, the level ended
				while (((mainItemLevel < subParagraphLevel) || (subParagraphLevel == 0))
						&& (nextItemIndex <= totalTreeViewNumRowsSize - 1)) {
					writeSubParagraphTimeClockInTextArea(nextItemIndex, fileContent);
					nextItemIndex++;
					if (nextItemIndex <= totalTreeViewNumRowsSize - 1)
						subParagraphLevel = getSubParagraphLevel(nextItemIndex, fileContent);
				}
			} else if (!(myParagraph.getTreeItemImp().hasChildren())
					 &&(myParagraph.getClockReport() !=null)) {
				
				//int subParagraphLevel = getSubParagraphLevel(nextItemIndex, fileContent);
				//System.out.println("VER ESTE: " + myParagraph.getClockRegistryLine().toString());
				//System.out.println("VER ESTE: " + myParagraph.getClockReport().getClockRegistryLines().toString());
			}
			
			
			else {
				System.out.println("children null");
				TextAreaWriter.writeTextArea("children null\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void writeSubParagraphTimeClockInTextArea(int nextItemIndex, FileDataBase fileContent) {
		Paragraph subParagraph = fileContent.getDocParagraphs().get(nextItemIndex);
///		TextAreaWriter.writeTextArea(subParagraph.getText());
		//if (subParagraph.getClockReport() != null)
			TextAreaWriter.writeTextArea(subParagraph.getClockRegistryLine().toString());
			TextAreaWriter.writeTextArea(subParagraph.getClockReport().toString());
	}
}
