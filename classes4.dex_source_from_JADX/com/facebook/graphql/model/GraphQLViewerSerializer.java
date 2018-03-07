package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: should_fetch_full_relevant_comments */
public class GraphQLViewerSerializer extends JsonSerializer<GraphQLViewer> {
    public final void m2385a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLViewer__JsonHelper.m2233a(jsonGenerator, (GraphQLViewer) obj, true);
    }

    static {
        FbSerializerProvider.m277a(GraphQLViewer.class, new GraphQLViewerSerializer());
    }
}
