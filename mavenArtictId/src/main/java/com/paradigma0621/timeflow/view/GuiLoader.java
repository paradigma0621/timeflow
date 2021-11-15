package com.paradigma0621.timeflow.view;

import com.paradigma0621.timeflow.MainApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiLoader {

	private static Stage stage;

	public GuiLoader(Stage stagRef) {
		stage = stagRef;
		setRoot("GUI", "TimeFlowApplicationTitle");
	}

	@FXML
	static void setRoot(String fxml, String title) {
		Scene scene = new Scene(loadFXML(fxml));
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private static Parent loadFXML(String fxml) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
			return fxmlLoader.load();
		} catch (Exception e) {
			System.out.println("Error loading FXML file");
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
