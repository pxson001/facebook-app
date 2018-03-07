package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_visibility */
public class GraphQLNewsFeedEdgeSerializer extends JsonSerializer<GraphQLNewsFeedEdge> {
    public final void m9261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNewsFeedEdge__JsonHelper.m9263a(jsonGenerator, (GraphQLNewsFeedEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNewsFeedEdge.class, new GraphQLNewsFeedEdgeSerializer());
    }
}
