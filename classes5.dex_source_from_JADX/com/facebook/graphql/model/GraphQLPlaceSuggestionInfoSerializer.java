package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATCHED */
public class GraphQLPlaceSuggestionInfoSerializer extends JsonSerializer<GraphQLPlaceSuggestionInfo> {
    public final void m20917a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceSuggestionInfo__JsonHelper.m20919a(jsonGenerator, (GraphQLPlaceSuggestionInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceSuggestionInfo.class, new GraphQLPlaceSuggestionInfoSerializer());
    }
}
