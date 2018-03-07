package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_PHOTO_INLINE */
public class GraphQLSearchSuggestionUnitSerializer extends JsonSerializer<GraphQLSearchSuggestionUnit> {
    public final void m21607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSearchSuggestionUnit__JsonHelper.m21609a(jsonGenerator, (GraphQLSearchSuggestionUnit) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSearchSuggestionUnit.class, new GraphQLSearchSuggestionUnitSerializer());
    }
}
