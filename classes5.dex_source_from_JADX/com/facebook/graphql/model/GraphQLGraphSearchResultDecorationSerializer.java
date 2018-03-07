package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fundraiser_for_charity_text */
public class GraphQLGraphSearchResultDecorationSerializer extends JsonSerializer<GraphQLGraphSearchResultDecoration> {
    public final void m8282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchResultDecoration__JsonHelper.m8284a(jsonGenerator, (GraphQLGraphSearchResultDecoration) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchResultDecoration.class, new GraphQLGraphSearchResultDecorationSerializer());
    }
}
