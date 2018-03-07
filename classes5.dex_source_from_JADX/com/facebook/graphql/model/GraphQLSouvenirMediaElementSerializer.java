package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UnseenStoriesFeedUnit */
public class GraphQLSouvenirMediaElementSerializer extends JsonSerializer<GraphQLSouvenirMediaElement> {
    public final void m21747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenirMediaElement__JsonHelper.m21749a(jsonGenerator, (GraphQLSouvenirMediaElement) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenirMediaElement.class, new GraphQLSouvenirMediaElementSerializer());
    }
}
