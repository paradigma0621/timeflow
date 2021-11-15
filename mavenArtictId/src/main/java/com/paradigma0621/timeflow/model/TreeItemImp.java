package com.paradigma0621.timeflow.model;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;

public class TreeItemImp<T> extends TreeItem<T> {

	private Paragraph paragraph;

	public TreeItemImp(T var1) {
		this(var1, (Node) null);
	}

	public TreeItemImp(T var1, Node var2) {
		this.setValue(var1);
		this.setGraphic(var2);
	}

	public boolean hasChildren() {
		return (getChildren().size() > 0) ? true : false;
	}

	public Paragraph getParagraph() {
		return paragraph;
	}

	public void setParagraph(Paragraph paragraph) {
		this.paragraph = paragraph;
	}
}
