package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unexpected service start parameters */
public class GraphQLStatelessLargeImagePLAsConnectionSerializer extends JsonSerializer<GraphQLStatelessLargeImagePLAsConnection> {
    public final void m21820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStatelessLargeImagePLAsConnection__JsonHelper.m21822a(jsonGenerator, (GraphQLStatelessLargeImagePLAsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStatelessLargeImagePLAsConnection.class, new GraphQLStatelessLargeImagePLAsConnectionSerializer());
    }
}
