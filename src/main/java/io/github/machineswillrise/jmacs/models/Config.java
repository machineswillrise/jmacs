package io.github.machineswillrise.jmacs.models;

import java.util.Properties;

import javafx.beans.property.*;

public record Config(
	// Indentation settings
	BooleanProperty useTabs,
	BooleanProperty detectIndentation,
	IntegerProperty indentationSize,

	// Indentation guide settings
	BooleanProperty showIndentationGuide,
	IntegerProperty indentationGuideLocation,

	// Feature settings
	BooleanProperty enableLSP,
	BooleanProperty enableTabCompletions,
	BooleanProperty enableAIChat,

	// Theme settings
	BooleanProperty enableDarkTheme,
	StringProperty accentColor
)
{
	public static Config defaults()
	{
		return new Config(
			new SimpleBooleanProperty(true), 
			new SimpleBooleanProperty(true),
			new SimpleIntegerProperty(8),

			new SimpleBooleanProperty(true),
			new SimpleIntegerProperty(120),

			new SimpleBooleanProperty(true),
			new SimpleBooleanProperty(true),
			new SimpleBooleanProperty(true),

			new SimpleBooleanProperty(true),
			new SimpleStringProperty("#BF5AF2")
		);
	}

	public Properties toProperties()
	{
		Properties props = new Properties();

		props.setProperty("useTabs", String.valueOf(useTabs.get()));
		props.setProperty("detectIndentation", String.valueOf(detectIndentation.get()));
		props.setProperty("indentationSize", String.valueOf(indentationSize.get()));

		props.setProperty("showIndentationGuide", String.valueOf(showIndentationGuide.get()));
		props.setProperty("indentationGuideLocation", String.valueOf(indentationGuideLocation.get()));

		props.setProperty("enableLSP", String.valueOf(enableLSP.get()));
		props.setProperty("enableTabCompletions", String.valueOf(enableTabCompletions.get()));
		props.setProperty("enableAIChat", String.valueOf(enableAIChat.get()));

		props.setProperty("enableDarkTheme", String.valueOf(enableDarkTheme.get()));
		props.setProperty("accentColor", accentColor.get());

		return props;
	}
}
