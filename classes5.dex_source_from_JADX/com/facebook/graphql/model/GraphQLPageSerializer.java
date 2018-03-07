package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_hd */
public class GraphQLPageSerializer extends JsonSerializer<GraphQLPage> {
    public final void m9516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPage__JsonHelper.m9554a(jsonGenerator, (GraphQLPage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPage.class, new GraphQLPageSerializer());
    }
}
