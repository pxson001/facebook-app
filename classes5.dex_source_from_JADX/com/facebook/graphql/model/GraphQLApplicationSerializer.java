package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_verified_page */
public class GraphQLApplicationSerializer extends JsonSerializer<GraphQLApplication> {
    public final void m6586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLApplication__JsonHelper.m6588a(jsonGenerator, (GraphQLApplication) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLApplication.class, new GraphQLApplicationSerializer());
    }
}
