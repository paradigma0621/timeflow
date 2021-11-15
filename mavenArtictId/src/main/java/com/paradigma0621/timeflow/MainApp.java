package com.paradigma0621.timeflow;

import com.paradigma0621.timeflow.view.GuiLoader;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static Stage stagePrincipal;

	@Override
	public void start(Stage stage) throws Exception {
		stagePrincipal = stage;
		try {
			new GuiLoader(stage);
		} catch (Exception e) {
			System.out.println("Error in the start method: " + e.getMessage());
		}
	}

	public static Stage getStage() {
		return stagePrincipal;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
