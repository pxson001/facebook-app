package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: find */
public class GraphQLInlineActivitySerializer extends JsonSerializer<GraphQLInlineActivity> {
    public final void m8695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInlineActivity__JsonHelper.m8697a(jsonGenerator, (GraphQLInlineActivity) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInlineActivity.class, new GraphQLInlineActivitySerializer());
    }
}
