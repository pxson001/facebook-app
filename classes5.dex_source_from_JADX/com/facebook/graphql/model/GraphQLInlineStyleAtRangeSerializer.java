package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: finalizeReferent */
public class GraphQLInlineStyleAtRangeSerializer extends JsonSerializer<GraphQLInlineStyleAtRange> {
    public final void m8702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInlineStyleAtRange__JsonHelper.m8704a(jsonGenerator, (GraphQLInlineStyleAtRange) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInlineStyleAtRange.class, new GraphQLInlineStyleAtRangeSerializer());
    }
}
