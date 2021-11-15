package com.paradigma0621.timeflow.view;


import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class TextAreaWriter {
	private static TextArea textArea;
	private static int fontSize = 33;
	
	public static void setTextArea(TextArea textArea) {
		TextAreaWriter.textArea = textArea;
		textArea.setStyle("-fx-font-size: 25");
	}
	
	public static void writeTextArea(String txt) {
		textArea.appendText(txt + "\n");
	}

	public static void clearTextArea() {
		textArea.clear();
	}

	public static void increaseFontDisplay() {
		fontSize++;
		textArea.setStyle("-fx-font-size: " + fontSize);
	}
	
	public static void decreaseFontDisplay() {
		fontSize--;
		textArea.setStyle("-fx-font-size: " + fontSize);
	}

}
