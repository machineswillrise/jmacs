package io.github.machineswillrise.jmacs.models;

import javafx.beans.property.*;

public record Config(
	// Indentation settings
	BooleanProperty useTabs,
	BooleanProperty detectIndentation,
	IntegerProperty indentationSize,

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
			new SimpleBooleanProperty(true),
			new SimpleBooleanProperty(true),
			new SimpleBooleanProperty(true),
			new SimpleStringProperty("#BF5AF2")
		);
	}
}
