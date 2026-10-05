package io.github.machineswillrise.jmacs.controllers;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Properties;

import io.github.machineswillrise.jmacs.models.Config;

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

	public Properties loadConfig() throws IOException
	{
		Path configDirectory = findConfigDirectory();
		String configFileName = configDirectory.toString() + "/" + "config.properties";
		Config defaultConfig = Config.defaults();

		if (Files.notExists(configDirectory))
		{
			try (OutputStream fis = new FileOutputStream(configFileName))
			{
				Files.createDirectory(configDirectory);
				Properties newConfigFile = new Properties();
				newConfigFile.store(fis, "Jmacs Config");
				return newConfigFile;
			}
		}

		Properties configFile = new Properties();
		try (InputStream fis = new FileInputStream(configFileName))
		{
			configFile.load(fis);
			configFile.putAll(defaultConfig.toProperties());
			return configFile;
		}
	}
}