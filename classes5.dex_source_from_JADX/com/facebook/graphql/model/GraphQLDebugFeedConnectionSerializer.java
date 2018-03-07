package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_place_tips */
public class GraphQLDebugFeedConnectionSerializer extends JsonSerializer<GraphQLDebugFeedConnection> {
    public final void m6933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDebugFeedConnection__JsonHelper.m6935a(jsonGenerator, (GraphQLDebugFeedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLDebugFeedConnection.class, new GraphQLDebugFeedConnectionSerializer());
    }
}
