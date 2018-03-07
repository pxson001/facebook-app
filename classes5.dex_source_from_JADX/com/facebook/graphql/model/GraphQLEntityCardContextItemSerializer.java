package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intercept_accept_button_label */
public class GraphQLEntityCardContextItemSerializer extends JsonSerializer<GraphQLEntityCardContextItem> {
    public final void m7082a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityCardContextItem__JsonHelper.m7084a(jsonGenerator, (GraphQLEntityCardContextItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityCardContextItem.class, new GraphQLEntityCardContextItemSerializer());
    }
}
