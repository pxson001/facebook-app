package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gc */
public class GraphQLGraphSearchQueryFilterSerializer extends JsonSerializer<GraphQLGraphSearchQueryFilter> {
    public final void m8235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryFilter__JsonHelper.m8256a(jsonGenerator, (GraphQLGraphSearchQueryFilter) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilter.class, new GraphQLGraphSearchQueryFilterSerializer());
    }
}
