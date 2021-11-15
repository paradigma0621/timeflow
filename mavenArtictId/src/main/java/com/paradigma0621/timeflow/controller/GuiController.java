package com.paradigma0621.timeflow.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import com.paradigma0621.timeflow.MainApp;
import com.paradigma0621.timeflow.model.AcessAllDescendenceOfOneSelectedTreeItem;
import com.paradigma0621.timeflow.model.FileDataBase;
import com.paradigma0621.timeflow.model.OrgFileReader;
import com.paradigma0621.timeflow.model.Tools;
import com.paradigma0621.timeflow.model.TreeItemImp;
import com.paradigma0621.timeflow.model.TreeViewExplorer;
import com.paradigma0621.timeflow.model.timeWorker.ClockReport;
import com.paradigma0621.timeflow.view.TextAreaWriter;
import com.paradigma0621.timeflow.view.TreeViewResponsable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GuiController {

	Color color1 = Color.rgb(255, 255, 255);
	FileDataBase fileContent = new FileDataBase();

	static final File file = new File("src/main/resources/logbook05.org");

	
	private static final String fileName = file.getAbsolutePath();

	@FXML
	private Button btnImage, selectAndClick;

	@FXML
	private VBox vbox;

	@FXML
	private TreeView<String> treeView;

	@FXML
	private TextArea textArea;

	public void initialize() {
		TextAreaWriter.setTextArea(textArea);
		TreeViewResponsable.setTreeView(treeView);
		loadResourceList();

		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	public void pressionouTecla(KeyEvent key) {
		System.out.println("pressionou tecla...: " + key.getText());

		if (key.getText().equals("F")) { // Full Screen mode
			MainApp.getStage().setFullScreen(true);
			MainApp.getStage().setMaximized(true);
			System.out.println("PRESSED F");
		}

		if (key.getText().equals("J")) { // Full Screen mode
			TextAreaWriter.clearTextArea();
			AcessAllDescendenceOfOneSelectedTreeItem.readAllSubBranchesTimeLogs(fileContent, treeView);
		}
		
		if (key.getText().equals("u")) {
			TreeItemImp<String> tempTreeItem2 = (TreeItemImp<String>) treeView.getSelectionModel().getSelectedItem();
			if (tempTreeItem2.getParagraph().getClockRegistryLine() != null) {
				System.out.println("value selected: " + tempTreeItem2.getParagraph().getClockRegistryLine().toString());
			}
		}

		if (key.getText().equals("A")) {
			TreeItemImp<String> tempTreeItem2 = (TreeItemImp<String>) treeView.getSelectionModel().getSelectedItem();
			List<Optional<ClockReport>> lista = Tools.getClockReportDescendetsListOfTreeItem(tempTreeItem2, fileContent.getDocParagraphs());
			Tools.sumTotalClocksReport(lista);
			/*List<ClockRegistryLine> list = tempTreeItem2.getParagraph().getClockReport().getClockRegistryLines();

			for (ClockRegistryLine lineReg : list) {
				System.out.println("value selected: " + lineReg.toString());
			}
			*/
		}
		

		if (key.getText().equals("X")) {
			try {
		    	for (TreeItem<String> ti:treeView.getSelectionModel().getSelectedItems()) {
					TreeItemImp<String> treeItem = (TreeItemImp<String>) ti;
		        	System.out.println("h0X: " + treeItem.getValue());
		        }
			} catch (RuntimeException e) {
				System.out.println("Erro de seleção múltipla: " + e.getMessage());
			}
		}

		
		if (key.getText().equals("K")) {
			TreeItemImp<String> tempTreeItem2 = (TreeItemImp<String>) treeView.getSelectionModel().getSelectedItem();
			System.out.println(fileContent.getDocParagraphs().get(tempTreeItem2.getParagraph().getIndexOfParentInsideDocParagraphs()).getText());
		}
		
		if (key.getText().equals("+")) {
			TextAreaWriter.increaseFontDisplay();
			TreeViewResponsable.increaseFontDisplay();
			System.out.println("increase font size");
		}
		
		if (key.getText().equals("-")) {
			TextAreaWriter.decreaseFontDisplay();
			TreeViewResponsable.decreaseFontDisplay();
			System.out.println("decrease font size");
		}
		
		if (key.getText().equals("@")) {
			TreeItemImp<String> tempTreeItem2 = (TreeItemImp<String>) treeView.getSelectionModel().getSelectedItem();
			TreeCell<String> treeCell = TreeViewExplorer.findCellByItem(tempTreeItem2, treeView);
			treeCell.setStyle("-fx-font-size: 93");
			treeCell.setStyle("-fx-text-fill: #ADADAD; -fx-background: #FCFBA2");

		}
		

	}

	public void loadResourceList() {
		OrgFileReader loadDb = new OrgFileReader();
		loadDb.readDataFromFile(fileContent, fileName);
		fileContent.specifyReferencialParametersForAllParagraphsInsideDocParagraph();
		fileContent.findAParentForEachTreeItem();
		
		
		TreeItemImp<String> treeItemNodeBase = new TreeItemImp<>("ROOT");
		fileContent.createRelativesTreeItemsToParagraphsAndMakeTreeViewStructure(treeItemNodeBase);
		fileContent.unmountLogbookSectionLines();
		treeView.setRoot(treeItemNodeBase);
		vbox.requestFocus();
	}

	@FXML
	public void showListLog() {
		TextAreaWriter.clearTextArea();
		AcessAllDescendenceOfOneSelectedTreeItem.readCurrentLevel(fileContent, treeView);
		
	}

	@FXML
	public void loadColoredList() {

		MainApp.getStage().getScene().getStylesheets().add("style.css");

		treeView.setCellFactory(tv -> new TreeCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				getStyleClass().removeIf(s -> s.startsWith("depth"));
				// setDisclosureNode(null);
				if (empty || item == null) {
					setText("");
				} else {
					int depth = 0;
					for (TreeItem<String> i = getTreeItem(); i != null; i = i.getParent()) {

						// System.out.println("dentor do looop le: depth: " + depth);
						/*
						 * if (depth == 2) setStyle("-fx-text-fill: red"); if (depth == 1)
						 * setStyle("-fx-text-fill: blue"); if (depth == 3)
						 * setStyle("-fx-text-fill: green"); if (depth == 0)
						 * setStyle("-fx-text-fill: yellow"); //not read this one
						 */
						depth++;
					}
					getStyleClass().add("depth" + depth);
					setText(item);
				}
			}
		});

	}

}
