package io.github.machineswillrise.jmacs.controllers;

import java.nio.file.Path;

public class ConfigController
{
	private Path findConfigDirectory()
	{
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows"))
		{
			return Path.of(System.getProperty("APPDATA"), "jmacs");
		}

		else if (os.contains("mac"))
		{
			return Path.of(System.getProperty("user.home"), "Library", "Application Support");
		}

		return Path.of(System.getProperty("user.home"), ".config", "jmacs");
	}
}