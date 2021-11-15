module mavenArtictId {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	requires javafx.base;
	requires javafx.web;
	requires transitive javafx.graphics;

	exports com.paradigma0621.timeflow;
	exports com.paradigma0621.timeflow.model;
	exports com.paradigma0621.timeflow.model.timeWorker;
	exports com.paradigma0621.timeflow.controller;

	opens com.paradigma0621.timeflow to javafx.fxml;
	opens com.paradigma0621.timeflow.controller to javafx.fxml;
}
