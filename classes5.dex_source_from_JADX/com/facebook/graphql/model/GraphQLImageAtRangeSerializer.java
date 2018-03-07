package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: follow_migration_flow */
public class GraphQLImageAtRangeSerializer extends JsonSerializer<GraphQLImageAtRange> {
    public final void m8621a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImageAtRange__JsonHelper.m8623a(jsonGenerator, (GraphQLImageAtRange) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLImageAtRange.class, new GraphQLImageAtRangeSerializer());
    }
}
