package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intercept_words */
public class GraphQLEntityCardContextItemLinkSerializer extends JsonSerializer<GraphQLEntityCardContextItemLink> {
    public final void m7079a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityCardContextItemLink__JsonHelper.m7081a(jsonGenerator, (GraphQLEntityCardContextItemLink) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityCardContextItemLink.class, new GraphQLEntityCardContextItemLinkSerializer());
    }
}
