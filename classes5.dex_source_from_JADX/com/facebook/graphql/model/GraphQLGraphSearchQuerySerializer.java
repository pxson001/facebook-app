package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: game_challenge */
public class GraphQLGraphSearchQuerySerializer extends JsonSerializer<GraphQLGraphSearchQuery> {
    public final void m8258a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQuery__JsonHelper.m8266a(jsonGenerator, (GraphQLGraphSearchQuery) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQuery.class, new GraphQLGraphSearchQuerySerializer());
    }
}
