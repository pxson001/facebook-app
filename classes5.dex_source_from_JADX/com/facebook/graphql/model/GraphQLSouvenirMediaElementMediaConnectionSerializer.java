package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unsupported mimeType %s */
public class GraphQLSouvenirMediaElementMediaConnectionSerializer extends JsonSerializer<GraphQLSouvenirMediaElementMediaConnection> {
    public final void m21735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenirMediaElementMediaConnection__JsonHelper.m21737a(jsonGenerator, (GraphQLSouvenirMediaElementMediaConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenirMediaElementMediaConnection.class, new GraphQLSouvenirMediaElementMediaConnectionSerializer());
    }
}
