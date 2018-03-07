package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_permanently_closed */
public class GraphQLBackdatedTimeSerializer extends JsonSerializer<GraphQLBackdatedTime> {
    public final void m6632a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBackdatedTime__JsonHelper.m6634a(jsonGenerator, (GraphQLBackdatedTime) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBackdatedTime.class, new GraphQLBackdatedTimeSerializer());
    }
}
