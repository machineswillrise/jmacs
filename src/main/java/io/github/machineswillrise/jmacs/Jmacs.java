package io.github.machineswillrise.jmacs;

import javafx.application.Application;

import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Jmacs extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		Pane root = new AnchorPane();
		Scene scene = new Scene(root, 800, 600);

		primaryStage.setTitle("Jmacs");
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.getIcons().add(
			new Image(getClass().getResourceAsStream("/icons/jmacs.png"))
		);

		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}