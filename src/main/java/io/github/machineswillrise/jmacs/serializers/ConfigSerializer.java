package io.github.machineswillrise.jmacs.serializers;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;

import tools.jackson.databind.ser.std.StdSerializer;
import tools.jackson.databind.SerializationContext;

import io.github.machineswillrise.jmacs.models.Config;

public class ConfigSerializer extends StdSerializer<Config>
{
	public ConfigSerializer()
	{
		super(Config.class);
	}

	@Override
	public void serialize(Config value, JsonGenerator jgen, SerializationContext context) throws JacksonException
	{
		jgen.writeStartObject();
		jgen.writeBooleanProperty("use_tabs", value.useTabs().get());
		jgen.writeBooleanProperty("detect_indentation", value.detectIndentation().get());
		jgen.writeNumberProperty("indentation_size", value.indentationSize().get());
		jgen.writeBooleanProperty("enable_lsp", value.enableLSP().get());
		jgen.writeBooleanProperty("enable_tab_completions", value.enableTabCompletions().get());
		jgen.writeBooleanProperty("enable_ai_chat", value.enableAIChat().get());
		jgen.writeBooleanProperty("enable_dark_theme", value.enableDarkTheme().get());
		jgen.writeStringProperty("accent_color", value.accentColor().get());
		jgen.writeEndObject();
	}
}
