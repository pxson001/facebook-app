package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageMedium */
public class GraphQLEventWatchersEdgeSerializer extends JsonSerializer<GraphQLEventWatchersEdge> {
    public final void m7341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventWatchersEdge__JsonHelper.m7343a(jsonGenerator, (GraphQLEventWatchersEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventWatchersEdge.class, new GraphQLEventWatchersEdgeSerializer());
    }
}
