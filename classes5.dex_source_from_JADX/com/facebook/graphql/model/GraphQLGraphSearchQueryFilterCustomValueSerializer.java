package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: geo_bounding_box */
public class GraphQLGraphSearchQueryFilterCustomValueSerializer extends JsonSerializer<GraphQLGraphSearchQueryFilterCustomValue> {
    public final void m8222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryFilterCustomValue__JsonHelper.m8224a(jsonGenerator, (GraphQLGraphSearchQueryFilterCustomValue) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilterCustomValue.class, new GraphQLGraphSearchQueryFilterCustomValueSerializer());
    }
}
