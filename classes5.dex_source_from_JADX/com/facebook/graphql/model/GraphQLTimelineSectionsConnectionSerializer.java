package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNDIRECTED */
public class GraphQLTimelineSectionsConnectionSerializer extends JsonSerializer<GraphQLTimelineSectionsConnection> {
    public final void m22222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineSectionsConnection__JsonHelper.m22224a(jsonGenerator, (GraphQLTimelineSectionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineSectionsConnection.class, new GraphQLTimelineSectionsConnectionSerializer());
    }
}
