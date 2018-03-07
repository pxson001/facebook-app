package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNIVERSITY */
public class GraphQLTimelineAppCollectionsConnectionSerializer extends JsonSerializer<GraphQLTimelineAppCollectionsConnection> {
    public final void m22172a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppCollectionsConnection__JsonHelper.m22174a(jsonGenerator, (GraphQLTimelineAppCollectionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppCollectionsConnection.class, new GraphQLTimelineAppCollectionsConnectionSerializer());
    }
}
