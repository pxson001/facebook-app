package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USERNAME_UNAVAILABLE */
public class GraphQLStreetAddressSerializer extends JsonSerializer<GraphQLStreetAddress> {
    public final void m21935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStreetAddress__JsonHelper.m21937a(jsonGenerator, (GraphQLStreetAddress) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStreetAddress.class, new GraphQLStreetAddressSerializer());
    }
}
