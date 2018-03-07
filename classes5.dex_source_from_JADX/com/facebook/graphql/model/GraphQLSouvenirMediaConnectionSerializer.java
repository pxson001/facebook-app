package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UriIntentBuilder */
public class GraphQLSouvenirMediaConnectionSerializer extends JsonSerializer<GraphQLSouvenirMediaConnection> {
    public final void m21705a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenirMediaConnection__JsonHelper.m21707a(jsonGenerator, (GraphQLSouvenirMediaConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenirMediaConnection.class, new GraphQLSouvenirMediaConnectionSerializer());
    }
}
