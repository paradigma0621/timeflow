package com.paradigma0621.timeflow.view;


import javafx.scene.control.TreeView;
import javafx.scene.text.Font;

public class TreeViewResponsable {
	private static TreeView treeView;
	private static int fontSize = 33;
	public static void setTreeView(TreeView treeView) {
		TreeViewResponsable.treeView = treeView;
		treeView.setStyle("-fx-font-size: 25");
	}
	
	public static void increaseFontDisplay() {
		fontSize++;
		treeView.setStyle("-fx-font-size: " + fontSize);
	}
	
	public static void decreaseFontDisplay() {
		fontSize--;
		treeView.setStyle("-fx-font-size: " + fontSize);
	}

}
