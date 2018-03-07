package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: item */
public class GraphQLAppStoreApplicationSerializer extends JsonSerializer<GraphQLAppStoreApplication> {
    public final void m6573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAppStoreApplication__JsonHelper.m6575a(jsonGenerator, (GraphQLAppStoreApplication) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAppStoreApplication.class, new GraphQLAppStoreApplicationSerializer());
    }
}
