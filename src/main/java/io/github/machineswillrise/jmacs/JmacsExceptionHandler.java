package io.github.machineswillrise.jmacs;

import java.awt.Desktop;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class JmacsExceptionHandler implements Thread.UncaughtExceptionHandler
{
	private String getStackTrace(Throwable e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	@Override
	public void uncaughtException(Thread t, Throwable e)
	{
		Alert error = new Alert(AlertType.INFORMATION);
		error.setTitle("Critical Error");
		error.setHeaderText("Sorry! Jmacs has crashed due to a critical error.");
		error.setContentText("Error: " + e.getMessage());

		var openGithubIssues = new ButtonType("Open GitHub Issues");
		var copyStackTrace = new ButtonType("Copy Stack Trace");
		error.getButtonTypes().setAll(copyStackTrace, openGithubIssues, ButtonType.CLOSE);

		Image logo = new Image(getClass().getResourceAsStream("/icons/jmacs.png"));
		ImageView logoView = new ImageView(logo);

		logoView.setFitWidth(64);
		logoView.setFitHeight(64);

		Optional<ButtonType> result = error.showAndWait();
		if (result.isPresent())
		{
			if (result.get() == openGithubIssues)
			{
				String issuePage = "https://github.com/machineswillrise/jmacs/issues";

				try
				{
					Desktop.getDesktop().browse(new URI(issuePage));
				}
				catch (IOException | URISyntaxException ex)
				{
					Alert openError = new Alert(AlertType.ERROR);
					openError.setTitle("Open Error");
					openError.setHeaderText("The issue page could noot be opened.");
					openError.setContentText("You can access it directly at " + issuePage);
				}
			}

			else if (result.get() == copyStackTrace)
			{
				Clipboard clipboard = Clipboard.getSystemClipboard();
				ClipboardContent content = new ClipboardContent();

				content.putString(getStackTrace(e));
				clipboard.setContent(content);
			}
		}
	}
}
