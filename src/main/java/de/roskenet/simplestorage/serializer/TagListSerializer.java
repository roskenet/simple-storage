package de.roskenet.simplestorage.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import de.roskenet.simplestorage.entity.Tag;

public class TagListSerializer extends JsonSerializer<List<Tag>>{

	@Override
	public void serialize(List<Tag> value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		jgen.writeStartArray();
		for (Tag tag : value) {
			jgen.writeString(tag.id);
		}
		jgen.writeEndArray();
		
	}

}
