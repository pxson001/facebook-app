package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_place_picker_report_dialog */
public class GraphQLDebugFeedEdgeSerializer extends JsonSerializer<GraphQLDebugFeedEdge> {
    public final void m6939a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDebugFeedEdge__JsonHelper.m6941a(jsonGenerator, (GraphQLDebugFeedEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLDebugFeedEdge.class, new GraphQLDebugFeedEdgeSerializer());
    }
}
