package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_first_party */
public class GraphQLBusinessInfoSerializer extends JsonSerializer<GraphQLBusinessInfo> {
    public final void m6704a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBusinessInfo__JsonHelper.m6706a(jsonGenerator, (GraphQLBusinessInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBusinessInfo.class, new GraphQLBusinessInfoSerializer());
    }
}
