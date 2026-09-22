package io.github.machineswillrise.jmacs;

import javafx.application.Application;

import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JMacs extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);

		primaryStage.setTitle("JMacs");
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}